<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%String msg = (String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%if(msg!=null && !msg.isEmpty()) { %>
		<h3 style="color: red;"><%=msg %></h3>
	<%} %>
	
	<fieldset>
		<legend>Register Form</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td>User Name</td>
					<td>:</td>
					<td><input type="text" name="Id" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td>Age</td>
					<td>:</td>
					<td><input type="number" name="age" required></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>:</td>
					<td><input type="text" name="gender" required></td>
				</tr>
				<tr>
					<td colspan="3"></br>
					<input type="submit" value="register"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>