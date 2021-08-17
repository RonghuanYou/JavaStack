<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>New Product</title>
</head>
<body>
	<div class="container mt-3">
		<h1>New Product</h1>
		<form:form action="/products/new" method="POST" modelAttribute="productsObj">
		<p> 
			Name:
			<form:input path="name"/>
		</p>
		
		<p> 
			Description:
			<form:input path="description"/>
		</p>
		
		<p> 
			Price:
			<form:input type="number" path="price"/>
		</p>
		
		<button>Create</button>
		</form:form>

	</div>
</body>
</html>