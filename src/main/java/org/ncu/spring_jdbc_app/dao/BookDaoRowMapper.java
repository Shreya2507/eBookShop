package org.ncu.spring_jdbc_app.dao;


import java.sql.ResultSet;

import java.sql.SQLException;

import org.ncu.spring_jdbc_app.entity.Book;
//import org.ncu.spring_jdbc_app.entity.Book;
import org.springframework.jdbc.core.RowMapper;

public class BookDaoRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBookId(rs.getInt(1));
		book.setBookTitle(rs.getString(2));
		book.setBookAuthor(rs.getString(3));
		book.setBookPrice(rs.getDouble(4));
		book.setBookQty(rs.getInt(5));
		return book;
	}

}
