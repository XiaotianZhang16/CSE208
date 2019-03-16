<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
	<form action="LoginServlet" method="post">
	
		用户名： <input type="text" name="uname"><br/>		    
		密码	:<input type="password" name="upwd"><br/>	

		<input type="submit" value="登录" ><a href="register.jsp">注册</a><br/>
										   <a href="forgot.jsp">忘记密码</a><br/>	
	</form>
	
	
	
	

</body>
</html>