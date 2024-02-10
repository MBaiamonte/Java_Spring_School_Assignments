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
</head>
<body class="container mt-5">
	<div id="banner" class=" row d-flex justify-content-between">
		<h1 class="col-5">Welcome <c:out value="${loggedinUser.firstName}"></c:out></h1>
		<a href="/user/logout" class="btn btn-outline-primary col-1">Logout</a>
	</div>
	<div class="row d-flex justify-content-between mt-2">
		<p class=col-6>Books form everyones shelf</p>
		<a href="/book/add/new" class="btn btn-outline-primary col-2">+ Add a Book</a>
	</div>
	<table class="table">
		<thead> 
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${allBooks}">
				<tr>
				<td><c:out value="${book.id}"/></td>
				<td> <a href="/book/show/${book.id}"> <c:out value="${book.title}"/></a></td>
				<td><c:out value="${book.author}"/></td>
				<td><c:out value="${book.user.firstName}"/> <c:out value="${book.user.lastName}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>