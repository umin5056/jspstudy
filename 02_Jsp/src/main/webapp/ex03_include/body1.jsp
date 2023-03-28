<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 동적 include : 포함되는 페이지에 파라미터를 전달할 수 있다. (jsp 액션 태그)--%>
<%-- 추가로 주석을 태그 안에 달면 에러가 발생하므로 주석은 항상 태그 바깥에 작성한다. --%>
<jsp:include page="header.jsp">
	<jsp:param value="body1" name="title"/>
</jsp:include>


	<h1>body1</h1>
	
<script>
	$('h1').css('color', 'red'); //jquery 라이브러리의 동작 확인용
</script>

<%-- 정적 include : 항상 같은 모습의 페이지를 포함한다. --%>
<%@ include file="footer.jsp" %>

