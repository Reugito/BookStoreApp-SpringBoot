package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.UserDTO;
import com.bridgelabz.api.dto.VerifyUser;
import com.bridgelabz.api.exception.UserRegisteredException;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.repo.UserRepository;
import com.bridgelabz.api.util.Response;
import com.bridgelabz.api.util.Token;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	Token myToken;
	
	@Autowired
	MyEmailService emailService;
	
	@Autowired
	OTPService otpService;
	
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepo.findById(userId);
	}
	
	@Override
	public Optional<User> getUserByEmailId(String emailId) {
		return userRepo.findByEmailid(emailId);
	}

	@Override
	public List<User> sortByName(String name) {
		return null;
	}

	@Override
	public Response addUser(UserDTO userDTO) {
		Optional<User> isPresent = userRepo.findByEmailid(userDTO.getEmail_id());
		if(isPresent.isPresent()) {
			throw new UserRegisteredException(400, "User already present");
		} 
			User user = new User (userDTO);
			userRepo.save(user);
			
			String token = myToken.createToken(user.getUser_id());
			
			int otp = otpService.generateOTP(userDTO.email_id);
			
			emailService.sendOTPMessage(userDTO.email_id, "Registration OTP","Token = "+token
																		+"Your OTP = "+otp);
			return new Response(200, "User Successfully added", token);
	}
	
	@Override
	public Response loginUser(String email, String password) {
		Optional<User> isPresent = userRepo.findByEmailid(email);
		if(isPresent.isPresent()) {
			if(isPresent.get().getPassword().equals(password)) {
				
				String token = myToken.createToken(isPresent.get().getUser_id());
				return new Response(200, "User Login Successfully ", token);
				
			}
		} 
		return new Response(200, "User Login Failed", "try again");
	}
	

	@Override
	public Response verifyUser(VerifyUser uservar) {
		Optional<User> isPresent = userRepo.findByEmailid(uservar.getEmail_id());
		if(isPresent.isPresent()) {
			
			User user = isPresent.get();
			if(otpService.getOTP(uservar.getEmail_id()) == uservar.getOtp()) {
				user.setVerify(true);
				userRepo.save(user);
				return new Response(200, "User Successfully verified", isPresent);
			}
		}
		return new Response(200, "Wrong OTP", null);
	}

	@Override
	public Response updateUser(String token, UserDTO userDTO) {
		Long id = myToken.decodeToken(token);
		Optional<User> isUserPresent = userRepo.findById(id);
		
		if(!isUserPresent.isPresent()) {
			throw new UserRegisteredException(400, "User is not present!!");
		}
		System.out.println("user to update  is"+ isUserPresent.get());
		User user = isUserPresent.get();
		user.updateUser(userDTO);
		userRepo.save(user);
		return new Response(200, "user updated succsessfull", user);
	}
	
	@Override
	public void deleteUser(String token) {
		Long id = myToken.decodeToken(token);
		Optional<User> user = this.getUserById(id);
		if(user.isPresent()) {
			userRepo.delete(user.get());
		}
	}

	@Override
	public Response forgotPassword(String token, String psw) {

		Optional<User> isUserPresent = userRepo.findByEmailid(token);
		
		if(!isUserPresent.isPresent()) {
			throw new UserRegisteredException(400, "User is not present!!");
		}
		User user = isUserPresent.get();
		user.setPassword(psw);
		userRepo.save(user);
		return new Response(200, "pasword updated succsessfully", user);
	}
}
