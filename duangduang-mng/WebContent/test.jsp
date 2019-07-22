<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  1. Server info: <%= application.getServerInfo() %><br>  
      2. Servlet version: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>  
      3. JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>  
      4. Java version: <%= System.getProperty("java.version") %><br>  
</body>
</html>