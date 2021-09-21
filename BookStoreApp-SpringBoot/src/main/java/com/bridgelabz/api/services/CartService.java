package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.model.Cart;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.repo.CartRepository;
import com.bridgelabz.api.util.Token;

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
		Optional<User> user = userService.getUserById(carServiceDTO.user_id);
		Book book = bookService.getBookById(carServiceDTO.book_id);
		Cart cart = new Cart(user.get(), book, carServiceDTO.quantity);
		return cartRepo.save(cart);
	}

	@Override
	public void removeFromCart(Long cart_id) {
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
		System.out.println("user_i = "+user_id);
		Optional<User> user = userService.getUserById(user_id);
		if(user.isPresent()) {
			System.out.println(cartRepo.findAllCartsByUserId(user_id));
			return cartRepo.findAllCartsByUserId(user_id);
		}
		return null;
	}
}
