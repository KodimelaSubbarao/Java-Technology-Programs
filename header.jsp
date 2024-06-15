<!DOCTYPE HTML>
<html>

<head>
<title>Voidmain</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="style/style.css"
	title="style" />
</head>

<body>
	<div id="main">
		<div id="header">
			<div id="logo">
				<div id="logo_text">
					<!-- class="logo_colour", allows you to change the colour of the text -->
					<h1>
						<a href="#">Agriculture <span class="logo_colour">Waste Management</span></a>
					</h1>
				</div>
			</div>
			<div id="menubar">
				<ul id="menu">

					 <%
						String role = (String) request.getSession().getAttribute("role");
						String username = (String) request.getSession().getAttribute( "username");

						if (role.equals("transporter")) {
					%>
						<li><a href="addvehicle.jsp">Add Vehicle</a></li>
						<li><a href="addmachine.jsp">Add Machinery</a></li>
						<li><a href="viewproducts.jsp?ptype=vehicle">View Vehicles/Machinery</a></li>
						<li><a href="viewrequests.jsp">View Requests</a></li>
					<%
						}
					%>
					<%
						if (role.equals("industry")) {
					%>
					
						<li><a href="viewproducts.jsp?ptype=waste">View Waste</a></li>
						<li><a href="viewproducts.jsp?ptype=vehicle">View Vehicles/Machinery</a></li>
						<li><a href="viewrequests.jsp">View Requests</a></li>
					
					<%
						}
						
						if (role.equals("farmer"))
						{
					%>
							<li><a href="addwaste.jsp">Add Waste</a></li>
							<li><a href="viewproducts.jsp?ptype=waste">View Waste</a></li>
							<li><a href="viewproducts.jsp?ptype=vehicle">View Vehicles/Machinery</a></li>
							<li><a href="viewrequests.jsp">View Requests</a></li>
					<%		
						}
					%>
					
					<%
						if (role.equals("admin"))
						{
					%>
							<li><a href="viewusers.jsp">View Users</a></li>
					<%		
						}
					%>
					
					<li><a href="logout.jsp">Logout</a></li>

				</ul>
			</div>
		</div>
		<div id="content_header"></div>
		<div id="site_content">