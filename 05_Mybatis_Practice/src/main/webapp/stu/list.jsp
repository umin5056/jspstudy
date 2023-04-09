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
	<div>
		<h1>학생 관리</h1>
		<input type="button" value="신규학생등록" onclick='location.href="${contextPath}/stu/write.jsp"'>
	</div>
	
	<hr>
	
	<div>
		<form id="frm_detail" action="${contextPath}/detail.do">
			<label for="ave">평균</label>
			<input type="number" id="begin" name="begin" min="0" max="100" style="width: 80px" placeholder="begin"/>
			 ~ 
			<input type="number" id="end" name="end" min="0" max="100" style="width: 80px" placeholder="end"/>
			<input type="button" value="조회">
			<input type="button" value="전체조회">
		</form>
	</div>
	
	<hr>
	
	<div>

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
			<tbody>
				<c:if test="${isNoStudent}">
					<tr>
					<td colspan="8">등록된 학생이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="stu" items="${studentList}">
					<tr>
						<td>${stu.stuNo}</td>
						<td>${stu.name}</td>
						<td>${stu.kor}</td>
						<td>${stu.eng}</td>
						<td>${stu.math}</td>
						<td>${stu.ave}</td>
						<td>${stu.grade}</td>
						<td>
							<input type="button" value="상세" class="btn_detail" data-stu_no="${stu.stuNo}">
							<input type="button" value="삭제" onclick="fnRemove()">
							<form method="post" id="frm_remove" action="${contextPath}/remove.do">
								<input type="hidden" name="stuNo" value="${stu.stuNo}">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
			<tr>
				<td colspan="5">전체평균</td>
				<td id="total_ave"></td>
				<td colspan="2"></td>
			</tr>
			</tfoot>
		</table>
	</div>
	
	<script>
		function fnRemove() {
			if(confirm("삭제함?")) {
				$('#frm_remove').submit();
			}
		}
		
		$('.btn_detail').on('click',function() {
			location.href="${contextPath}/detail.do?stuNo=" + $(this).data('stu_no');
		})
		
	</script>	

</body>
</html>