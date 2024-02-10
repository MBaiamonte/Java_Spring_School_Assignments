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
		<div class="card-head">
			<h1 class="mx-3">Expense Details</h1>
		</div>
		<div class="card-body">
			<p> Expense Name: <c:out value="${oneExpense.expenseName}"/></p>
			<p>Expense Description: <c:out value="${oneExpense.description}"/></p>
			<p>Expense Vendor: <c:out value="${oneExpense.vendor}"/>  </p>
			<p>Expense cost: <c:out value="${oneExpense.amount}"/></p>
			<a href="/expenses"><button class="btn btn-outline-primary">See All Expenses</button></a>
		</div>

		
	</div>

</body>
</html>