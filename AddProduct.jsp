<%@page import="product.admin.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminLogin</title>
<style type="text/css">
	header{
		border: 3px solid cadetblue;
        height: 50px;
        background-color: gold;
	}
	nav{
		display: flex;	
		justify-content: space-around;
		margin-top: 15px;
        margin-left: -10px;
		margin-right: -10px;
	}
    nav a{
        text-decoration: none;
        font-size: 18px;
        font-family: arial;
        color: blue;
        font-weight: bolder;
    }
    a:hover{
        text-decoration: underline;
    }
    .sec{
     	display: flex;
     	justify-content: space-between;
     	margin-top: 20px;
     	margin-left: 20px;
     	margin-right: 30px;
     	
     	
    }
    .dt{
    	display:grid;
    	grid-columns;
    	font-size: 18px;
    	font-weight: bolder;
    }
    .msg{
    	font-size: 22px;
    	font-weight: bold;
    }
</style>

</head>
<body onload="bodyload()">
<header>
	<nav>
		<span><a href="index.html">Home</a></span>
		<span><a href="AddProduct.html" target="frame">Add Product</a></span>
		<span><a href="view"> View All Products </a></span>
		<span><a href="users">View All Customers</a></span>
		<span><a href="logout"> Logout </a></span>
	</nav>
</header>
<section class="sec">
	<div class="msg">
		<span>
			<%
				AdminBean ab=(AdminBean)session.getAttribute("abean");
				out.println("<b> Page belongs to Admin : "+ab.getlName()+"</b>");
				String msg=(String)request.getAttribute("msg");
				out.println("<br><span style='color:green; text-align:center;'><b>"+msg+"</b></span>");
			%>
		</span>
	</div>	

    <div class="dt">
        
        	<span id="date1"></span>
        	<span id="time1" style="padding-left: 10px; padding-top: 3px;"></span>
       
    </div>
</section>
<footer>
	<iframe name="frame" style="border: none; padding-left: 400px;" height="500px" width="500px"></iframe>
</footer>

<script type="text/javascript">
    function updateTime() {
        var date = new Date(); // Create a new Date object to get the current time
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var seconds = date.getSeconds();
        var ampm = hours >= 12 ? "PM" : "AM";
        hours = hours % 12 || 12; // Convert 0 to 12 for 12-hour format
        minutes = minutes < 10 ? '0' + minutes : minutes;
        seconds = seconds < 10 ? '0' + seconds : seconds;
        var time = hours + ':' + minutes + ':' + seconds + ' ' + ampm;
        document.getElementById("time1").innerHTML = time;
    }
    
    function dateload() {
        var currentDate = new Date(); // Rename the variable to currentDate
        var weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        var months = ["January", "February", "March", "April", "May", "June", "July", "August"];
        var dateString = currentDate.getDate() + "-" + months[currentDate.getMonth()] + "-" + currentDate.getFullYear();
        document.getElementById("date1").innerHTML = dateString;
    }

    function bodyload() {
        dateload();
        updateTime();
        setInterval(updateTime, 1000);
    }

    // Call the bodyload function after the DOM is fully loaded
    document.addEventListener("DOMContentLoaded", function() {
        bodyload();
    });
</script>

</body>
</html>