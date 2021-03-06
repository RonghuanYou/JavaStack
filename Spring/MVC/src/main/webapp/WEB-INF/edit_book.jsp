<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Edit Book</title>
</head>
<body>
	<div class="container">
		<form action="/books/update/${book.id}" method="post">
			<p>Title: <input type="text" name="title" value="${book.title}"/></p>
			<p>Description: <input type="text" name="description" value="${book.description}"/></p>
			<p>Language: <input type="text" name="language" value="${book.language}"/></p>
			<p># of Pages: <input type="number" name="pages" value="${book.numberOfPages}"/></p>
			<button>Update</button>
		</form>
	</div>
</body>
</html>