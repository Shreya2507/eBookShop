<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search results</title>
</head>
<body>
	<h1 align="center">Book Search Results</h1>

	<br>
	<div align="center">

		<table border=1>
			<thead>
				<tr>
					<td>Book Id</td>
					<td>Book Title</td>
					<td>Book Author</td>
					<td>Book Price</td>
					<td>Book Quantity</td>

					<!-- <td>Operation</td> -->
				</tr>
			</thead>


				<tr>
					<td>${book1.bookId}</td>
					<td>${book1.bookTitle}</td>
					<td>${book1.bookAuthor}</td>
					<td>${book1.bookPrice}</td>
					<td>${book1.bookQty}</td>
				</tr>
			

		</table>
	</div>

	<br>
	<a href="/spring-jdbc-app">
		<button>Go to home page</button>
	</a>

	<br>

</body>
</html>