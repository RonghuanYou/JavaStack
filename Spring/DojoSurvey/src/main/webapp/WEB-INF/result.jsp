<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Survey Results</title>
</head>
<body>
	<div class="container mt-3">
		<c:set var="result" value="${ result }"/>
		<h3 style="text-decoration: underline">Submitted Info</h3>
		<div>
			<p>Name: <c:out value ="${ result.getName() }"/></p>
			<p>Dojo Location: <c:out value ="${ result.getLocation() }"/></p>
			<p>Favorite Language: <c:out value ="${ result.getLanguage() }"/></p>
			<p>Comment: <c:out value ="${ result.getComment()} "/></p>
		</div>
		<a href="/" class="btn btn-secondary">Go Back</a>		
	</div>
</body>
</html>