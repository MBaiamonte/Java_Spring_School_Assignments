<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Receipt</title>
</head>
<body>
<h1>Name: <c:out value="${name}"></c:out></h1>
 <h1>Cost: </h1>
 <c:out value="${itemName}"></c:out>
 <h1>Price: </h1>
 <c:out value="${price}"></c:out>
 <h1>Description</h1>
 <c:out value="${description}"></c:out>
 <h1>Vendor:</h1>
 <c:out value="${vendor}"></c:out>
 
 <h3>note: funcationallity works just dont wanna spend time doing the html styling to make it look exacly like the example </h3>
</body>
</html>