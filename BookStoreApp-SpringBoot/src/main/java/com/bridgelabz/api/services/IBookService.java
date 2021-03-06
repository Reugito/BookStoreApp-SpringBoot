package com.bridgelabz.api.services;

import java.util.List;

import com.bridgelabz.api.dto.BookDTO;
import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.util.Token;

public interface IBookService {
	
	List<Book> getBooks();
	
	List<Book> sortByPriceHighToLOw(String name);
	
	List<Book> sortByPriceLowToHigh(String name);
	
	List<Book> sortById();
	
	Book getBookById(Long book_id);
	
	List<Book> getBookByName(String name);
	
	Long getBookPriceById(Long book_id);
	
	Book addBook(BookDTO bookDTO);
	
	Book updateBook(Long book_id, BookDTO bookDTO);
	
	void changeBookQuantity(String token, Long book_id, Long quantity);
	
	void changeBookPrice(String token, Long book_id, Float price);
	
	void deleteBook(Long book_id);

}
