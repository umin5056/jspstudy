<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- header.jsp에 title 파라미터의 전달이 없는 경우 확인 (body3의 타이틀만 null이므로 Welcome 나옴)--%> 
 <jsp:include page="header.jsp">
 	<jsp:param value="body2" name="title"/>
 </jsp:include>

<h1>body2</h1>

<%@ include file="footer.jsp" %>