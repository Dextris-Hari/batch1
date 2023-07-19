<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="music.manoj">

		name: <input type="text" name="name"> 
		singer: <input type="text" name="singer">
		 duration: <input type="text"name="duration">
	 producer: <input type="text" name="producer">
		lyrics: <input type="text" name="lyrics"> 
		longuage:<select name="longuage">
			<option>select</option>
			<option>kannada</option>
			<option>english</option>
			<option>thelagu</option>
			<option>thimil</option>

		</select> 
		type:<select name="type">

			<option>select</option>
			<option>item</option>
			<option>feeling</option>
			<option>love</option>
			<option>romantic</option>
		</select> 
		<input type="submit" value="add">


	</form>
</body>
</html>