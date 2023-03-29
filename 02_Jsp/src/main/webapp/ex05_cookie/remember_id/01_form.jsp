<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>
	<div>
		<form method="post" action="02_remember.jsp">
			<div><input type='text' name='id' id="id" placeholder="id"></div>
			<div><input type="password" name="pw" placeholder="비밀번호"></div>
			<div>
				<input type="checkbox" name="chk_remember_id" id="chk_remember_id">
				<label for="chk_remember_id">아이디 기억하기</label>
			</div>
			<div><button>로그인</button></div>
		</form>
	</div>
	
	<%
		// remember_id 쿠키값 저장하기 (쿠키값이 없으면 빈 문자열로 처리)
		String rememberId = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("remember_id")){
					rememberId = cookies[i].getValue();
					break;
				}
			}
		}
	%>
	
	<script>
		// String rememebrId가 빈 문자열이 아니면 아이디를 입력하고 추가로 체크박스를 체크해준다.
		if('<%= rememberId %>' != ''){
			$('#id').val('<%= rememberId %>');
			$('#chk_remember_id').prop('checked', true);
		}
		
	</script>
</body>
</html>