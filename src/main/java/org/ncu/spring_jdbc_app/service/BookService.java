package org.ncu.spring_jdbc_app.service;

import java.util.List;


import org.ncu.spring_jdbc_app.entity.Book;


public interface BookService {
	public int createRecord(Book book); //update method of jdbc teplate returns int value showing no. of records/rows modified
		
	public Book readRecord(int bookId); //needs id for fetching record
	
	public int updateRecord(Book book);
	
	public int deleteRecord(Book book);
	
	public List<Book> fetchRecords();
	
	public List<Book> sortList();
	
	public void batchRecordInsert(List<Book> books);

}
