<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./home" method="get">
	<p> <h1>Welcome</h1> <%=request.getParameter("username") %></p>
	</form>
</body>
</html>