package com.kh.jdbc.controller;

import com.kh.jdbc.model.vo.Book;
import com.kh.jdbc.service.BookService;
import com.kh.jdbc.view.BookMenu;

public class BookController {
	private BookService bookService;
	
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	public void insertBook(String title,String author,String publisher) {
		Book b = new Book(null, title, author, publisher);
		int result = bookService.insertBook(b);
		
		if(result > 0) {
			new BookMenu().displaySuccess("도서 등록");
		} else {
			new BookMenu().displayFail("도서 등록");
		}
	}
}
