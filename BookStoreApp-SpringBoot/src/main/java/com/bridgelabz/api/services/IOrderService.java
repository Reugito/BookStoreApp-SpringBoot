package com.bridgelabz.api.services;

import java.util.List;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.model.Order;

public interface IOrderService {
	
	Order getBookById(Long order_id);
	
	Order placeOrder(OrderDTO orderDTO);
	
	Order updateOrder(Long order_id, OrderDTO orderDTO);
	
	List<Order> getAllOrders();
	
	List<Order> getAllOrderForUser(Long user_id);
	
	void cancelOrder(Long user_id);

}
