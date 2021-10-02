package com.bridgelabz.api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.model.Cart;

import lombok.Data;

@Data
public class OrderDTO {
	
	public LocalDateTime order_date = LocalDateTime.now();
	
	public String first_name;
	
	public String phone_no;
	
	public String pin_code;
	
	public String locality;
	
	public String city;
	
	public String landmark;
	
	public String type;
	
	public Long quantity;
	
	public Float price;
	
	public String address;
	
	public Long user_id;
	
	public List<Book> book_id;
	
	public Boolean cancel = false;

}
