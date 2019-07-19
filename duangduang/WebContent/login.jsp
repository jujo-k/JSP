<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String nameValue="",pswValue="";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length!=0){
			for(Cookie c:cookies){
				if(c.getName().equals("name")){
					nameValue = c.getValue();
					System.out.println("This is name:"+nameValue);
				}
				if(c.getName().equals("psw")){
					pswValue = c.getValue();
					System.out.println("this is password:"+pswValue);
				}
			}
		}
	%>

			<form action="aaa" method="post">
			<table>
				<tr>
					<th>用户名：</th>
					<th><input type="text" name="username" value=<%=nameValue %>></th>
				</tr>
				<tr>
					<th>密码：</th>
					<th><input type="password" name="password" value=<%=pswValue %>></th>
				</tr>
				<tr>
					<th><input type="submit" value="登陆"></th>
					<th><input type="reset" value="重置"></th>
					<th><input type="checkbox" name="checkbox" checked="checked">记住密码</th>
				</tr>
			</table>
		
	
</body>
</html>