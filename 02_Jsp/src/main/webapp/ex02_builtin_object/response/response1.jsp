<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- HttpServletRequest, HttpServletResponse는 jsp 내장 객체로 따로 선언을 해주지 않아도 사용이 가능한다. --%>

	<%
		response.sendRedirect(request.getContextPath() + "/ex02_builtin_object/response/response2.jsp");
	%>

</body>
</html>