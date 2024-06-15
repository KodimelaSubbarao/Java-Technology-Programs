<%@page import="app.AdminBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="app.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee Details</title>
</head>
<body>
<%
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)session.getAttribute("alist");
	out.println("<br><br>&nbsp;&nbsp; Page Belongs to Admin: "+ab.getlName());
	
	if(al.size()==0)
	{
		out.println("<br>Employee Deatils Not Available");
	}
	else{
		Iterator<EmployeeBean> i=al.iterator();
		while(i.hasNext())
		{
			EmployeeBean eb=(EmployeeBean)i.next();
			out.println("<br>&nbsp;&nbsp;"+eb.geteId()+"&nbsp;&nbsp;"+
			eb.geteName()+"&nbsp;&nbsp;"+eb.geteDesg()+"&nbsp;&nbsp;"+
			eb.getbSal()+"&nbsp;&nbsp;"+eb.getHra()+"&nbsp;&nbsp;"+
			eb.getDa()+"&nbsp;&nbsp;"+eb.getTotSal()+"&nbsp;&nbsp;"+
			"<a href='edit?eid="+eb.geteId()+"'>Edit</a>"+"&nbsp;&nbsp;"+
			"<a href='delete?eid="+eb.geteId()+"' >Delete</a>"+"&nbsp;&nbsp;"+
			"<br>");
		}
	}
%>
<br>
<a href="Employee.html">Add Employee</a>&nbsp;&nbsp;
<a href="Home.html">Home</a>&nbsp;&nbsp;
<a href="logout">Logout</a>
</body>
</html>