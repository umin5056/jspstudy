<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>
	<h1>학생 상세 조회</h1>
	<div>
		<label for="stuNo">학번</label>
		<input type="text" id="stuNo" value="${student.stuNo}">
	</div>
	<div>
		<label for="name">이름</label>
		<input type="text" id="name" value="${student.name}">
	</div>
	<div>
		<label for="kor">국어</label>
		<input type="text" id="kor" value="${student.kor}">
	</div>
	<div>
		<label for="eng">영어</label>
		<input type="text" id="eng" value="${student.eng}">
	</div>
	<div>
		<label for="math">수학</label>
		<input type="text" id="math" value="${student.math}">
	</div>
	<div>
		<label for="ave">평균</label>
		<input type="text" id="ave" value="${student.ave}">
	</div>
	<div>
		<label for="grade">학점</label>
		<input type="text" id="grade" value="${student.grade}">
	</div>
	<hr>
	<input type="button" value="수정하기" onclick="location.href='${contextPath}/modify.do'"/>
	<input type="button" value="목록" onclick="location.href='${contextPath}/list.do'"/>
</body>
</html>