<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<form action="<%= request.getContextPath() %>/ex02_builtin_object/application/save.jsp">
			<div>
				<label for="created_date">작성일자</label>
				<input type="text" name="created_date" id="created_date" value="<%= LocalDate.now() %>" readonly>
			</div>
			<div>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer">
			</div>
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title">
			</div>
			<div>
				<textarea name="content" rows="5" cols="30" placeholder="내용"></textarea>
			</div>
			<div>
				<button>작성완료</button>
				<input type="reset" value="초기화">
			</div>
		</form>
	</div>
</body>
</html>