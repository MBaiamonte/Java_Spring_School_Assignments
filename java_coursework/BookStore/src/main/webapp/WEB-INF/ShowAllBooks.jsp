<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="container mt-5">
	<h1>Book Store</h1>
	<table class="table">
		<thead>
			<tr>
			<th scope="col">ID</th>
			<th scope="col">Title</th>
			<th scope="col">Language</th>
			<th scope="col"># Pages</th>
			<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${allBooks}">
		<tr>
		<td><c:out value="${book.id}"></c:out></td>
		<td><c:out value="${book.title}"></c:out></td>
		<td><c:out value="${book.description}"></c:out></td>
		<td><c:out value="${book.numOfPages}"></c:out></td>
		<td> <a class="btn btn btn-outline-primary form-control" href="${book.id}"> View Book</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>