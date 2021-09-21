package com.bridgelabz.api.services;

import java.util.List;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.model.Order;

public interface IOrderService {
	
	Order getBookById(Long order_id);
	
	Order placeOrder(String token, OrderDTO orderDTO);
	
	Order updateOrder(Long order_id, OrderDTO orderDTO);
	
	List<Order> getAllOrders();
	
	List<Order> getAllOrderForUser(String token);
	
	String cancelOrder(Long order_id);

}
