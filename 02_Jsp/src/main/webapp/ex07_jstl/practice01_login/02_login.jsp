<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 시나리오
		// id=admin, pw=1234인 경우 로그인 성공
		if(id.equals("admin") && pw.equals("1234")) {
			
			// 로그인한 회원 정보를 session에 보관하기
			session.setAttribute("loginId", id);
			// 저장 기간을 설정해주는 메소드 : 1 = 1sec
			session.setMaxInactiveInterval(60 * 10); // 세션 유효 시간 : 600초 (10분)
			
		}
		
		// 다시 로그인 폼으로 돌아가기
		response.sendRedirect(request.getContextPath() + "/ex07_jstl/practice01_login/01_form.jsp");
	
	%>



</body>
</html>