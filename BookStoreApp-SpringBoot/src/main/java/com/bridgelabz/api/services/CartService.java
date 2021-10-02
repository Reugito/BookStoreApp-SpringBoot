package com.bridgelabz.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.model.Cart;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.repo.CartRepository;
import com.bridgelabz.api.util.Token;
import com.sun.mail.util.logging.CollectorFormatter;

@Service
public class CartService implements ICartService {
	
	@Autowired
	CartRepository cartRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	Token myToken;

	@Override
	public Cart addCart(CartServiceDTO carServiceDTO) {
		Long user_id = myToken.decodeToken(carServiceDTO.user_id);
		Optional<User> user = userService.getUserById(user_id);
		if(user.isPresent()) {
			Book book = bookService.getBookById(carServiceDTO.book_id);
			Cart cart = new Cart(user.get(), book, carServiceDTO.quantity);
			return cartRepo.save(cart);
			
		}
		return null;
	}

	@Override
	public void removeFromCart(Long cart_id) {
		System.out.println("deleted");
		cartRepo.deleteById(cart_id);
	}

	@Override
	public void updateQuantity(String token, Long cart_id, Long quantity) {
		Long id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent()) {
			Cart cart = cartRepo.getById(cart_id);
			cart.setQuantity(quantity);
			cartRepo.save(cart);
		}
	}

	@Override
	public List<Cart> findAllCarts(String token) {
		Long user_id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(user_id);
		if(user.isPresent()) {
			List<Cart> carts = cartRepo.findAllCartsByUserId(user_id);
			return carts;
		}
		return null;
	}

	@Override
	public void removeAllCarts(String token) {
		Long user_id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(user_id);
		if(user.isPresent()) {
			List<Cart> carts = cartRepo.findAllCartsByUserId(user_id);
			cartRepo.deleteAll(carts);
		}	
	}
}
