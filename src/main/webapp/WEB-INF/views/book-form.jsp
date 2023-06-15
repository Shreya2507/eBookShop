<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Input Form</title>
</head>
<body>
<div align="center">

		<h2 align="center">Book insertion Form</h2>
		<br>
		<hr>
	    <div align="center">
		<form:form action="process" method="post" modelAttribute="book">

			<label for="id">Id :</label>
			<form:input type="text" path="bookId" />
			<br>
			<br>

			<label for="title">Title :</label>
			<form:input type="text" path="bookTitle" />
			<br>
			<br>
			
			<label for="author">Author :</label>
			<form:input type="text" path="bookAuthor" />
			<br>
			<br>
			
			<label for="price">Price :</label>
			<form:input type="text" path="bookPrice" />
			<br>
			<br>
			
			<label for="qty">Quantity :</label>
			<form:input type="text" path="bookQty" />
			<br>
			<br>


			<input type="submit" value="submit" />

		</form:form>
		<hr>

	</div>
</body>
</html>