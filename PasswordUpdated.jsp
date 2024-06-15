<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Updated</title>
</head>
<body>
	<%
		String msg=(String)request.getAttribute("msg");
		out.println("<br><b>&nbsp;&nbsp;&nbsp;<span style='color:green;' >"+msg+"</span></b>");
	%>
	<%@include file="UserLogin.html" %>
</body>
</html>