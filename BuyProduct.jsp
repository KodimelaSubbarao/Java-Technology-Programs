<%@page import="product.admin.ProductBean"%>
<%@page import="product.user.UserBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
<script type="text/javascript">
	function btnClick()
	{
		var price=parseFloat(document.getElementById("p").value);
		var item=parseInt(document.getElementById("items").value);
		var t=Math.round(price*item);
		document.getElementById("total").innerHTML="Your Total Bill is : "+t;
	}
	function check(){
		var item=parseInt(document.getElementById("items").value);
		var no=parseInt(document.getElementById("q").value);
		var error=document.getElementById("error");
		if(item>no)
			{
				error.innerHTML="Total "+no+" Items avilable,<br>Please select below or equal ietms only";
			}
	}
</script>

<style type="text/css">
	body{
		display: flex;
		justify-content: space-around;
	}
	form{
		margin-top: 100px;
		margin-left: -250px;
		border: 2px solid black;
		padding-left: 30px;
		width:300px;
		padding-top: 20px;
	}
</style>
</head>
<body>
	<div>
		<%
			UserBeans ub = (UserBeans) session.getAttribute("ubean");
			out.println("<br><b>Page belongs to User: " + ub.getlName()+"<b><br>");
			ProductBean pb = (ProductBean) request.getAttribute("pbean");
		%>
	</div>
		<div>
		<form>
				
				<dl>
					<dt>Product Code</dt>
					<dd><input type="text" name="code"  value=<%=pb.getpCode()%> readonly="readonly"></dd>
					<dt>Product Name</dt>
					<dd>
						<input type="text" name="name" value=<%=pb.getpName()%> readonly="readonly">
					</dd>
					<dt>Product Price</dt>
					<dd>
						<input type="text" name="price" id="p" value=<%=pb.getpPrice()%> readonly="readonly">
					</dd>
					<dt>How Many Items You Want..?</dt>
					<dd>
						<input type="text" name="qty" id="items" onkeyup="check()" width="500px" pattern="\d{1,}" placeholder="enter number of items" required="required">
					</dd>
					<dd><input type="hidden" id="q" value=<%=pb.getpQty() %>> 
					<dd id="error" style="color:red;font-size:15px;"></dd>
				</dl>
				<div>
					<button type="button" style="width:100px;height: 25px; margin-left: 50px; font-size:16px; font-weight: bold;" onclick="btnClick()">Buy</button>
					<button type="button" name="ulogin">Back</button>
				</div>
				<p id="total" style="font-size: 16px; font-weight: bold; color:blue;"></p>
			</form>
	</div>
</body>
</html>