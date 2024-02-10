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
<body class=container>
		<div class="card mt-5">
		<div class=" row card-head">
			<h1 class="mx-3 col-6">Expense Details</h1>
			<a href="/expenses"><button class="btn btn-outline-primary col-2">See All Expenses</button></a>
		</div>
		<div class="card-body">
	<form:form action="/expenses/update/${expense.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<!-- Could also just remove the hidden input and change the method to put in form opening tag  -->
		<form:label path="expenseName">Expense Name:</form:label>
		<form:errors path="expenseName"/>
		<form:input class="form-control" type="text" path="expenseName"/>
		
		<form:label path="vendor">Vendor:</form:label>
		<form:errors path="vendor"/>
		<form:input class="form-control" type="text" path="vendor"/>
		
		<form:label path="amount">Amount:</form:label>
		<form:errors path="amount"/>
		<form:input class="form-control" type="number" step="0.01" path="amount"/>
		
		<form:label path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:input class="form-control" type="text" path="description"/>
		
		<input type="submit" value="Update Expense">
	</form:form><!-- End form -->
	</div>
	</div>

</body>
</html>