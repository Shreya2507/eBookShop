<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Form</title>
</head>
<body>
<div align="center">
	<form:form action="update-process" method="post" modelAttribute="book">
		<h1>Enter book record to update</h1>
		<label for="id">Id of book to update :</label>
		<form:input type="text" path="bookId" />
		<br>
		<br>
		<br>
		<h4>Enter other details of book to update:</h4>

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
</body>
</html>