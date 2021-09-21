package com.bridgelabz.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bridgelabz.api.dto.CartServiceDTO;

import lombok.Data;

@Entity
@Table(name = "cart_service")
public @Data class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cart_id;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id")
	    private User user;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "book_id")
	    private Book book;
	 
	 private Long quantity;

	public Cart() {
	}

	public Cart(User user, Book book, Long quantity) {
		this.user = user;
		this.book = book;
		this.quantity = quantity;
	}	 
}
