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
<script src="${contextPath}/resources/js/lib.jquery-3.6.4.min.js"></script>
</head>
<body>
	<div>
		<h1>학생 관리</h1>
		<input type="button" value="신규학생등록" onclick='location.href="${contextPath}/write.do"'>
	</div>
	
	<hr>
	
	<div>
		<label for="ave">평균</label>
		<input type="number" id="begin" name="begin" min="0" max="100" style="width: 80px" placeholder="begin"/>
		 ~ 
		<input type="number" id="end" name="end" min="0" max="100" style="width: 80px" placeholder="end"/>
		<input type="button" value="조회">
		<input type="button" value="전체조회">
	</div>
	
	<hr>
	
	<div>
		<c:forEach var="stu" items="${studentList}" varStatus="count">
			<div>${stu.conut}위 ${stu.name}님 ${stu.ave}점</div>
		</c:forEach>
	</div>
	
	<hr>
	
	<div>
		<table border="1">
			<caption>전체 학생 <span id="stu_count">0</span>명</caption>
			<thead>
				<tr>
					<td>학번</td>
					<td>성명</td>
					<td>국어</td>
					<td>영어</td>
					<td>수학</td>
					<td>평균</td>
					<td>학점</td>
					<td>버튼</td>
				</tr>
			</thead>
			<tbody id="list_body"></tbody>
			<tfoot>
			<tr>
				<td colspan="5">전체평균</td>
				<td id="total_ave"></td>
				<td colspan="2"></td>
			</tr>
			</tfoot>
		</table>
	</div>
	
	
	
	
	


</body>
</html>