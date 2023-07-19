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
	<h1>hai</h1>
	<h1>Displaying Criminal Details</h1>
	<h2>${size}</h2>
	<h2>${msg}</h2>
	<table border="2">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
				<th>Country</th>
				<th>CriminalType</th>
				<th>NoOfCases</th>
				<th>Alive</th>
				<th>Gender</th>
				<th>International</th>
				<th>Married</th>
				<th>JailTerm</th>
				<th>WifeName</th>
				<th>RightHandName</th>
				<th>LeftHandName</th>
				<th>PrisonName</th>
				<th>NetWorth</th>
			</tr>
			<c:forEach items="${criminalsdetails}" var="dto">
				<tr>
					<th>${dto.id}</th>
					<th>${dto.name}</th>
					<th>${dto.age}</th>
					<th>${dto.country}</th>
					<th>${dto.type}</th>
					<th>${dto.noOfCase}</th>
					<th>${dto.alive}</th>
					<th>${dto.gender}</th>
					<th>${dto.international}</th>
					<th>${dto.married}</th>
					<th>${dto.jailTerm}</th>
					<th>${dto.wifeName}</th>
					<th>${dto.rightHand}</th>
					<th>${dto.leftHand}</th>
					<th>${dto.jailName}</th>
					<th>${dto.netWorth}</th>
				</tr>
			</c:forEach>

		</thead>
</body>
</html>