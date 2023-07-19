<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Manoj.jsp">click</a>
<form action="shirt" method="post">
<pre>
brand: <input type="text" name="brand"/>
size:<select name="size">

<option>select</option>
<option>small</option>
<option>medium</option>
<option>large</option>

</select>
price:<input type="text" name="prize"/>
discount:<select name="discount">
<option>select</option>
<option>10%</option>
<option>20%</option>
<option>30%</option>
</select>
quantity:<select name="quantity">
<option>select</option>
 
<c:forEach begin="1" end="1000" var="index" >
<option value="${index}">${index}</option>
</c:forEach>
</select>
gender:<input type="radio" name="gender" value="male" />male
<input type="radio" name="gender" value="female"/>female
<input type="radio" name="gender" value="other"/>other
color:<select name="color">

<option>select</option>
<option>white</option>
<option>red</option>
<option>black</option>
<option>green</option>
<option>yellow</option>


</select>

<input type="submit" value="click"/>
</pre>

</form>
<a href="shirt">click</a>

</body>
</html>