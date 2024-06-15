<%@page import="app.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginSuccess</title>
</head>
<body>
<%
	UserBean ub=(UserBean)application.getAttribute("ubean");
	out.println("Welcome User : "+ub.getFname()+"<br>");
%>
<a href="view">View Profile</a>&nbsp; &nbsp;
<a href="logout">Logout</a>
</body>
</html>