package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.UserDTO;
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
	public User getUserById(Long userId) {
		return userRepo.findById(userId).orElse(null);
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
			
			return new Response(200, "User Successfully added", token);
	}

	@Override
	public Response updateUser(String token, UserDTO userDTO) {
		Long id = myToken.decodeToken(token);
		Optional<User> isUserPresent = userRepo.findById(id);
		
		if(!isUserPresent.isPresent()) {
			throw new UserRegisteredException(400, "Contact is not saved!!");
		}
		System.out.println("user to update  is"+ isUserPresent.get());
		User user = isUserPresent.get();
		user.updateUser(userDTO);
		userRepo.save(user);
		return new Response(200, "user updated succsessfull", user);
	}

	@Override
	public void deleteUser(Long userId) {
		User user = this.getUserById(userId);
		userRepo.delete(user);
	}
}
