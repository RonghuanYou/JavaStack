<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Secret Code</title>
</head>
<body>
	<div class="container mt-3">
		<p style="color:red;"><c:out value ="${error}"/></p>
		<h3>What is the code?</h3>
		<form action="/guess" method="post">
			<input type="text" name="guessValue" />
			<button>Try Code</button>
		</form>	
		
	</div>
</body>
</html>