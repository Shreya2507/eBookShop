package org.ncu.spring_jdbc_app.dao;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ncu.spring_jdbc_app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository  //stereotype annotation
public class BookDaoImpl implements BookDao {
	
	//jdbc template is configured in MvcConfiguration
	//inject jdbctemplate inside EmployeeDaoImpl
	@Autowired
	private JdbcTemplate jdbcTemplate;
	


	@Override
	public int insertBook(Book book) {
		String query = "insert into books values(?,?,?,?,?)";
		Object[] arr = {book.getBookId(), book.getBookTitle(), book.getBookAuthor(), book.getBookPrice(), book.getBookQty()};
		int result = jdbcTemplate.update(query, arr);
		if (result>0) {
			System.out.println("Record inserted successfully!");
			return 1;
		}else {
			System.out.println("Error inserting !");
			return 0;
		}
		
	}

	@Override
	public Book fetchBook(int bookId) {
		System.out.println("Inside dao layer, ID = " + bookId);
		
		String query = "select * from books where id=?";
		Object[] arr = {bookId};
		
		Book obj =jdbcTemplate.queryForObject(query, new BookDaoRowMapper(), arr);
		System.out.println(obj);
		return obj;
		
		
	}

	@Override
	public int updateBook(Book book) {
		System.out.println("Inside dao layer");
		
		String query1 = "update books set title=?, author=?, price=?, qty=? where id=?";
		Object[] arr = {book.getBookTitle(), book.getBookAuthor(), book.getBookPrice(), book.getBookQty(), book.getBookId()};
		int result = jdbcTemplate.update(query1, arr);
		if (result>0) {
			System.out.println("Record updated successfully!");
			return 1;
		}else {
			System.out.println("Error updating !");
			return 0;
		}
		
	}

	@Override
	public int deleteBook(Book book) {
		System.out.println("Inside dao layer");
		
		String query1 = "delete from books where id=?";
		Object[] arr = {book.getBookId()};
		int result = jdbcTemplate.update(query1, arr);
		if (result>0) {
			System.out.println("Record deleted successfully!");
			return 1;
		}else {
			System.out.println("Error deleting !");
			return 0;
		}
		
		
		
		
	}

	@Override
	public List<Book> fetchBooks() {
		String query = "select * from books";
		
		return jdbcTemplate.query(query, new BookDaoRowMapper());
		
	}

	@Override
	public int[] saveBookRecords(List<Book> books) {
		String query = "insert into book_backup values(?,?,?,?,?)";
		
		int[] records = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Book b = books.get(i);
				ps.setInt(   1, b.getBookId());
				ps.setString(2, b.getBookTitle());
				ps.setString(3, b.getBookAuthor());
				ps.setDouble(4, b.getBookPrice());
				ps.setInt(   5, b.getBookQty());
			}
			
			
			@Override
			public int getBatchSize() {
				
				return books.size();
			}
			
		});
		return records;
		
		
		
	}
	
	
	          
}
