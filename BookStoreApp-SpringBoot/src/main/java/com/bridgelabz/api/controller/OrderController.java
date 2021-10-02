package com.bridgelabz.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.OrderDTO;
import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.services.IOrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping(value = "getorders/{token}")
	public ResponseEntity<ResponseDTO> getOrderByUser(@PathVariable("token") String token) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.getAllOrderForUser(token)), HttpStatus.OK);
	}
	
	@PutMapping("cancel/{orderId}")
	public String cancelOrder(@PathVariable("orderId") Long orderId) {
		System.out.println("order id = "+ orderId);
		orderService.cancelOrder(orderId);
		return "Order cancelled";
	}
	
	@PostMapping("/add/{token}")
	public ResponseEntity<ResponseDTO> placeOrder(@PathVariable("token") String token, @RequestBody OrderDTO orderDTO) {
		System.out.println("dhgf----> "+orderDTO);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				orderService.placeOrder(token, orderDTO)), HttpStatus.OK);
	}
	
}
