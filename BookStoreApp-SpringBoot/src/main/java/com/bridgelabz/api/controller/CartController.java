package com.bridgelabz.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.model.Cart;
import com.bridgelabz.api.services.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@PostMapping("/add")
	ResponseEntity<ResponseDTO> addToCart(@RequestBody CartServiceDTO cartDTO){
		
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Post call success",
				cartService.addCart(cartDTO)), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{cartId}")
	ResponseEntity<ResponseDTO> removeFromCart(@PathVariable("cartId") Long cartId){
		cartService.removeFromCart(cartId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Delete call success",""), HttpStatus.OK);
	}
	
	@PutMapping("/update/{token}")
	ResponseEntity<ResponseDTO> updateCart(@PathVariable("token") String token, @RequestParam("cart_id")Long cartId,
			@RequestParam("quantity") Long quantity){
		cartService.updateQuantity(token, cartId, quantity);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Post call success",
				""), HttpStatus.OK);
	}
	
	@GetMapping("get/{token}")
	String findAllCartsByUser(@PathVariable("token") String token){
		cartService.findAllCarts(token);
		return ""+cartService.findAllCarts(token);
	}
}
