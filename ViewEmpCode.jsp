<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="emp.EmployeeBean,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Emp Details By Code</title>
</head>
<body>
	<%
		ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)request.getAttribute("arraylist");
		if(al.size()==0)
		{
			out.println("<br><br><b>Employee Details Not Avialable for this ID</b><br>");
		}
		else{
				EmployeeBean eb=al.get(0);
				out.println("<br><b>"+eb.getEid()+"&nbsp;&nbsp;&nbsp;"+eb.getEname()+"&nbsp;&nbsp;&nbsp;"+eb.getEjob()+"&nbsp;&nbsp;&nbsp;"+
						eb.getEsal()+"&nbsp;&nbsp;&nbsp;"+eb.getEda()+"&nbsp;&nbsp;&nbsp;"+eb.getEda()+"&nbsp;&nbsp;&nbsp;"+eb.getEtotsal()+"</b><br><br>");
			
		}
	%>
	<%@include file="index.html" %>
</body>
</html>