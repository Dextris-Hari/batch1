<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
		<thead>
			<tr>
				<th>name</th>
				<th>price</th>
				<th>hotelName</th>
				<th>type</th>
				<th>location</th>
				<th>order</th>
				<th>quantity</th>

			</tr>
			<c:forEach items="${music}" var="dto">

				<td>${dto.name }</td>
				<td>${dto.price }</td>

				<td>${dto.hotelName }</td>

				<td>${dto.type }</td>
				<td>${dto.location }</td>

				<td>${dto.order }</td>

				<td>${dto.quantity }</td>

			</c:forEach>



</body>
</html>