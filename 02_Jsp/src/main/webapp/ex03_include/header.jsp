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

<%-- 
	href의 경로가 같으면 캐싱한 내용을 읽어 css를 수정했을 때 적용이 안된다.
	해결책으로 파라미터 값을 현재 시간으로 주어 자동으로 주소가 수정되게 작성한다.
	
	외부 정적 파일(css, js)을 포함할 땐 매번 경로가 변할 수 있도록 처리한다.
	경로가 변해야 캐싱한 내용을 사용하지 않고 외부 파일을 읽는다.
--%>
<link rel='stylesheet' href="<%= request.getContextPath()%>/resources/css/header.css?dt=<%=System.currentTimeMillis()%>">

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
