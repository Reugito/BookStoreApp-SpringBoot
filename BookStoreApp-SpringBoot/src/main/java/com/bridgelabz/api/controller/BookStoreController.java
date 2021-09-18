package com.bridgelabz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.dto.UserDTO;
import com.bridgelabz.api.services.IUserService;
import com.bridgelabz.api.services.UserService;
import com.bridgelabz.api.util.Response;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = {"", "/"})
	ResponseEntity<ResponseDTO> getUsers(){
		return new ResponseEntity<ResponseDTO> (new ResponseDTO("Get Call Success",
		 userService.getUsers()), HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<ResponseDTO> getUserbyId(@PathVariable("userId") Long userId) {
		
		 return new ResponseEntity<ResponseDTO>( new
		 ResponseDTO("Get Call By Id Success",
		 userService.getUserById(userId)), HttpStatus.OK);
		 
	}
	
	@GetMapping("/useremail/{emailId}")
	public ResponseEntity<ResponseDTO> getUserByEmailId(@PathVariable("emailId") String emailId) {
		
		 return new ResponseEntity<ResponseDTO>( new
		 ResponseDTO("Get Call By Id Success",
		 userService.getUserByEmailId(emailId)), HttpStatus.OK);
		 
	}
	
	@PostMapping("/adduser")
	ResponseEntity<Response> addUser(@RequestBody UserDTO userDTO){
//		return new ResponseEntity<ResponseDTO>( new ResponseDTO("addCall Success",
//				 userService.addUser(userDTO)), HttpStatus.OK);
		Response response = userService.addUser(userDTO);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{token}")
	ResponseEntity<Response> updateUser(@PathVariable("token") String token,
									@RequestBody UserDTO userDTO){
//		return new ResponseEntity<ResponseDTO>(new ResponseDTO("updated adressBook data",
//				userService.updateUser(userId, userDTO)), HttpStatus.OK);
		Response resp = userService.updateUser(token, userDTO);
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", userId),
				HttpStatus.OK);
	}
}
