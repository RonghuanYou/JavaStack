<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Add Song</title>
</head>
<body>
	<div class="container">
		<a href="/dashboard">Dashboard</a>
		<form:form action="/songs/create" method="post" modelAttribute="lookifyObj">
			<p>
		        <form:label path="title">Name</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>			
		    <p>
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:input path="artist"/>
		    </p>		
		    
		   	<p>
		        <form:label path="rating">Rating(1-10)</form:label>
		        <form:errors path="rating"/>
		        <form:input path="rating"/>
		    </p>

			<button>Add Song</button>
		</form:form>
	</div>
</body>
</html>