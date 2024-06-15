<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="app.ProductBean,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ViewProductByCode</title>
</head>
<body>
	<%
	ArrayList<ProductBean> al=(ArrayList<ProductBean>)request.getAttribute("alist");
	if(al.size()==0)
	{
		out.println("No Products Not Available........!");
	}
	else{
		ProductBean pb=(ProductBean)al.get(0);
		out.println("<b>"+pb.getCode()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getName()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getPrice()+"&nbsp;&nbsp;&nbsp;&nbsp;"+pb.getQty()+"</b><br>");
	}
	%>
</body>
</html>