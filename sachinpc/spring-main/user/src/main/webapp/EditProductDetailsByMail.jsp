<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}

<form action="editproduct" method="post">
<input type="text" name="userMailId"/>
<input type="text" name="productName"/>
<input type="text" name="category"/>
<input type="text" name="price"/>
<input type="text" name="image"/>
<input type="text" name="updatedBy"/>
<input type="text" name="noOfStock"/>
<input type="submit" value="update"/>





</form>



</body>
</html>