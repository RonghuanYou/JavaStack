<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>All Books</title>
</head>
<body>
	<div class="container">
		<h1>All Books</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th># of Pages</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="book" items="${books}">
					<tr>
						<th><c:out value="${book.id}"/></th>
						<th><a href="/books/${book.id}"><c:out value="${book.title}"/></a></th>
						<th><c:out value="${book.description}"/></th>
						<th><c:out value="${book.language}"/></th>
						<th><c:out value="${book.numberOfPages}"/></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</body>
</html>