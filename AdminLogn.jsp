<%@page import="app.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLogin</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	out.println("<br><br>&nbsp;&nbsp;&nbsp;&nbsp; Welcome to Admin: "+ab.getlName()+"<br><br>");
%>
<a href="Home.html">Home</a>&nbsp;&nbsp;&nbsp;
<a href="Employee.html">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="view">View ALl Employees</a>&nbsp;&nbsp;&nbsp;
<a href="logout">Logout</a>
</body>
</html>