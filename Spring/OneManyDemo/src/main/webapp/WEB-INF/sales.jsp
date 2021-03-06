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
		<h1>Who's making the money:</h1>
		<form:form action="/sales/new" method="post" modelAttribute="salesObj">
			<p>
				Client:
				<form:input type="text" path="client"/>
			</p>
			
			<p>
				Amount:
				<form:input type="number" path="amount"/>
			</p>
			
			<p>
				Who made the sale?
				<form:select path="salesperson">
					<c:forEach var="employee" items="${employees}">
						<form:option value="${employee.id}">
							<c:out value="${employee.name}"></c:out>						
						</form:option>					
					</c:forEach>
				</form:select>
			</p>
			
			
			<button type="submit">Create</button>
			
		</form:form>
	</div>
</body>
</html>