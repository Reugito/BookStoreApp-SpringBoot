package com.bridgelabz.api.services;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.model.Cart;

public interface ICartService {
	
	Cart addCart(CartServiceDTO carServiceDTO);

	void removeFromCart(Long cart_id);
	
	void updateQuantity(Long cart_id);
}
