<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	function register()
	{
		var $mobile = $("#mobile").val();
		$.ajax({
			url:服务器地址
			请求方式：get|post
			data：请求数据，
			success：function（result，testStatus）{
				
			}，
			
			error：function（xhr，errorMessage）{
				
			}
	
		
		});
		
		
	}


</script>


<title>Insert title here</title>
</head>
<body>
		手机：<input id= "mobile"/><br/>
		<input type="button" value ="注册"  onclick="register">

</body>
</html>