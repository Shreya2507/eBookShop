package org.ncu.spring_jdbc_app.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ncu.spring_jdbc_app.dao.BookDao;
import org.ncu.spring_jdbc_app.dao.BookDaoImpl;
import org.ncu.spring_jdbc_app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //stereotype annotation which implements @Component---- creates bean
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public int createRecord(Book book) {
		return bookDao.insertBook(book);
		
	}

	@Override
	public Book readRecord(int bookId) {
		System.out.println("Inside Service layer, ID =" + bookId);
		Book books = bookDao.fetchBook(bookId);
		
		if(books!=null) {
			return books;
		}else {
			return null;
		}
		
	}

	@Override
	public int updateRecord(Book book) {
		System.out.println("Inside service layer");
		return bookDao.updateBook(book);
		
	}

	@Override
	public int deleteRecord(Book book) {
		System.out.println("Inside service layer");
		return bookDao.deleteBook(book);
	}

	@Override
	public List<Book> fetchRecords() {
		List<Book> books = bookDao.fetchBooks();
		
		if(books!=null) {
			return books;
		}else {
			return null;
		}
		
	}
	
	public List<Book> sortList() {
		
		
		List<Book> list=bookDao.fetchBooks();
		
		//System.out.println("Before" + list);
		
		Collections.sort(list, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				if(o1.getBookPrice()>o2.getBookPrice())
					return 1;
				return -1;
			}
		});	
		
		//System.out.println("After" + list);
		
		if(list!=null) {
			return list;
		}else {
			return null;
		}
		
		
		
	}

	@Override
	public void	batchRecordInsert(List<Book> books) {
		//int[] records = bookDao.saveBookRecords(books);
		bookDao.saveBookRecords(books);
		if(books==null) {
			System.out.println("Error adding batch records");
		}else {
			System.out.println("Batch records saved successfully");
		}
		
	}
	

}
