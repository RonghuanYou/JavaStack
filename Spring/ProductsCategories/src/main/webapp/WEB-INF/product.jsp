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
	<title>Product Page</title>
</head>
<body>
	<div class="container mt-3 p-5">
		<h1><c:out value="${ product.name }"/></h1>
		
		<div class="d-flex justify-content-between mt-3">
			<!-- display all categories this product belongs to -->
			<ul>
				<h4>Categories</h4>
				<c:forEach var="category" items="${ product.categories }"> 
					<li><c:out value="${ category.name }"/></li>
				</c:forEach>		
			</ul>
				
			
			
			<div>
				<h4>Add Category:</h4>
				<form action="/products/${ product.id }" method="POST">
					<!-- Users choose specific category and get its id(RequestParam) -->
					<select name="category_id">
						<c:forEach var="category" items="${ categories }">
							<option value="${ category.id }">
								<c:out value="${ category.name }"/>
							</option>
						</c:forEach>	
					</select>	
					<button>Add</button>	
				</form>
			
			</div>
		</div>
		
		
	</div>
</body>
</html>