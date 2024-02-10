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
<title>Login and Registration</title>
</head>
 
<body class="container mt-5">
	<div class="row">
		<h2>Hello <c:out value="${loggedinUser.firstName}"/></h2>
		<a href="/user/logout">Logout</a>
	</div>
	<div>
		<h4>All Projects</h4>
		<a href="/project/add/new">Create New Project</a>
	</div>
	<div class="row">
		<table class="table">
			<thead> 
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${allProjects}">
					<tr>
					<td><c:out value="${project.title}"/></td>
					<td><c:out value="${project.creator.firstName}"/></td>
					<td><c:out value="${project.dueDate}"/></td>
					<td>
					<c:choose>
						<c:when test="${loggedinUser.id==project.creator.id}"> 
							<a href="/project/show/edit/${project.id}">Edit Project</a>
							<a href="">Join Team</a>
						</c:when>
						<c:otherwise>
						<a>Join Team</a>
						</c:otherwise>
					</c:choose> 
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%-- <div class="row">
		<table class="table">
			<thead> 
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="project" items="${myProjects}">
					<tr>
						<td><c:out value="${project.title}"/></td>
						<td><c:out value="${project.creator.firstName}"/></td>
						<td><c:out value="${project.dueDate}"/></td>
						<td>
							<a>Edit Project</a>
							<a>Leave Team</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div> --%>
 
 
 
 
 
 
 
 
 
 
 
</body>
</html>