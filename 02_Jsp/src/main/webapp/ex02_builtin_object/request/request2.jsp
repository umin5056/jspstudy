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
		Optional<String> opt = Optional.ofNullable(request.getParameter("price"));
		String strPrice = opt.orElse("0");
		int price = Integer.parseInt(strPrice.toString()); // toSring() 대신 Optional<String>으로 코드를 작성할 수도 있다.
		
	%>
	
	<h1>모델 : <%= model %></h1>
	<h1>가격 : <%= price %></h1>
</body>
</html>