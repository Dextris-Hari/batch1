
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
	hai
	<h1>${size }</h1>
	<table border="2">
		<thead>
			<tr>

				<th>ID</th>
				<th>Name</th>
				<th>FILENAME</th>





			</tr>
			<c:forEach items="${details }" var="g">
				<tr>

					<td>${g.id }</td>
					<td>${g.name }</td>
					<td><img src="man/image?filename=${g.fileName }"></img></td>



				</tr>






			</c:forEach>
	</table>



</body>
</html>