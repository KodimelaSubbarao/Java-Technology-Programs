<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="app.ProductBean,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<ProductBean> al=(ArrayList<ProductBean>)request.getAttribute("alist");
	if(al.size()==0)
	{
		out.println("No Products Not Available........!");
	}
	else{
		Iterator<ProductBean> i=al.iterator();
		while(i.hasNext())
		{
			ProductBean pb=i.next();
			out.println("<b>"+pb.getCode()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getName()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getPrice()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getQty()+"</b><br>");
		}
	}
%>
<%@include file="link.html"%>
</body>
</html>