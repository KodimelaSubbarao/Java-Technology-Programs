<%@page import="com.voidmain.pojo.Request"%>
<%@page import="com.voidmain.dao.HibernateTemplate"%>
<%@page import="com.voidmain.dao.HibernateDAO"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>

<div id="site_content">
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
		<h1>View Requests</h1>
		<%
			}
		%>

		<table style="width: 100%; border-spacing: 0;">
			<tr>
				<th>ID</th>
				<th>Requested By</th>
				<th>Requested Date</th>
				<th>Product ID</th>
				<th>Description</th>
				<th>Status</th>
				<th>Delete</th>
				<th>Update Status</th>
			</tr>

			<%
				for (Request req : HibernateDAO.getRequests()) {
					
					if(req.getUsername().equals(username))
					{
			%>

			<tr>
				<td><%=req.getId()%></td>
				<td><%=req.getRequestedby()%></td>
				<td><%=req.getRd()%></td>
				<td><%=req.getPid()%></td>
				<td><%=req.getDescription()%></td>
				<td><%=req.getStatus()%></td>
				<td> <a href="viewrequests.jsp?id=<%=req.getId()%>">delete</a></td>
				<td> <a href="updatestatus.jsp?requestid=<%=req.getId()%>">Update</a></td>
			</tr>

			<%
					}
				}
			%>
		</table>
		
		<hr/><hr/><hr/>
		
		<h1>View Request Status</h1>
		
		<table style="width: 100%; border-spacing: 0;">
			<tr>
				<th>ID</th>
				<th>Requested By</th>
				<th>Requested Date</th>
				<th>Product ID</th>
				<th>Description</th>
				<th>Status</th>
				<th>Delete</th>
			</tr>

			<%
				for (Request req : HibernateDAO.getRequests()) {
					
					if(req.getRequestedby().equals(username))
					{
			%>

			<tr>
				<td><%=req.getId()%></td>
				<td><%=req.getRequestedby()%></td>
				<td><%=req.getRd()%></td>
				<td><%=req.getPid()%></td>
				<td><%=req.getDescription()%></td>
				<td><%=req.getStatus()%></td>
				<td> <a href="viewrequests.jsp?id=<%=req.getId()%>">delete</a></td>
			</tr>

			<%
					}
				}
			%>
		</table>
		
		<%
			String id=request.getParameter("id");
		
			if(id!=null)
			{
				if(HibernateTemplate.deleteObject(Request.class,Integer.parseInt(id))==1)
				{
					response.sendRedirect("viewrequests.jsp?status=success");
				}
				else
				{
					response.sendRedirect("viewrequests.jsp?status=failed");
				}
			}
		%>

	</div>
</div>
<%@include file="footer.jsp"%>