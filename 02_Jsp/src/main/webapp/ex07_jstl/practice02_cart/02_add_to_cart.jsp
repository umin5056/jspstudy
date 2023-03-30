<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		request.setCharacterEncoding("UTF-8");
	
		String item = request.getParameter("item");
		int itemCount = Integer.parseInt(request.getParameter("item_count"));
		
		// 제품명 + 구매수량을 하나의 Map으로 저장한다.
		Map<String, Object> map = new HashMap<>();
		map.put("item", item);
		map.put("itemCount", itemCount);
		
		// session에 저장된 cart 속성이 있는 지 확인한 뒤 없다면 새로운 cart를 생성해 session에 저장한다.
		List<Map<String, Object>> cart = (List<Map<String, Object>>)session.getAttribute("cart"); // 세션의 "cart"를 메모리의 cart에 저장
		if(cart == null) {
			cart = new ArrayList<>();
			session.setAttribute("cart", cart); // cart의 참조값을 이용해 세션의 "cart"에 저장 || String[] b = a; 일떄 a를 변경하면 b도 수정되는 원리와 같음
		}
		
		// session의 cart에도 map이 저장됨 주소를 공유하고 있기 때문
		cart.add(map);
	%>
	
	<script>
		if(confirm('<%=item%>을 장바구니에 추가했습니다.\n장바구니를 확인하려면 "확인", 계속 쇼핑하려면 "취소" 버튼을 누르세요.')) {
			location.href = '03_cart_list.jsp';
		}else{
			location.href = "01_form.jsp";
		}
	</script>

</body>
</html>