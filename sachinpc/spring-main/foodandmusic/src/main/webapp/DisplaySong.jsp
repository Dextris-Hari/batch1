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
				<th>singer</th>
				<th>duration</th>
				<th>producer</th>
				<th>lyrics</th>
				<th>longuage</th>
				<th>type</th>

			</tr>
			<c:forEach items="${music}" var="dto">

				<td>${dto.name }</td>
				<td>${dto.singer }</td>

				<td>${dto.duration }</td>

				<td>${dto.producer }</td>
				<td>${dto.lyrics }</td>

				<td>${dto.longuage }</td>

				<td>${dto.type }</td>

			</c:forEach>


		</thead>

	</table>

</body>
</html>