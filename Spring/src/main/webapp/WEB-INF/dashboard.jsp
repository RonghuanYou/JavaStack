<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Lookify!</title>
</head>
<body>
	<div class="container mt-3">

		<div class="d-flex justify-content-between">
			<div>
				<a href="/songs/new">Add New</a>
				<a href="/search/topTen">Top Songs</a>
			</div>

			
			<form action="/search">
				<input type="text" name="artist"/>
				<button>Search Artists</button>
			</form>
		</div>
		
	
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>	
			<tbody>
				<c:forEach var="song" items="${songs}">
				<tr>
					<th><a href="/songs/${song.id}">${ song.title } </a></th>				
					<th>${ song.rating } </th>				
					<th><a href="/songs/${song.id}/delete">Delete</a></th>				
				</tr>
				</c:forEach>
			</tbody>	
		</table>		
	</div>
</body>
</html>