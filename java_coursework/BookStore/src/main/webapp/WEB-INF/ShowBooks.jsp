<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body class="container mt-5 d-flex justify-content-center">
	<div class="card col-5">
		<h1><c:out value="${book.title.toUpperCase()}"/></h1>
		<div class="card-body">
			<p>Description: <span><c:out value="${book.description}"></c:out></span></p>
			<p>Language: <c:out value="${book.language}"/></p>
			<p>Number of Pages: <c:out value="${book.numOfPages}"/></p>
			<div class="col-4">
				<a  class="btn btn btn-outline-primary form-control" href="/show/book/all">Return to View All</a>
			</div>
		</div>
	</div>
</body>
</html>