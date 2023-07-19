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
				<th>ProductNmae</th>
				<th>UserMailId</th>
				<th>Category</th>
				<th>Price</th>
				<th>Image</th>
				<th>UpdatedBy</th>
				<th>NoOfStock</th>
			</tr>
		
			<c:forEach items="${details}" var="g">
				<tr>

					<td>${g.id}</td>
					<td>${g.productName }</td>
					<td>${g.userMailId }</td>
					<td>${g.category }</td>
					<td>${g.price }</td>
					<td>${g.image }</td>
					<td>${g.updatedBy }</td>
					<td>${g.noOfStock }</td>
					



				</tr>






			</c:forEach>
			</thead>
	</table>
	<form action="add/add">
	<input type="text" name="productName"/>
	<input type="submit" value="search"/>
	
	
	</form>
	<form action="add/manoj">
	
	
	<input type="text" name="category"/>
	<input type="submit" value="huduku"/>
	
	
	
	</form>
	
	<a href="EditProductDetailsByMail.jsp">Edit Product Details</a>
	
			

</body>
</html>