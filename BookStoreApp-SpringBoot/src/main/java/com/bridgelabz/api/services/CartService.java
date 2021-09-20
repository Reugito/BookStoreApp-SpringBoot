package com.bridgelabz.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.model.Cart;
import com.bridgelabz.api.repo.CartRepository;

@Service
public class CartService implements ICartService {
	
	@Autowired
	CartRepository cartRepo;

	@Override
	public Cart addCart(CartServiceDTO carServiceDTO) {
		Cart cart = new Cart(carServiceDTO);
		return cartRepo.save(cart);
	}

	@Override
	public void removeFromCart(Long cart_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuantity(Long cart_id) {
		// TODO Auto-generated method stub
		
	}


}
