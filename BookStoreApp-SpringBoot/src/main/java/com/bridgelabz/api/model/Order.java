package com.bridgelabz.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.api.dto.OrderDTO;

import lombok.Data;

@Entity
@Table(name = "order_details")
public @Data class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long order_id;
	
	private LocalDateTime order_date;
	
	private Long quantity;
	
	private Float price;
	
	private String address;
	
	private Long user_id;
	
	private Long  book_id;
	
	private Boolean cancel = false;

	public Order() {}

	public void update(OrderDTO orderDTO) {
		this.quantity = orderDTO.quantity;
		this.price = orderDTO.price;
		this.address = orderDTO.address;
		this.book_id = orderDTO.book_id;
	}



	public Order(OrderDTO orderDTO) {
		this.order_date = orderDTO.order_date;
		this.quantity = orderDTO.quantity;
		this.price = orderDTO.price;
		this.address = orderDTO.address;
		this.user_id = orderDTO.user_id;
		this.book_id = orderDTO.book_id;
	}
}
