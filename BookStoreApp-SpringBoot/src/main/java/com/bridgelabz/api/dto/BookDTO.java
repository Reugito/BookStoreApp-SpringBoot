package com.bridgelabz.api.dto;

import lombok.Data;

@Data
public class BookDTO {
	
	public String name;
	
	public String author;
	
	public String description;
	
	public String logo;
	
	public Float price;
	
	public Long quantity;

}
