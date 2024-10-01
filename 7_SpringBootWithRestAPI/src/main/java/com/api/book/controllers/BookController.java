package com.api.book.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.api.book.entities.Book;
import com.api.book.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// @RequestMapping(value = "/books",method = RequestMethod.GET)
	////////////////////////////////////////////////////////////////////////////
	// Demo of GetMApping --> Get all Book Handler
	@GetMapping("/books")
//    @ResponseBody    
	// to send Http status we use ResponseEntity
//    public List<Book> getBooks(){
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = this.bookService.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/books/{id}") // Get Single Book Handler
//	public Book getBook(@PathVariable("id") int id) {
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);

		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	////////////////////////////////////////////////////////////////////////////
	// Demo of PostMapping --> Create Book Handler
	@PostMapping("/books")
	public ResponseEntity<Book> addingBook(@RequestBody Book book) { // @RequestBody binds all the data come from server
																		// to its
		Book book2 = null; // corresponding entity
		try {
			book2 = this.bookService.addBook(book);
			System.out.println(book2);
			return ResponseEntity.of(Optional.of(book2));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	///////////////////////////////////////////////////////////////////////////
	// Demo of DeleteMapping ---> Delete Book Handler
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity<Book> deletingBook(@PathVariable("bookid") int bookid) {
		Book book = null;
		try {
			book = this.bookService.deleteBook(bookid);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	///////////////////////////////////////////////////////////////////////////
	// Demo of PutMapping ---> update Book Handler
	@PutMapping("/books/{bookid}")
	public ResponseEntity<Book> updatingBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
		try {
			this.bookService.updateBook(book, bookid);
			System.out.println(book);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					
		}
	}

}
