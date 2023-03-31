<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:set var="str" value="Hello World" scope="page"/>
	
	<h3>${fn:length(str)}</h3>
	<h3>${fn:substring(str, 0, 5)}</h3>
	<h3>${fn:substringBefore(str, ' ')}</h3>
	<h3>${fn:substringAfter(str, ' ')}</h3>
	
	<h3>${fn:indexOf(str, 'l')}</h3>
	<h3>${fn:replace(str, 'l', 'z')}</h3>
	
	<c:set var="str2" value="<script>location.href='/';</script>" scope="page"/>
	<h3>${fn:escapeXml(str2)}</h3> <%-- 사용자가 스크립트를 조작하는걸 막는 함수 --%>
	
	<c:if test="${fn:startsWith(str, 'Hello')}">
		<h3>Hello로 시작한다.</h3>
	</c:if>
	
	<c:if test="${fn:endsWith(str, 'World')}">
		<h3>World로 끝난다.
	</c:if>
	
	<c:if test="${fn:contains(str, 'h')}">
		<h3>h를 포함한다.</h3>
	</c:if>
	<c:if test="${fn:containsIgnoreCase(str, 'h')}">
		<h3> H, h를 포함한다. <h3>
	</c:if>
	
	<c:set var="str3" value="1,2,3,4,5,6,7,8,9,0" scope="page"/>
	<c:set var="items"	value="${fn:split(str3, ',')}" scope="page"/>
	<c:forEach var="item" items="${items}" varStatus="vs">
		<div>${vs.index} - ${item}</div>
	</c:forEach>
	
	<h3>${items}</h3>
	
	<c:set var="str4" value="${fn:join(items, ',')}" scope="page"/>
	<h3>${str4}</h3>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>