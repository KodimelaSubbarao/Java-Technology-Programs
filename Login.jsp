<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
String msg=(String)request.getAttribute("msg");
out.println("<br><br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+msg+"</b>");
%>

<%@include file="index.html" %>
</body>
</html>