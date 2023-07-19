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
<a href="criminals">macha eli details</a>
<a href="SelectFromName.jsp">search by name</a>
	<form action="criminals" method="post">
	

		<pre>
name:<input type="text" name="name" />
age:<select name="age">
<option>select</option>
<c:forEach begin="12" end="100" var="index">
<option value="${index}">${index}</option>
</c:forEach>

</select>
country:<select name="country">
<option>select</option>
<option>india</option>
<option>pakistan</option>
<option>afganistan</option>
<option>newzealand</option>
<option>australia</option>
<option>oman</option>
<option>america</option>
<option>england</option>
<option>switzerland</option>
<option>russia</option>


</select>
type<input type="text" name="type">
noOfCase:<select name="noOfCase">
<option>select</option>
<c:forEach begin="1" end="100" var="man">
<option value="${man}">${man}</option>
</c:forEach>
</select>
alive:<input type="radio" name="alive" value="true" />true
<input type="radio" name="alive" value="false" />false
gender:<input type="radio" name="gender" value="male" />male
<input type="radio" name="gender" value="female" />female
<input type="radio" name="gender" value="other" />other
international:<input type="radio" name="international" value="false" />false
<input type="radio" name="international" value="true" />true
 married:<input type="radio" name="married" value="yes" />yes
 <input type="radio" name="married" value="no" />no
 jailTerm:<select name="jailTerm">
 <option>select</option>
 
 <option>1</option>
 <option>2</option>
 <option>3</option>
 <option>4</option>
 <option>5</option>
 
 
 </select>
 wifeName:<input type="text" name="wifeName" />
 rightHand<input type="text" name="rightHand" /> 
 leftHand:<input type="text" name="leftHand" />
 jailName:<input type="text" name="jailName" />
 netWorth:<input type="text" name="netWorth" />
 <input type="submit" value="save" />
</pre>
	</form>

</body>
</html>