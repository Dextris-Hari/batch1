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
<h1>${all }</h1>
<table border="5">
<tr>
<th>ID</th>
<th>NAME</th>
<th>TYPE</th>
<th>IMAGE</th>

</tr>
<c:forEach items="${manoj }" var="m">
<tr>
<th>${m.id }</th>
<th>${m.name}</th>
<th>${m.type}</th>
<th><img src="man/image?filename=${m.image }"></img></th>

</tr>

</c:forEach>
  



</table>

</body>
</html>