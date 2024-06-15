<%@page import="com.voidmain.dao.HibernateDAO"%>
<%@page import="com.voidmain.pojo.Product"%>
<%@page import="java.util.Date"%>

<script type="text/javascript">
	
	function validate()
	{
		var description=document.appform.description.value;
		
		if(description=="" || description==null)
		{
			alert("please enter description");
			return false;
		}
	}
	
</script>

<%@include file="header.jsp"%>
	<div id="content">
		<!-- insert the page content here -->
		<%
			String status = request.getParameter("status");

			if (status != null) {
		%>
		<h1><%=status%></h1>
		<%
			} else {
		%>
		<h1>Send Request</h1>
		<%
			}
		%>
		
		<%
			String pid=request.getParameter("productid");
		
			if(pid!=null)
			{
			
			Product product=HibernateDAO.getProductById(Integer.parseInt(pid));
		%>
	
		<form action="VoidmainServlet" method="post" name="appform">

			<input type="hidden" name="type" value="com.voidmain.pojo.Request">
			<input type="hidden" name="redirect" value="sendrequest.jsp">
			<input type="hidden" name="requestedby" value="<%=username%>">
			<input type="hidden" name="pid" value="<%=pid%>">
			<input type="hidden" name="username" value="<%=product.getUsername()%>">
			<input type="hidden" name="rd" value="<%=new Date().toString()%>">
			<input type="hidden" name="status" value="">
			
			<div class="form_settings">
				<p>
					<span>Description</span><textarea class="contact" name="description"></textarea>
				</p>
				
				<p style="padding-top: 15px">
					<span>&nbsp;</span><input class="submit" type="submit"
						name="contact_submitted" value="Send Request" onclick="return validate()"/>
				</p>
			</div>
		</form>
		
		<%
			}
		%>
	</div>
<%@include file="footer.jsp"%>