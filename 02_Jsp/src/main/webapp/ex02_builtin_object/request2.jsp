<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		request.setCharacterEncoding("UTF-8");
		String model = request.getParameter("model");
		Optional opt = Optional.ofNullable(request.getParameter("price"));
		Object strPrice = opt.orElse("0");
		int price = Integer.parseInt(strPrice.toString());
		
	%>
	
	<h1>모델 : <%= model %></h1>
	<h1>가격 : <%= price %></h1>
</body>
</html>