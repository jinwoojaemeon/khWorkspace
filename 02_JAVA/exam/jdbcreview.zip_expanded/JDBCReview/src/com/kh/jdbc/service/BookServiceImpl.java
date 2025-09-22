package com.kh.jdbc.service;

import static com.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.jdbc.model.dao.BookDao;
import com.kh.jdbc.model.vo.Book;

public class BookServiceImpl implements BookService{

	@Override
	public int insertBook(Book b) {
		Connection conn = getConnection();
		
		int result = new BookDao().insertBook(b, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

}
