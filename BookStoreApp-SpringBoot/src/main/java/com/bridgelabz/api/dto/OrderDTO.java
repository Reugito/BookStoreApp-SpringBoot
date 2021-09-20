package com.bridgelabz.api.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDTO {
	
	public LocalDateTime order_date = LocalDateTime.now();
	
	public Long quantity;
	
	public Float price;
	
	public String address;
	
	public Long user_id;
	
	public Long  book_id;
	
	public Boolean cancel = false;

}
