<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
<%
	String msg=(String)request.getAttribute("msg");
	out.println(msg);
%>
<%@include file="index.html" %>
</body>
</html>