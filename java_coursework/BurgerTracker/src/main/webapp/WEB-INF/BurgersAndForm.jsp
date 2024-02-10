<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL tags import -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- new form  and error display imports -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> <!-- lets us render a view on the page on a put request -->
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
<title>Burger Stores</title>
</head>
<body class=container>
<!-- Start All burger's Table -->
<h1>Book Store</h1>
	<table class="table">
		<thead>
			<tr>
			<th scope="col">Burger Name</th>
			<th scope="col">Restaurant Name</th>
			<th scope="col">Rating (out of 5)</th>
			<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="burger" items="${allBurgers}">
		<tr>
		<td><c:out value="${burger.burgerName}"></c:out></td>
		<td><c:out value="${burger.restaurantName}"></c:out></td>
		<td><c:out value="${burger.rating}"></c:out></td>
		<td>
			<a href="/burger/${burger.id}/edit"><button>Edit</button></a>
			<button>Delete</button>
		</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
<!-- end all burger's table -->
<!-- Start New Burger form -->
	<div class=" card mt-5 mx-5">
		<h3>New Burger</h3>
		<form:form class="form card-body"  action="/burger/create" method="post" modelAttribute="burger">
			<form:label class="mt-2" path="burgerName">Burger Name:</form:label>
			<form:errors path="burgerName"/>
			<form:input class="form-control" type="text" path="burgerName"/>
			
			<form:label class=" mt-2" path="restaurantName">Restaurant Name:</form:label>
			<form:errors path="restaurantName"/>
			<form:input class="form-control" type="text" path="restaurantName"/>
			
			<form:label class="mt-2" path="rating">Rating:</form:label>
			<form:errors  path="rating"/>
			<form:input class="form-control" type="number" path="rating"/>
			
			<form:label class="mt-2" path="notes">Notes:</form:label>
			<form:errors path="notes"/>
			<form:input class="form-control" type="textarea" path="notes"/>
	
			<input  class="btn  btn btn-primary mt-3" type="submit" value="Submit Form">
		</form:form>
	</div>











</body>
</html>