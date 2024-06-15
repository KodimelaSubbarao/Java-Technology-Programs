<%@page import="com.voidmain.pojo.User"%>
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
		<h1>View Users</h1>
		<%
			}
		%>

		<table style="width: 100%; border-spacing: 0;">
			
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>User Type</th>
				<th>Status</th>
				<th>Update Status</th>
			</tr>
			
			<%
				if(role.equals("admin"))
				{
			%>
					<%
						for (User user : HibernateDAO.getUsers()) {
					%>
			
					
							<tr>
								<td><%=user.getName()%></td>
								<td><%=user.getEmail()%></td>
								<td><%=user.getMobile()%></td>
								<td><%=user.getAddress()%></td>
								<td><%=user.getUserType()%></td>
								<td><%=user.getStatus()%></td>
								<%
									if (user.getStatus().equals("no")) {
								%>
											<td><a href="viewusers.jsp?user=<%=user.getMobile()%>&status=yes">Yes</a></td>
								<%
									} else if (user.getStatus().equals("yes")) {
								%>
										<td><a href="viewusers.jsp?user=<%=user.getMobile()%>&status=no">No</a></td>
								<%
									}
				
								%>
					<%
						}
					%>
			<%
				}
			%>
			
			<%
				String user = request.getParameter("user");
				String sta = request.getParameter("status");
	
				if (user != null && sta != null) {
					
					User men = HibernateDAO.getUserById(user);
					men.setStatus(sta);
					
					if (HibernateTemplate.updateObject(men) == 1) {
						response.sendRedirect("viewusers.jsp?status=success");
					} else {
						response.sendRedirect("viewusers.jsp?status=failed");
					}
				}
			%>
			
		</table>
		
	</div>
</div>
<%@include file="footer.jsp"%>