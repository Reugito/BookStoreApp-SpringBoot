package com.bridgelabz.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.api.dto.BookDTO;
import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.model.User;
import com.bridgelabz.api.repo.BookRepository;
import com.bridgelabz.api.util.Token;

@Service
public class BookService implements IBookService {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	Token myToken;
	
	@Autowired
	UserService userService;

	@Override
	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(Long book_id) {
		return bookRepo.findById(book_id).orElse(null);
	}

	@Override
	public Book addBook(BookDTO bookDTO) {
		Book book = new Book(bookDTO);
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(Long book_id, BookDTO bookDTO) {
		Book book = this.getBookById(book_id);
		book.updateBook(bookDTO);
		return bookRepo.save(book);
	}

	@Override
	public void deleteBook(Long book_id) {
		Book book = this.getBookById(book_id);
		bookRepo.delete(book);
	}

	@Override
	public void changeBookQuantity(String token, Long book_id, Long quantity) {
		Long id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent()) {
			Book book = this.getBookById(book_id);
			book.setQuantity(quantity);
			bookRepo.save(book);
		}
	}

	@Override
	public void changeBookPrice(String token, Long book_id, Float price) {
		Long id = myToken.decodeToken(token);
		Optional<User> user = userService.getUserById(id);
		if(user.isPresent()) {
			Book book = this.getBookById(book_id);
			book.setPrice(price);
			bookRepo.save(book);
		}
	}

}
