<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>¡CustomServlet executed!</h1>
	
	
	<h3>${action}</h3>
	
	<jsp:useBean id="linea" class="org.lalosuarez.app.dto.Linea" scope="request" />
	<jsp:getProperty property="nombre" name="linea"/>
	
</body>
</html>