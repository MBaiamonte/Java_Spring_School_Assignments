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
	<div class="card">
		<div class="card-header">
			<h3><c:out value="${house.address}"/></h3>
			<a href="/user/dashboard" class="btn btn-pirmary">Return to Dashboard</a>
		</div>
		<div class="card-body">
			<p>Address: <c:out value="${house.address}"/></p>
			<p>Listing Price: <c:out value="${house.price}"/></p>
			<p>Listing Date <c:out value="${house.createdAt}"/></p>
			<c:if test="${house.user.id== userId}">
				<a  href="/house/show/update/${house.id}">Edit Listing</a>
				<a href="/house/delete/${house.id}">Delete Listing</a>
			</c:if>
		</div>
		
		
		
	</div>








</body>
</html>