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
	<h1 class="row">Welcome!</h1>
	<h3 class="row">Join our community.</h3>
	<div class="row d-flex justify-content-between">
		<div id="register" class="col-6 card">
			<h1 class="Card-header">Register</h1>
			<form:form  class="form card-body"  action="/user/register" method="post" modelAttribute="newUser">
			
			<form:label path="firstName">First Name:</form:label>
			<form:errors path="firstName"/>
			<form:input class="form-control" type="text" path="firstName"/>
			
			<form:label path="lastName">Last Name:</form:label>
			<form:errors path="lastName"/>
			<form:input  class="form-control" type="text" path="lastName"/>
			
			<form:label path="email">Email:</form:label>
			<form:errors path="email"/>
			<form:input  class="form-control" type="email" path="email"/>
			
			<form:label path="password">Password:</form:label>
			<form:errors path="password"/>
			<form:input class="form-control" type="password" path="password"/>
			
			<form:label path="confirm">Confirm Password:</form:label>
			<form:errors path="confirm"/>
			<form:input  class="form-control" type="password" path="confirm"/>
			<input  class="form-control btn btn-outline-primary mt-2" type="submit" value="submit">
			</form:form>
		</div>
		
		 <div id="Login" class="col-5 card">
			<h1 class="Card-header">Log in</h1>
			
			<form:form  class="form card-body" action="/user/login"  method="post" modelAttribute="loginUser">
				<form:label path="email">Email:</form:label>
				<form:errors path="email"/>
				<form:input class="form-control" type="email" path="email"/>
				
				<form:label path="password">Password:</form:label>
				<form:errors path="password"/>
				<form:input class="form-control" type="password" path="password"/>
				<input class="form-control btn btn-outline-primary mt-2" type="submit" value="submit">
			</form:form>
		</div> 
	</div>
</body>
</html>