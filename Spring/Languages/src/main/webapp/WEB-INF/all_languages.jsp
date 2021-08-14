<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>All Languages</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			
			
			<tbody>
				<c:forEach var="language" items="${languages}">
					<tr>
						<th><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></th>
						<th><c:out value="${language.creator}"/></th>
						<th><c:out value="${language.currentVersion}"/></th>
						<th><a href="/languages/${language.id}/delete">delete</a> | <a href="/languages/${language.id}/edit">edit</a></th>
					</tr>	
				</c:forEach>		
			</tbody>
	
		</table>	
		
		<form:form action="/languages" method="post" modelAttribute="languageObj">
		    <p>
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>			
		    <p>
		        <form:label path="creator">Creator</form:label>
		        <form:errors path="creator"/>
		        <form:input path="creator"/>
		    </p>		
   		    <p>
		        <form:label path="currentVersion">Version</form:label>
		        <form:errors path="currentVersion"/>
		        <form:input path="currentVersion"/>
		    </p>		
			<button>Submit</button>
		</form:form>    
	</div>
</body>
</html>