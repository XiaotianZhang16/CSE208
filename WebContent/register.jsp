<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="RegisterServlet" method="get">
				ID号:<input type="number" name ="uid"/><br/>
				用户名:<input type="text" name ="uname"/><br/>
				密码:<input type="text" name ="upwd"/><br/>
				邮箱:<input type="text" name ="umail"/><br/>
				您的安全问题:<input type="text" name ="upro"/><br/>			
				专业:<input type="text" name ="umajor"/><br/>
				
				年级:<br/>:
				<input type="checkbox" name ="uhobbies" value= "足球" />大一<br/>
				<input type="checkbox" name ="uhobbies"  value= "basketball" />大二<br/>
				<input type="checkbox" name ="uhobbies"  value=  "pinpang" />大三<br/>
				<input type="checkbox" name ="uhobbies"  value=  "pinpang" />大四<br/>
				<input type="submit" value="注册" >
				
				<%--足球篮球是给用户看的，因为其是对勾，所以传的值在value里 --%>
				<%--而上面的text与password传的值是用户输入的，所以没有value属性 --%>
				<%--最后是根据request方法的name属性值拿value属性值，想象成字典，是键值对--%>
				<%--submit中的value值是显示给用户按的--%>				

			</form>
				
</body>
</html>