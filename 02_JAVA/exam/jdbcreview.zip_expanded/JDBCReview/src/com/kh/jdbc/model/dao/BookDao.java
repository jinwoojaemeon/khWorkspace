package com.kh.jdbc.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.model.vo.Book;

public class BookDao {
	private Properties prop = new Properties();
	
	
	
	public BookDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/book-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Book book, Connection conn) {
		//book추가 -> int
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBook");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
