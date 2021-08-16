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
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>History of Sales</h1>
		<!-- show all employees info-->
		<c:forEach var="employee" items="${ employees }">
			<a href="/users/${ employee.id }">
				<h2><c:out value="${ employee.name }"/></h2>
			</a>
			<!-- users table doesn't have attribute called sales, but we have it in user Model -->
			<c:forEach var="sale" items="${ employee.sales }">
				<li>
					<c:out value=" ${sale.client}"/> - <c:out value="${sale.amount}"/>
				</li>
			
			</c:forEach>
		
		
		</c:forEach>
	</div>
</body>
</html>