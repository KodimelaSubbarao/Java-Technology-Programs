<%@page import="com.voidmain.dao.HibernateTemplate"%>
<%@page import="com.voidmain.pojo.Request"%>
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
			String requestid=request.getParameter("requestid");
		
			if(requestid!=null)
			{
			
				Product product=HibernateDAO.getProductById(Integer.parseInt(requestid));
		%>
	
		<form action="updatestatus.jsp" name="appform">
		
			<input type="hidden" value="<%=requestid%>" name="requestid">
			
			<div class="form_settings">
				<p>
					<span>Status:</span><textarea class="contact" name="status"></textarea>
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
		
		<%
			String stat=request.getParameter("status");
			String rid=request.getParameter("requestid");
		
			if(stat!=null && rid!=null)
			{
				Request req=HibernateDAO.getRequestById(Integer.parseInt(rid));
				req.setStatus(stat);
				
				if(HibernateTemplate.updateObject(req)==1)
				{
					response.sendRedirect("updatestatus.jsp?status=success");
				}
				else
				{
					response.sendRedirect("updatestatus.jsp?status=failed");
				}
			}
		%>
	</div>
<%@include file="footer.jsp"%>