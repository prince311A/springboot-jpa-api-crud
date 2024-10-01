package com.api.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
	public Book findByBookId(int bookId);

}
