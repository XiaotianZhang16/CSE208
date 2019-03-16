<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	    login succeed！
	    <a href="login.jsp">返回登录页面</a>
	    <a href="searching.jsp">搜索</a>
	    <a href="upload.jsp">上传</a>
		<a href="download.jsp">下载</a>
		
		<form action="SearchServlet" method="get">
		您想搜索的内容:<input type="text" name ="usearch"/><br/>
		<input type="submit" value="搜索" ></form>
		
 		<a href="calendar.jsp">日历</a>
 		<a href="myInfo.jsp">我的信息</a>
 		
		
</body>
</html>