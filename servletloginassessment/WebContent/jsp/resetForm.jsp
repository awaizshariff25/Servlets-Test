<%@page import="com.manthan.servletbean.test.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% UserBean bean= (UserBean) request.getAttribute("reset"); %>
<%String msg = (String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Change Password</legend>
		<form action="./reset" method="get">
		User Id:<input type="text" name="empId" required><br><br>
		<input type="submit" value="search">
		</form>
	</fieldset>
	<%if(msg!=null && !msg.isEmpty()) { %>
		<h3 style="color: red;"><%=msg %></h3>
	<%} %>
	<%if(bean!=null){ %>
	<table>
		<tr>
			<td>user ID</td>
			<td> : </td>
			<td><%=bean.getId() %></td>
		</tr>
		<tr>
			<td>Password</td>
			<td> : </td>
			<td><%=bean.getPassword() %></td>
		</tr>
		<tr>
			<td>Conform Password</td>
			<td> : </td>
			<td><%=bean.getPassword() %></td>
		</tr>
		
		
	</table>
	<%} %>
</body>
</html>