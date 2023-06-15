<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<h1 align="center">Book Dashboard</h1>

	<br>
	<div align="center">
	<br>
	<a href="/spring-jdbc-app/show-sorted">
		<button>Sort books by price</button>
	</a>
	<br>
	<br>
	
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


			<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.bookId }</td>
					<td>${book.bookTitle }</td>
					<td>${book.bookAuthor }</td>
					<td>${book.bookPrice }</td>
					<td>${book.bookQty }</td>
					<%-- <td><a href="updateForm?empId=${book.bookId}">Edit</a>
						<a href="deleteStudent?empId=${book.bookId}"
						onclick="if (!(confirm('Do you really want to delete this book record?'))) return false">Delete</a>
					</td> --%>
				</tr>
			</c:forEach>

		</table>
		<br>
		<form:form action="Backup-confirm" method="POST">
		<input type="submit" value="Save"></input>
		</form:form>
	</div>
	
<br>
	<a href="/spring-jdbc-app">
		<button>Go to home page</button>
	</a>
	


<br>
</body>
</html>
