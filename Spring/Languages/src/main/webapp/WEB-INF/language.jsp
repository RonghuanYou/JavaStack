<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Single Language</title>
</head>
<body>
	<div class="container">
		<a href="/languages" class="d-flex justify-content-end">Dashboard</a>
	
		<p><c:out value="${language.name}"/></p>	
		<p><c:out value="${language.creator}"/></p>		
		<p><c:out value="${language.currentVersion}"/></p>		
		<p><a href="/languages/${language.id}/edit">Edit</a></p>		
		<p><a href="/languages/${language.id}/delete">Delete</a></p>		
	</div>
</body>
</html>