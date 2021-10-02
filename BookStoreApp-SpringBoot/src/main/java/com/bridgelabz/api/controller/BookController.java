package com.bridgelabz.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.api.dto.BookDTO;
import com.bridgelabz.api.dto.ResponseDTO;
import com.bridgelabz.api.dto.UserDTO;
import com.bridgelabz.api.model.Book;
import com.bridgelabz.api.services.IBookService;
import com.bridgelabz.api.util.Response;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@GetMapping(value = {"","/"})
	List<Book> getBooks(){
//		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
//							bookService.getBooks()), HttpStatus.OK);
		return bookService.getBooks();
	}
	
	@GetMapping(value = "/{bookId}")
	public ResponseEntity<ResponseDTO> getBookById(@PathVariable("bookId") Long Book_id) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Get call success",
				bookService.getBookById(Book_id)), HttpStatus.OK);
	}
	
	@GetMapping(value = "bookname/{name}")
	public List<Book> getBookByName(@PathVariable("name") String name) {
		return bookService.getBookByName(name);
	}
	
	@GetMapping(value = "sort/{name}")
	public List<Book> sortHighToLow(@PathVariable("name") int name) {
		if(name == 1) {
			return bookService.sortByPriceHighToLOw("price");
		}else if (name == 2) {
			return bookService.sortByPriceLowToHigh("price");
		}else {
			return bookService.sortById();
		}
	}
	
	@PostMapping("/add")
	ResponseEntity<ResponseDTO> addBook(@RequestBody BookDTO bookDTO){
		
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Post call success",
				bookService.addBook(bookDTO)), HttpStatus.OK);
	}
	
	@PutMapping("/update/{bookId}")
	ResponseEntity<ResponseDTO> updateBook(@PathVariable("bookId") Long Book_id, @RequestBody BookDTO bookDTO){
		
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("Put call success",
				bookService.updateBook(Book_id, bookDTO)), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", bookId),
				HttpStatus.OK);
	}
	
	@PostMapping("/changeprice/{token}")
	public ResponseEntity<ResponseDTO> changePrice(@PathVariable("token") String token, @RequestParam(name = "book_id") Long book_id, @RequestParam Float price) {
		bookService.changeBookPrice(token, book_id, price);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", bookService.getBookById(book_id)),
				HttpStatus.OK);
	}
	
	@PostMapping("/changequantity/{token}")
	public ResponseEntity<ResponseDTO> changeQuantity(@PathVariable("token") String token, @RequestParam(name = "book_id") Long book_id, @RequestParam Long quantity) {
		bookService.changeBookQuantity(token, book_id, quantity);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", bookService.getBookById(book_id)),
				HttpStatus.OK);
	}
	
}
