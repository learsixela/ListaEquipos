<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Players</title>
</head>
<body>
	<form action="Players" method="POST">
		<h3>Agregar Player a Team</h3>
		<br>
		id team <input type="text" name= "idTeam" value="${idTeam}">
		<p>First name : </p> <input type="text" name="fname" id="fname">
		<br>
		<p>Last name:</p> <input type="text" name="lname" id="lname">
		<p>Edad :</p>  
			<select name="age" id="age" >
				<option value="0">Seleccione</option>
				<% for(int i= 1; i<=100; i++){%>
					<option value="<%= i %>"><%= i %> </option>
				<%} %>
			</select>
		
		<button type="submit">Add</button>
	</form>	
</body>
</html>