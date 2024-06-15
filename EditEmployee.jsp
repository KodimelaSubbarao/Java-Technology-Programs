<%@page import="app.EmployeeBean"%>
<%@page import="app.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	EmployeeBean eb=(EmployeeBean)request.getAttribute("ebean");
	out.println("<br><br>&nbsp;&nbsp; This Page Belongs to Admin: "+ab.getlName());
	int hra=(int)(eb.getHra()*100)/eb.getbSal();
	int da=(int)(eb.getDa()*100)/eb.getbSal();
%>
<form action="update" method="post">
	<dl>
		<dd><input type="hidden" name="eid" value=<%=eb.geteId() %>></dd>
		
		<dt>Basic Salary:</dt>
		<dd><input type="text" name="bsal" required="required" value=<%=eb.getbSal() %> ></dd>
		
		<dt>Employee House Rent Allowance</dt>
		<dd><input type="text" name="hra" required="required" value=<%=hra %> ></dd>
		
		<dt>Employee Dearness Allowance</dt>
		<dd><input type="text" name="da" required="required" value=<%=da %> ></dd>
		
		<dd><br> <input type="submit" value="UpdateEmployee"></dd>
	</dl>
</form>
<a href="Home.html">Home</a>&nbsp;&nbsp;&nbsp;
<a href="Employee.html">Add Employee</a>&nbsp;&nbsp;&nbsp;
<a href="view">View All Employees</a>&nbsp;&nbsp;&nbsp;
<a href="logout">Logout</a>
</body>
</html>