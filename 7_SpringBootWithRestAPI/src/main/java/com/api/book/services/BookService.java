package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.entities.Book;

@Service
public class BookService {
	static private List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(22, "Java Programming", "James Gosling"));
		list.add(new Book(33, "C language", "Denish Richie"));
		list.add(new Book(44, "C++", "Bejarne Stursstroop"));
	}

	// get All books
	public List<Book> getAllBooks() {
		return list;
	}

	// get single by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getBookId() == id).findFirst().get();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
		return book;
	}

	// add book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	// delete book
	public Book deleteBook(int bookId) {
		Book book = getBookById(bookId);
		list.remove(book);
		return book;
	}
	// update book
	public void updateBook(Book book, int bookId) {
		list.stream().map(b->{
			
			if(b.getBookId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
			
		}).collect(Collectors.toList());
	}
}
