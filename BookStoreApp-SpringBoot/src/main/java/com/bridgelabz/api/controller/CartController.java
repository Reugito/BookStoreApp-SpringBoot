package com.bridgelabz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.services.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@PostMapping("/add")
	ResponseEntity<ResponseDTO> addBook(@RequestBody CartServiceDTO cartDTO){
		System.out.println("add cart"+cartDTO);
		
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Post call success",
				cartService.addCart(cartDTO)), HttpStatus.OK);
	}

}
