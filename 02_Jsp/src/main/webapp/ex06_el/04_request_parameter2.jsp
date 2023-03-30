<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		파라미터 확인을 위한 EL 객체
		1. param
		2. paramValues
	--%>
	
	<h1>${a}</h1>  <!-- parameter1에서 a 값 전송을 안해주면 application에 저장한 a의 값이 출력된다. -->
	<h1>${param.a}</h1>
	<h1>${paramValues.b[0] }</h1>
	<h1>${paramValues.b[1] }</h1>
	<h1>${paramValues.b[2] }</h1>
	
	<%-- 파라미터 x, y 의 크기 비교(파라미터는 String이기 때문에 사전 편찬 순으로 크기를 비교한다. --%>
	<!-- x("10")과 y("5")를 비교하면 숫자 비교가 아니라 사전순으로 비교해 "5"가 더 크다로 나온다. -->
	<ul>
		<li>${param.x lt param.y}</li>
		<li>${param.x le param.y}</li>
		<li>${param.x gt param.y}</li>
		<li>${param.x ge param.y}</li>
	</ul>
	
	<%-- 파라미터 x, y의 크기 비교 해결(EL에서 "10"-"5" == 5이다.) --%>
		<ul>
		<li>${param.x - param.y lt 0}</li>
		<li>${param.x - param.y le 0}</li>
		<li>${param.x - param.y gt 0}</li>
		<li>${param.x - param.y ge 0}</li>
	</ul>

</body>
</html>