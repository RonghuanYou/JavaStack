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
	<title>Category Page</title>
</head>
<body>
	<div class="container mt-3 p-5">
	<h1><c:out value="${ category.name }"/></h1>
	
	<div class="d-flex justify-content-between">
		<ul>
			<h4>Products</h4>
			<c:forEach var="product" items="${ category.products }"> 
				<li><c:out value="${ product.name }"/></li>
			</c:forEach>		
		</ul>
		
		<div>
			<h4>Add Products:</h4>
			<form action="/categories/${ category.id }" method="POST">
				<select name="product_id">
					<c:forEach var="product" items="${ products }">
						<option value="${ product.id }">
							<c:out value="${ product.name }"/>			
						</option>
					</c:forEach>
				</select>	
				<button>Add</button>			
			</form>				
		</div>

		
	</div>
</body>
</html>