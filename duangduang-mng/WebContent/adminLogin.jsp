<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
</head>
<body>
	<form action="bbb" method="post">
			<p class="main">
				<label>用户名: </label>
				<input name="username" value="" /> 
				<br>
				<label>密码: </label>
				<input type="password" name="password" value="">	
			</p>
			
			<p class="space">
				<input type="submit" value="登录" class="login" style="cursor: pointer;"/>
			</p>
	</form>
</body>
</html>