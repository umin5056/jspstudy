<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	// 방법 1 : 사용을 지양함
	<a href="/04_Dbcp/getAllBoardList.do">게시판</a>
	
	// 방법 2 : 자바 요소를 사용
	<a href="<%=request.getContextPath() %>/getAllBoardList.do">게시판</a>
	
	
	// 방법 3 : 자바 요소를 분리
	<% pageContext.setAttribute("contextPath", request.getContextPath()); %>
	<a href="${contextPath}/getAllBoardList.do">게시판</a>
 --%>
	
	<%-- 방법 4 : 자바 요소를 사용하지 않음 --%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
	
	<a href="${contextPath}/getAllBoardList.do">게시판</a>
	
	<a href="<c:url value="/getAllBoardList.do"/>">게시판</a>
	

</body>
</html>