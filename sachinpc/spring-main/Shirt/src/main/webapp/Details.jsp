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
	<h1>${man }</h1>
	<table border="5">
		<tr>
			<th>ID</th>
			<th>Brand</th>
			<th>Size</th>
			<th>Prize</th>
			<th>Discount</th>
			<th>Quantity</th>
			<th>Gender</th>
			<th>Color</th>


		</tr>
		<c:forEach items="${manoj }" var="m">
			<tr>

				<th>${m.id }</th>
				<th>${m.brand }</th>
				<th>${m.size }</th>
				<th>${m.prize }</th>
				<th>${m.discount }</th>
				<th>${m.quantity }</th>
				<th>${m.gender }</th>
				<th>${m.color }</th>




			</tr>




		</c:forEach>



	</table>


</body>
</html>