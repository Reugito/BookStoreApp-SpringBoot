package com.bridgelabz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.services.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	@GetMapping(value = "/{orderId}")
	public ResponseEntity<ResponseDTO> getOrderById(@PathVariable("orderId") Long order_id) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.getBookById(order_id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getallorders")
	public ResponseEntity<ResponseDTO> getAllOrders() {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.getAllOrders()), HttpStatus.OK);
	}
	
	@GetMapping(value = "getorders/{userId}")
	public ResponseEntity<ResponseDTO> getOrderByUser(@PathVariable("userId") Long user_id) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.getAllOrderForUser(user_id)), HttpStatus.OK);
	}
	
	@GetMapping("cancel/{userId}")
	public String cancelOrder(@PathVariable("userId") Long user_id) {
		orderService.cancelOrder(user_id);
		return "Order cancelled";
	}
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.placeOrder(orderDTO)), HttpStatus.OK);
	}
	
}
