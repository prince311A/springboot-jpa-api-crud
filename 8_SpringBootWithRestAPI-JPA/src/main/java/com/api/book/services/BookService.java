package com.api.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Service
public class BookService {
	@Autowired
	BookRepository repository;

	// get All books
	public List<Book> getAllBooks() {
		return this.repository.findAll();
	}

	// get single by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = repository.findByBookId(id);
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

		return book;
	}

	// add book
	public Book addBook(Book book) {
		repository.save(book);
		return book;
	}

	// delete book
	public Book deleteBook(int bookId) {
		Book book = getBookById(bookId);
		repository.delete(book);
		return book;
	}

	// update book
	public void updateBook(Book book, int bookId) {
		Book b = getBookById(bookId);
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());

	}
}
