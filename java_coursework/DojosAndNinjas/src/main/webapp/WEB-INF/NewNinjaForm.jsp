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
<title>Add New Ninja</title>
</head>
<body class="container mt-5">
 <div class="card card-body w-25">
			<h3 class="card-title"> New Ninja</h3>
		<form:form class="form" action="/ninja/new/create" method="post" modelAttribute="ninja">
			<form:label path="firstName"> First Name:</form:label>
			<form:errors path="firstName"></form:errors>
			<form:input  class="form-control" type="text" path="firstName"/>
			
			<form:label path="lastName"> Last Name:</form:label>
			<form:errors path="lastName"></form:errors>
			<form:input class="form-control" type="text" path="lastName"/>
			
			<form:label path="age"> Age:</form:label>
			<form:errors path="age"></form:errors>
			<form:input class="form-control" type="number" path="age"/>
			
			<form:select path="dojo">
				<c:forEach var="oneDojo" items="${dojos}">
					<form:option value="${oneDojo.id}">
						<c:out value="${oneDojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
			
			<div class="mt-2">
				<input class="btn btn-outline-primary" type="submit" value="Create New Ninja">
			</div>
		</form:form>
	</div>
</body>
</html>