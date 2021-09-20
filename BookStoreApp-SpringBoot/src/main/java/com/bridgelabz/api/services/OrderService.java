package com.bridgelabz.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.model.Order;
import com.bridgelabz.api.repo.OrderRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public Order getBookById(Long order_id) {
		return orderRepo.findById(order_id).orElse(null);
	}
	
	@Override
	public Order placeOrder(OrderDTO orderDTO) {
		Order order = new Order(orderDTO);
		return orderRepo.save(order);
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
	public List<Order> getAllOrderForUser(Long user_id) {
		return orderRepo.getAllOrdersByUserId(user_id);
	}

	@Override
	public void cancelOrder(Long user_id) {
		orderRepo.calcelOrder(user_id);
		
	}
}
