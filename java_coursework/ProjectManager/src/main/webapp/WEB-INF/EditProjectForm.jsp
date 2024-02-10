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
<title>Create New Project</title>
</head>
<body class="container mt-5">
	<h3>Update a Project</h3>
	<a href="/user/dashboard" class="btn btn-primary">Dashboard</a>
	<form:form  class="form" action="/project/save/edit/${project.id}" method="put" modelAttribute="project">
		<form:label path="title">Project Title</form:label>
		<form:errors path="title"></form:errors>
		<form:input class="form-control" path="title" type="text"/>
		
		<form:label path="description">Project Description</form:label>
		<form:errors path="description"></form:errors>
		<form:textarea class="form-control" rows="5" path="description"/>
		
		<form:label path="dueDate">Due Date</form:label>
		<form:errors path="dueDate"></form:errors>
		<form:input type="date" class="form-control" path="dueDate" />
		
		<form:hidden path="creator" value="${userId}"></form:hidden>
		
		<input class="btn btn-outline-primary mt-2" type="submit" value="Update Project"/> <%-- could also set this in controller by using setters and session--%>
	</form:form>

</body>
</html>