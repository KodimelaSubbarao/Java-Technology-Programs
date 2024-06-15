<%@page import="app.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee</title>
</head>
<body>
<%
	
	EmployeeBean eb=(EmployeeBean)session.getAttribute("ebean");
	out.println("<br>&nbsp;&nbsp;"+eb.geteId()+"&nbsp;&nbsp;"+
		eb.geteName()+"&nbsp;&nbsp;"+eb.geteDesg()+"&nbsp;&nbsp;"+
		eb.getbSal()+"&nbsp;&nbsp;"+eb.getHra()+"&nbsp;&nbsp;"+
		eb.getDa()+"&nbsp;&nbsp;"+eb.getTotSal()+"&nbsp;&nbsp;"+"<br>");
%>
<a href="Home.html">Home</a>&nbsp;&nbsp;
<a href="logout1">Logout</a>
</body>
</html>