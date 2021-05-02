package com.apipothi.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apipothi.example.dao.Book;
import com.apipothi.example.service.Bookservice;

/*
 * http://localhost:8080/books/{booksId}
 * */

@RestController
public class Bookcontroller {

	@Autowired
	Bookservice bookservice;

	@GetMapping("/books/{booksId}")
	public List<Book> getBookDetails(@PathVariable String booksId) {

		String booksid = booksId;
		List<Book> response = new ArrayList<Book>();
		Book mybook = new Book();

		List<Book> booklist = bookservice.getBookData(booksid);

		for (Book book : booklist) {

			mybook.setBookid(book.getBookid());
			mybook.setBookName(book.getBookName());
			mybook.setBookPrice(book.getBookPrice());
			response.add(mybook);
		}
		System.out.println("Response-> " + response);
		return response;

	}
	
	/**Assignment
	 * POST
	 * PUT
	 * DELET
	 * */
}
