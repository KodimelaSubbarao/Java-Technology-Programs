<%@page import="product.user.UserBeans"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
.dt1 {
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 25px;
	padding-top: 10px;
}

dt {
	font-size: 18px;
	padding-bottom: 10px;
	padding-left: 20px;
	font-weight: bolder;
	padding-top: 10px;
}

input {
	margin-left: 30px;
}

button {
	margin-left: 120px;
}
</style>
<script type="text/javascript">
    function pverify() {
        var pw1 = document.getElementById("pw1").value;
        var pw2 = document.getElementById("pw2").value;
        var error = document.getElementById("error");
        var submitBtn = document.getElementById("bt1");
        if (pw1 != pw2) {
            error.innerHTML = "Password mismatch. Enter valid password only.";
            submitBtn.hidden = true;
        } else {
            error.innerHTML = "";
            submitBtn.hidden = false;
        }
    }
</script>
</head>
<body>
	<%
		UserBeans ub=(UserBeans)request.getAttribute("ubean");
	%>
    <dialog open style="margin-top: 100px; width: 300px; height: 300px;">
	
        <form action="password" method="post" >
            <dl>
                <dt>User Name</dt>
                <dd><input type="text" name="uname" value="<%=ub.getuName() %>" readonly></dd>
                <dt>New Password</dt>
                <dd><input type="password" name="pword" id="pw1" placeholder="Enter New Password..." required="required"></dd>
                <dt>Re-Type Password</dt>
                <dd><input type="password" id="pw2" onkeyup="pverify()" placeholder="Enter Re Enter Password..." required="required"></dd>
            	<dd id="error" style="color:red; font-size:12px;"></dd>
            </dl>
            <button id="bt1" type="submit">Submit</button>
        </form>
    </dialog>
</body>
</html>