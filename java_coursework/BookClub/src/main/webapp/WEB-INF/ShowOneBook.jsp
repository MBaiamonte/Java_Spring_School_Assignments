<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL tags import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- new form  and error display imports -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- lets us render a view on the page on a put request and show errors -->
<%@ page isErrorPage="true" %> 
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
</head>
<body class="container mt-5">
	<div class="row">
		<h1 class="col-5"><c:out value="${book.title}"></c:out></h1>
		<a href="/user/dashboard" class="btn btn-outline-primary col-3">Return to the shelves</a>
	</div>
		<c:choose>
			<c:when test="${book.user.id==userId}">
				<h3 class="row"> You read <c:out value="${book.title }"/> by <c:out value="${book.author}"/></h3>
				<h3 class="row"> Here are your thoughts </h3>
			</c:when>
			<c:otherwise>
			<h3 class="row"><c:out value="${book.user.firstName}"/> read <c:out value="${book.title }"/> by <c:out value="${book.author}"/></h3>
			<h3 class="row"> Here are <c:out value="${book.user.firstName}"/>s thoughts </h3>
			</c:otherwise>
		</c:choose>
	
	
	
	

	<div class="row">
		<p class="col-4"> <c:out value="${book.myThoughts}"/></p>
	</div>
	<c:if test="${book.user.id==userId}">
		<div>
			<a  class="btn btn-primary" href="/book/show/update/${book.id}">Edit</a>
			<a class="btn btn-danger" href="/book/delete/${book.id}">Delete</a>
		</div>
	</c:if>



</body>
</html>