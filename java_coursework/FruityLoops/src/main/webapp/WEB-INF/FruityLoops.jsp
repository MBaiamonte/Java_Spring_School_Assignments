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

<title>Fruity Loops</title>
</head>
<body class="container">

<table class="table">
	<thead>
		<tr class="row">
			<th class="col-6"> Name</th>
			<th class="col-6">Price</th>
		</tr>
	</thead>
	<tbody class="table table-striped">
		<c:forEach  var="fruitItem" items="${fruitStoreInvintory}">
			<tr>
				<td class="col-6"><c:out value="${fruitItem.name}"> </c:out></td>
				<td class="col-6"><c:out value="${fruitItem.price}"> </c:out>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>