package com.kh.jdbc.service;

import com.kh.jdbc.model.vo.Book;

//Service는 interface로 구성하고 그 구현체(impl)를 따로 두도록 함
// 인터페이스 -> 무엇을 할 수 있냐?
// 구현체 -> 어떻게 할것이냐?
public interface BookService {
	int insertBook(Book b);
}
