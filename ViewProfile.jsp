<%@page import="app.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile</title>
</head>
<body>
<%
	String name=(String)request.getAttribute("name");
	UserBean ub=(UserBean)application.getAttribute("ubean");
	out.println("Page belongs to user "+name+"<br>");
	out.println(ub.getFname()+"&nbsp;&nbsp;&nbsp;"+ub.getLname()+"&nbsp;&nbsp;&nbsp;"+
	ub.getAddr()+"&nbsp;&nbsp;&nbsp;"+ub.getMid()+"&nbsp;&nbsp;&nbsp;"+ub.getPhno()+"&nbsp;&nbsp;&nbsp;"+"<a href='edit'>Edit</a><br>");
%>
<a href="logout">Logout</a>
</body>
</html>