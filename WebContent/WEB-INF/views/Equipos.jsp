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
<h2>Prototype Roster</h2>
	<a href="/Rosters/Teams">New Teams</a>
<table>
	<thead>
		<th>
			<td>id</td>
			<td>Teams</td>
			<td>Players</td>
			<td>Action</td>
		</th> 
	</thead>
	<tbody>
		<c:forEach var="team" items="${teams}" varStatus="loop">
			<tr>
				<td><c:out value="${loop.index}"/></td>
				<td><c:out value="${team.sNombre}"/></td>
				<td><c:out value="${team.getArrayListPlayer().size()}"/></td>
				
				
				<td>
					<form action="Teams" method="GET">
						<input hidden="hidden" name= "idTeam" value="${loop.index}">
						<button type="submit" value="Details">Details</button>
					</form>
					<form action="DeleteTeams" method="POST">
						<input hidden="hidden" name= "idTeam" value="${loop.index}">
						<button type="submit" value="Delete">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>
</body>
</html>