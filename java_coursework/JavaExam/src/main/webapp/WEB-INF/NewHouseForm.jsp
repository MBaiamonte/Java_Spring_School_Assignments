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
<title>Create Listing</title>
</head>
<body class="container mt-5">
	<h3>New Listing</h3>
	<a href="/user/dashboard">Dashboard</a>
	<form:form class="form" action="/house/save/new" method="post" modelAttribute="newHouse">
		<form:label path="address">Address:</form:label>
		<form:errors path="address"></form:errors>
		<form:input class="form-control" type="text" path="address"/>
		
		<form:label path="price">Price:</form:label>
		<form:errors path="price"></form:errors>
		<form:input class="form-control" type="number" step=".01" path="price"/>
		
		<form:hidden path="user" value="${userId}"/>
		
		<input class="btn btn-primary" type="submit" value="Submit Listing"/>
	</form:form>

</body>
</html>