<%@page import="product.admin.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="product.user.UserBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<header>
		<div>
			<%
				UserBeans ub=(UserBeans)session.getAttribute("ubean");
				out.println("<br>&nbsp;&nbsp;&nbsp;<b> Page Belongs to User : "+ub.getlName()+"</b><br>");
				String msg=(String)request.getAttribute("msg");
				out.println("<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='color:green'>"+msg+"</span></b>");
			%>
		</div>
	</header>
	<section>
		<div>
			<span>
			<%
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("arraylist");
			if (al != null && !al.isEmpty()) {
			    out.println("<br><table border='1' frame='box' cellspacing='6px' cellpadding='11px'> <tr width='350px' height='50px'> <th width='80px' align='center'>Code</th> <th width='70px' align='center'>Name</th> <th width='70px' align='center'>Price</th> <th width='70px' align='center'>Quantity</th> <th width='70px' align='center'>Operations</th> </tr>");
			    for (ProductBean pb : al) { 
			        out.println("<tr><td  align='center'>" + pb.getpCode() + "</td><td  align='center'>" + pb.getpName() + "</td><td  align='center'>" 
			    + pb.getpPrice() +"</td><td  align='center'>" + pb.getpQty() +"</td><td  align='center'><a href='buy?code=" + 
			    pb.getpCode() + "'>Buy</a>");
			    }
			    out.println("</table>");
			}
			else{
				out.println("ArrayList is Empty check the code Onece.....!<br>");
			}
			%>
		</span>
		</div>
	</section>
	
</body>
</html>