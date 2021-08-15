<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<div class="d-flex justify-content-between">
			<h3>Top Ten Songs:</h3>		
			<a href="/dashboard">Dashboard</a>
		</div>

		
		<div class="border border-dark p-2">
			<c:forEach var="song" items="${ songs }">
				<p>${song.rating} - ${song.title} - ${song.artist}</p>
			</c:forEach>
		</div>
	</div>
</body>
</html>