package com.bridgelabz.api.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bridgelabz.api.dto.CartServiceDTO;
import com.bridgelabz.api.dto.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "order_details")
public @Data class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long order_id;
	
	private String first_name;
	
	private String phone_no;
	
	private String pin_code;
	
	private String locality;
	
	private String city;
	
	private String landmark;
	
	private String type;
	
	private LocalDateTime order_date;
	
	private Long quantity;
	
	private Float price;
	
	private String address;
	
	private Long user_id;
	
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@ManyToMany
	private List<Book>  book_id;
	
	private Boolean cancel = false;

	public Order() {}

	public void update(OrderDTO orderDTO) {
		this.quantity = orderDTO.quantity;
		this.price = orderDTO.price;
		this.address = orderDTO.address;
		//this.book_id = orderDTO.book_id;
	}



	public Order(OrderDTO orderDTO) {
		
		this.first_name = orderDTO.first_name;
		this.phone_no = orderDTO.phone_no;
		this.pin_code = orderDTO.pin_code;
		this.locality = orderDTO.locality;
		this.city = orderDTO.city;
		this.landmark = orderDTO.landmark;
		this.type = orderDTO.type;
		this.order_date = orderDTO.order_date;
		this.quantity = orderDTO.quantity;
		this.price = orderDTO.price;
		this.address = orderDTO.address;
		this.user_id = orderDTO.user_id;
		this.book_id= orderDTO.book_id;
	}

}
