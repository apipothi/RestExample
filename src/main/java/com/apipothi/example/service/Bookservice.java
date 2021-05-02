package com.apipothi.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.apipothi.example.dao.Book;

@Component
public class Bookservice {

	Map<String, Book> booksDetails = new HashMap<String, Book>();

	public List<Book> getBookData(String booksid) {

		String bookid = booksid;

		Map<String, Book> mybookmap = bookData();
		List<Book> serviceResponse = new ArrayList<Book>();
		Book value = null;

		Set<String> key = mybookmap.keySet();
		Iterator<String> itr = key.iterator();

		while (itr.hasNext()) {
			String mapkey = (String) itr.next();
			if (mapkey.equals(bookid)) {
				value = mybookmap.get(mapkey);
				serviceResponse.add(value);
			}
		}

		return serviceResponse;
	}

	public Map<String, Book> bookData() {

		booksDetails.put("1", new Book(100, "JAVA", 100));
		booksDetails.put("2", new Book(100, "QA", 200));
		booksDetails.put("3", new Book(100, "B", 300));
		booksDetails.put("4", new Book(100, "C", 400));
		booksDetails.put("5", new Book(100, "D", 500));
		booksDetails.put("6", new Book(100, "F", 600));
		booksDetails.put("7", new Book(100, "E", 700));
		booksDetails.put("8", new Book(100, "G", 800));
		booksDetails.put("9", new Book(100, "H", 900));

		return booksDetails;

	}
}
