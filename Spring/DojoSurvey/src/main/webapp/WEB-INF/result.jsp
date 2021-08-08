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
		<h3 style="text-decoration: underline">Submitted Info</h3>
		<div>
			<p>Name: <c:out value ="${name}"/></p>
			<p>Dojo Location: <c:out value ="${location}"/></p>
			<p>Favorite Language: <c:out value ="${language}"/></p>
			<p>Comment: <c:out value ="${comment}"/></p>
		</div>
		<a href="/" class="btn btn-secondary">Go Back</a>		
	</div>
</body>
</html>