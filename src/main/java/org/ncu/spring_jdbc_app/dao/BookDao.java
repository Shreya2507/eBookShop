package org.ncu.spring_jdbc_app.dao;


import java.util.List;

import org.ncu.spring_jdbc_app.entity.Book;



public interface BookDao {
	
	public int insertBook(Book book);
	public Book fetchBook(int bookId);
	public int updateBook(Book book);
	public int deleteBook(Book book);
	public List<Book> fetchBooks();
	public int[] saveBookRecords(List<Book> books);
	

}
