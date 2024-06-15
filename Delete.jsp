<%@page import="app.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	String msg=(String)request.getAttribute("msg");
	out.println("Page belongs to Admin: "+ab.getlName()+"<br>");
	out.println(msg);
%>
<a href="Home.html">Home</a>&nbsp;&nbsp;&nbsp;
<a href="Employee.html">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="view">View All Employees</a>&nbsp;&nbsp;&nbsp;
<a href="logout">Logout</a>
</body>
</html>