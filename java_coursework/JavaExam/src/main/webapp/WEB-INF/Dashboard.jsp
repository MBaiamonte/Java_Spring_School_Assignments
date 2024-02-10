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
<title>Dashboard</title>
</head>
<body class="container mt-5">
	<div class="row d-flex justify-content-between">
	<h2 class="col-5 ">Welcome <c:out value="${loggedinUser.firstName}"/></h2>
	<a href="/user/logout" class="btn btn-outline-primary col-1">Logout</a>
	</div>
	<div class="row d-flex justify-content-start">
		<h4>All Listings:</h4>
	</div>
	<div>
		<a href="/house/add/new" class="btn btn-outline-primary col-3">Create New Listing</a>
	</div>
	<table class="table">
		<thead>
			<tr>
				<th>Address</th>
				<th>Listed on</th>
				<th>Posted By</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="house" items="${allHouses}">
				<tr>
					<td><a href="/house/show/${house.id}"><c:out value="${house.address}"/></a></td>
					<c:choose>
						<c:when test="${house.updatedAt!=null}">
							<td><c:out value="${house.updatedAt}"/></td>     <!-- created on varible is unmuatble/not changable so idk how to use it or why save it on update form -->
						</c:when>
						<c:otherwise>
							<td><c:out value="${house.createdAt}"/></td>
						</c:otherwise>
					</c:choose>
					<td><c:out value="${house.user.firstName }"/></td>
					<td><c:out value="${house.price}"/></td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	
	
	
	</table>
	
	
	
	
 
</body>
</html>