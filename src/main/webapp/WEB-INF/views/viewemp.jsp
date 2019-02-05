
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}

 th {
background-color: #4863A0;
  border: 1px solid #32CD32;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body style="background-color:#E6E6FA">
<br>
<br>
<center>
	<h1>View Employees List </h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Designation</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>
					${emp.id}
				</td>
				<td>
					${emp.firstName}
				</td>
				<td>
					${emp.lastName}
				</td>
				<td>
					${emp.designation}
				</td>
			</tr>
		</c:forEach>
	</table>
</center>


</body>
</html>
