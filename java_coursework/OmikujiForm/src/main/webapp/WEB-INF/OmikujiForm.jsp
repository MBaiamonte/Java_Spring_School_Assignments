<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!-- default is set to ISO-8859-1 , you need to change it in 3 places to be UTF-8 -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Omikuji Form</title>
</head>
<body>
	<form class="form" action="/omikuji/postForm" method="post">
		<label class="form-control">Pick a Number</label>
		<input class="form-control" type="number" name="number">
		<label class="form-control">Enter a City</label>
		<input class="form-control" type="text" name="city">
		<label class="form-control">Enter a Real Person</label>
		<input class="form-control" type="text" name="person">
		<label class="form-control">Enter a hobby or profession</label>
		<input class="form-control" type="text" name="hobby">
		<label class="form-control">Enter a Living thing</label>
		<input class="form-control" type="text" name="organisum">
		<label class="form-control">Say Something Nice</label>
		<input class="form-control" type="textarea" name="saying">
		<label class="form-control">Send and show Friend</label>
		<input type="submit">
	</form>




</body>
</html>