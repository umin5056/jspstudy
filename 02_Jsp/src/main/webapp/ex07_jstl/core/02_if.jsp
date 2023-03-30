<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
		<c:if></c:if>
		
		1. if문을 대체하는 태그이다.
		2. else문이 지원되지 않는다.
		3. 형식
			<c:if test="조건식">
				실행문
			</c:if>
	--%>
	
	<c:set var="age" value="10000" scope="page"></c:set>
	<c:if test="${age <= 100}">
		<h1>살아있네~</h1>
	</c:if>
	<c:if test="${age > 100}">
		<h1>죽어있네~</h1>
	</c:if>
	
	<c:set var="score" value="50" scope="page"></c:set>
	<c:if test="${90 <= score}">
		<h1>A등급</h1>
	</c:if>
	<c:if test="${80 <= score && score <90 }">
		<h1>B등급</h1>
	</c:if>
	<c:if test="${70 <= score && score < 80 }">
		<h1>C등급</h1>
	</c:if>
	<c:if test="${score < 70}">
		<h1>D등급</h1>
	</c:if>
	

</body>
</html>