package com.bridgelabz.api.dto;

import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.model.User;

import lombok.Data;

@Data
public class CartServiceDTO {
	
	public Long user_id;
	
	public Long book_id;
	
	public Long quantity;

}
