package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.model.Order;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.repo.OrderRepository;
import com.bridgelabz.api.util.Token;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	Token myToken;
	
	@Autowired
	UserService userService;
	
	@Override
	public Order getBookById(Long order_id) {
		return orderRepo.findById(order_id).orElse(null);
	}
	
	@Override
	public Order placeOrder(String token, OrderDTO orderDTO) {
		Long id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent()) {
			Order order = new Order(orderDTO);
			order.setUser_id(id);
			return orderRepo.save(order);
		}
		return null;
	}

	@Override
	public Order updateOrder(Long order_id, OrderDTO orderDTO) {
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.getAllOrders();
	}

	@Override
	public List<Order> getAllOrderForUser(String token) {
		Long user_id = myToken.decodeToken(token);
		return orderRepo.getAllOrdersByUserId(user_id);
	}

	@Override
	public String cancelOrder(Long order_id) {
		Optional<Order> isPresent = orderRepo.findById(order_id);
		if(isPresent.isPresent()) {
			isPresent.get().setCancel(true);
			orderRepo.save(isPresent.get());
			return "Order is cancelled";
		} 
		
		return "order is not present";
	}
}
