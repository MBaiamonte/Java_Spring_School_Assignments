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
<title>Insert title here</title>
</head>
<body class="container">

		<h3>Update Burger</h3>
		<form:form class="form card-body"  action="/burger/${burger.id}/update" method="post" modelAttribute="burger">
			<input type="hidden" name="_method" value="put">
			<form:label class="mt-2" path="burgerName">Burger Name:</form:label>
			<form:errors path="burgerName" />
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
		
</body>
</html>