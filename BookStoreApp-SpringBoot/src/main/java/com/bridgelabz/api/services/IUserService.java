package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.api.dto.UserDTO;
import com.bridgelabz.api.dto.VerifyUser;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.util.Response;

public interface IUserService {
	
	List<User> getUsers();
	
	List<User> findByName(String name);
	
	Optional<User> getUserByEmailId(String emailId);
	
	Optional<User> getUserById(Long userId);
	
	List<User>sortByName(String name);
	
	Response addUser(UserDTO userDTO);
	
	Response loginUser(String email, String password);
	
	Response forgotPassword(String token, String psw);
	
	Response verifyUser(VerifyUser User);
	
	Response updateUser(String token, UserDTO userDTO);
	
	void deleteUser(String token);
}
