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
	<title>New Ninja</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninjasObj">
			<p>
				Dojo:
				<form:select path="ninjasdojo">
					<c:forEach var="dojo" items="${ dojos }">
					
						<form:option value="${ dojo.id }">
							<c:out value="${ dojo.name }"/>
						</form:option>			
					
					</c:forEach>
				</form:select>
			</p>
		
		
			<p>
		        <form:label path="firstName">First Name: </form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>	
		    		
		    <p>
		        <form:label path="lastName">Last Name: </form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>	
		    	
	  		<p>
		        <form:label path="age">Age: </form:label>
		        <form:errors path="age"/>
		        <form:input text="number" path="age"/>
			</p>	
			<button>Create</button>
		</form:form>
	</div>
</body>
</html>