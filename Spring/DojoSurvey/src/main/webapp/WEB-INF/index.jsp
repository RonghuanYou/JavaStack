<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<form action="/survey" method="post">
			<p>
				Your Name:
				<input type="text" name="name"/>
			</p>
			
			<p>
				Dojo Location:
				<select name="location">
					<option>San Jose</option>
					<option>Los Angeles</option>
					<option>Orange County</option>
				</select>
			</p>
			
			<p>
				Favorite Language:
				<select name="language">
					<option>Python</option>
					<option>Java</option>
					<option>JavaScript</option>
					<option>C#</option>
				</select>		
			</p>
			
			<p>Comment (optional):</p>
			<p><textarea name="comment"></textarea></p>
			<button>Button</button>
		</form>		
	</div>
</body>
</html>