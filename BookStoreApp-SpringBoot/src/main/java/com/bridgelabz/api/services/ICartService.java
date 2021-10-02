package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.model.Cart;

public interface ICartService {
	
	Cart addCart(CartServiceDTO carServiceDTO);

	void removeFromCart(Long cart_id);
	void removeAllCarts(String token);
	
	void updateQuantity(String token, Long cart_id, Long quantity);
	
	List<Cart> findAllCarts(String token);
		
}
