package com.javatpoint.util;

import com.javatpoint.model.Books;

public class BooksUtil {

	public Books getBooksById(int id) {
		Books books = new Books();
		
		books.setBookid(id);
		books.getBookid();
		return books;
	}
}