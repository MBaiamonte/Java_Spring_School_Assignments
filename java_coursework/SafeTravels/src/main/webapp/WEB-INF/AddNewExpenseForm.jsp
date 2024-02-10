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
<body class="container mt-5">
<!-- Start All Expenses Table -->
<h1>Safe Travels</h1>
	<table class="table">
		<thead>
			<tr>
			<th scope="col">Expense</th>
			<th scope="col">Vendor</th>
			<th scope="col">Amount</th>
			<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="expense" items="${allExpenses}">
		<tr>
		<td> <a href="/expenses/show_one/${expense.id}"><c:out value="${expense.expenseName}"></c:out></a></td>
		<td><c:out value="${expense.vendor}"></c:out></td>
		<td><c:out value="${expense.amount}"></c:out></td>
		<td>
			<a href="/expenses/edit/${expense.id}"><button>Edit</button></a>
			<a href="/expenses/delete/${expense.id}"><button>Delete</button></a>
			<%-- <form action="/expenses/delete/${expense.id}" method="post">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="delete">
			</form> --%>
		</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
<!-- end all expense table -->
<!-- Start New expense form -->
	<div class=" card mt-5 mx-5">
		<h3>New Expense</h3>
		<form:form class="form card-body"  action="/expenses/create" method="post" modelAttribute="expense">
			<form:label class="mt-2" path="expenseName">Expense Name:</form:label>
			<form:errors path="expenseName"/>
			<form:input class="form-control" type="text" path="expenseName"/>
			
			<form:label class=" mt-2" path="vendor">Vendor:</form:label>
			<form:errors path="vendor"/>
			<form:input class="form-control" type="text" path="vendor"/>
			
			<form:label class="mt-2" path="amount">Amount:</form:label>
			<form:errors  path="amount"/>
			<form:input class="form-control" type="number" step="0.01" path="amount"/>
			
			<form:label class="mt-2" path="description">Description:</form:label>
			<form:errors path="description"/>
			<form:input class="form-control" type="textarea" path="description"/>
	
			<input  class="btn  btn btn-primary mt-3" type="submit" value="Submit New Expense">
		</form:form>
	</div>











</body>
</html>