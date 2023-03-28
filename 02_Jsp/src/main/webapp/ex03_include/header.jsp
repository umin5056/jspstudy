<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Optional" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% 
	request.setCharacterEncoding("UTF-8");
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("Welcome to here");
	
%>
<%--request.getContextPath() == /02_Jsp--%>
<title><%= title %></title>
<link rel='stylesheet' href="<%= request.getContextPath()%>/resources/css/header.css">
<script src="<%= request.getContextPath() %>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<nav>
		<ul>
			<li><a href="body1.jsp">body1</a></li>
			<li><a href="body2.jsp">body2</a></li>
			<li><a href="body3.jsp">body3</a></li>
		</ul>
	</nav>
<hr>
