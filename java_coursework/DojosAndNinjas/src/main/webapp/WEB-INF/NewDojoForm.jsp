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
</head>
<title>Add New Dojo</title>
<body class="container mt-5">
	<div class="card card-body w-25">
			<h3 class="card-title">Add New Dojo</h3>
		<form:form class="form" action="dojo/create/new/" method="post" modelAttribute="dojo">
			<form:label path="name">Dojo Name:</form:label>
			<form:errors path="name"></form:errors>
			<form:input type="text" path="name"/>
			<div class="mt-2">
				<input class="btn btn-outline-primary" type="submit" value="Create New Dojo">
			</div>
		</form:form>
	</div>
	<a href="/ninja/new/show_form"><button>Add New Ninja</button></a>


</body>
</html>