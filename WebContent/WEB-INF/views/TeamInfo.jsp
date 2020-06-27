<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Equipos</title>
</head>
<body>
<h2>${team.getsNombre()} ${idTeam}</h2>
	<a href="/Rosters/Players">New ${team.getsNombre()} </a>
<table>
	<thead>
		<th>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Age</td>
			<td>Action</td>
		</th> 
	</thead>
	<tbody>
		<c:forEach var="player" items="${team.getArrayListPlayer()}" varStatus="loop">
			<tr>
				<td> <c:out value="${loop.index}"></c:out></td>
				<td> <c:out value="${player.getFirst_name()}"></c:out></td>
				<td> <c:out value="${player.getLast_name()}"></c:out></td>
				<td> <c:out value="${player.getAge()}"></c:out></td>
			
				<td><form action="DeletePlayer" method="POST">
						<input hidden="hidden" name= "idTeam" value="${idTeam}">
						<input hidden="hidden" name= "idPlayer" value="${loop.index}">
						<button type="submit" value="Delete">Delete</button>
					</form></td>
			</tr>
		</c:forEach>
	</tbody>

</table>
</body>
</html>