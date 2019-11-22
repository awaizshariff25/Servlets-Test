<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%String msg = (String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<% if(msg!=null) { %>
		<%=msg%>
	<%} %>
	<fieldset>
		<legend>User Login</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>User ID</td>
					<td>:</td>
					<td><input type="text" name="Id" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3"></br>
					<input type="submit" value="login"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>