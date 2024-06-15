<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,emp.EmployeeBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Emp Details</title>
</head>
<body>
	<%
		ArrayList<EmployeeBean> al=(ArrayList<EmployeeBean>)request.getAttribute("arraylist");
		if(al.size()==0)
		{
			out.println("<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Employee Detilas Not Available</b>");
		}
		else{
			Iterator<EmployeeBean> i=al.iterator();
			while(i.hasNext())
			{
				EmployeeBean eb=(EmployeeBean)i.next();
				out.println("<br><b>"+eb.getEid()+"&nbsp;&nbsp;&nbsp;"+eb.getEname()+"&nbsp;&nbsp;&nbsp;"+eb.getEjob()+"&nbsp;&nbsp;&nbsp;"+
						eb.getEsal()+"&nbsp;&nbsp;&nbsp;"+eb.getEda()+"&nbsp;&nbsp;&nbsp;"+eb.getEda()+"&nbsp;&nbsp;&nbsp;"+eb.getEtotsal()+"</b><br><br>");
			}
		}
	%>
	<%@include file="index.html" %>
</body>
</html>