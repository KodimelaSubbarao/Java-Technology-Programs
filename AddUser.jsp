<%@page import="product.user.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IAdd User</title>
</head>
<body>
	<div>
		<%
			String msg=(String)request.getAttribute("msg");
			out.println("<br><b>&nbsp;&nbsp;&nbsp; <span color='green'>"+msg+"</span></b>");
		%>
	</div>
	<div>
		<%@include file="UserLogin.html" %>
	</div>
</body>
</html>