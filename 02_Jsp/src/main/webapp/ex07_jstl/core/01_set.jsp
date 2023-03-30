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
		<c:set> </c:set>
		1. 속성(Attribute)을 만드는 태그이다.
		2. binding 영역(pageContext, request, session, application)을 지정할 수 있다.
		3. 형식
			<c:set var="속성이름" value="값" scope="영역">
		4. 예시
			<c:set var="a" value="1" scope="page"></c:set>
			<c:set var="a" value="10" scope="request"></c:set>
			<c:set var="a" value="100" scope="session"></c:set>
			<c:set var="a" value="1000" scope="application></c:set>
	 --%>	

	<c:set var="age" value="3" scope="page"></c:set>
	<c:set var="isAlive" value="${age le 100}" scope="page"></c:set>
	bmi =  몸무게(kg) / 키(m) * 키(m)
	bmi < 20 : 저체중
	bmi < 25 : 정상
	그 외 	 : 비만
	
	<c:set var="height" value="1.79" scope="page"></c:set>
	<c:set var="weight" value="73" scope="page"></c:set>
	<c:set var="bmi"	value="${weight / (height * height)}" scope="page"></c:set>
	<c:set var="health"	value="${(bmi < 20) ? '저체중' : (bmi < 25) ? '정상' : '비만'}"	scope="page"></c:set>
	
	<ul>
		<li>나이 : ${age}살</li>
		<li>생존 : ${isAlive ? '생존' : '사망'}</li>
		<li>bmi지수 : ${bmi}</li> 
		<li>건강상태 : ${health}</li> 
	</ul>

</body>
</html>