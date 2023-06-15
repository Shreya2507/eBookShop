<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form:form action="delete-process" method="post" modelAttribute="book">
			<h1>Delete a book record by Id</h1>
			<label for="id">Id of book to delete :</label>
			<form:input type="text" path="bookId" />
			<br>
			<br>
			<br>
			<input type="submit" value="submit" />

		</form:form>
</body>
</html>