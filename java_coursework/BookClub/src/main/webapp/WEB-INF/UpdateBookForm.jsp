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
	<div class="row d-flex justify-content-between" id="header">
		<h1 class="col-5">Update your book</h1>
		<a href="/user/dashboard" class="btn btn-outline-primary col-3">Return to the shelves</a>
	</div>
	<form:form class="form" action="/book/update/${book.id}" method="put" modelAttribute="book">
		
		
		<form:label path="title">Title:</form:label>
		<form:errors path="title"></form:errors>
		<form:input class="form-control" path="title" type="text"/>
		
		<form:label path="author">Author:</form:label>
		<form:errors path="author"></form:errors>
		<form:input class="form-control" path="author" type="text"/>
		
		<form:label path="myThoughts">My Thoughts:</form:label>
		<form:errors path="myThoughts"></form:errors>
		<form:input class="form-control" path="myThoughts" type="text"/>
		
		<form:hidden path="user" value="${userId}"></form:hidden>
		
		<input class="btn btn-outline-primary mt-2" type="submit" value="Update book"/>
	</form:form>
</body>
</html>