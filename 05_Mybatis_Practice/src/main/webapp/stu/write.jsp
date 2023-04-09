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
	<h1>신규학생등록 화면</h1>
	<form id="frm_write" action="${contextPath}/add.do">
		<div>
			<label for="name">이름</label>
			<input type="text" id="name" name="name" required>
		</div>
		<div>
			<label for="kor">국어</label>
			<input type="text" id="kor" name="kor">
		</div>
		<div>
			<label for="eng">영어</label>
			<input type="text" id="eng" name="eng">
		</div>
		<div>
			<label for="math">수학</label>
			<input type="text" id="math" name="math">
		</div>
		
		<hr>
		
		<div>
			<input type="submit" value="작성완료">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" onclick="location.href='${contextPath}/list.do'"/>
		</div>
	</form>
	
</body>
</html>