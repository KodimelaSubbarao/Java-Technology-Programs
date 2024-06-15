 
<%@page import="com.voidmain.pojo.Product"%>
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
		<h1>View Your Products</h1>
		<%
			}
		%>

		<table style="width: 100%; border-spacing: 0;">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>User Name</th>
				<th>Category</th>
				<th>Delete/Send Request</th>
			</tr>

			<%
				String ptype=request.getParameter("ptype");
				
				for (Product product : HibernateDAO.getProducts()) {
					
					if(ptype.equals(product.getProductType()))
					{
			%>

			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getDescription()%></td>
				<td><%=product.getUsername()%></td>
				<td><%=product.getCategory()%></td>
				<%
					if(product.getUsername().equals(username))
					{
				%>
						<td> <a href="viewproducts.jsp?id=<%=product.getId()%>">delete</a></td>
				<%		
					}
					else
					{
				%>
						<td> <a href="sendrequest.jsp?productid=<%=product.getId()%>">send request</a></td>
				<%		
					}
				%>
				
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
				if(HibernateTemplate.deleteObject(Product.class,Integer.parseInt(id))==1)
				{
					response.sendRedirect("viewproducts.jsp?status=success");
				}
				else
				{
					response.sendRedirect("viewproducts.jsp?status=failed");
				}
			}
		%>

	</div>
</div>
<%@include file="footer.jsp"%>