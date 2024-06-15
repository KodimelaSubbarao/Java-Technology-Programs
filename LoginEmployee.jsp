<%@page import="app.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Employee</title>
</head>
<body>
<%
	EmployeeBean eb=(EmployeeBean)session.getAttribute("ebean");
	String msg=(String)request.getAttribute("msg");
	out.println("Page Belongs to "+eb.geteName()+"<br>");
	out.println(msg);
%>
<a href="eview">View Employee</a>&nbsp;&nbsp;
<a href="Home.html">Home</a>&nbsp;&nbsp;
<a href="logout1">Logout</a>
</body>
</html>