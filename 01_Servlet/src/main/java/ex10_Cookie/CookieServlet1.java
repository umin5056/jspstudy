package ex10_Cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet1")
public class CookieServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		   Cookie
		   1. 서버가 만들어서 클라이언트가 저장한다.
		   2. 보안에 취약하다.
		 */
		
		// 쿠키 만들기
		Cookie cookie1 = new Cookie("name", "조우민");
		Cookie cookie2 = new Cookie("address", URLEncoder.encode("경기도 군포시 금정동", "UTF-8")); // 유효하지 않은 문자(공백)는 UTF-8로 인코딩한다.
		Cookie cookie3 = new Cookie("job", URLEncoder.encode("요양 보호사", "UTF-8"));
		
		// 쿠키가 저장될 경로 설정하기 (생략하면 컨텍스트 패스에 저장된다.)
		cookie1.setPath("/01_Servlet"); 				// 컨텍스트 패스 : request.getContextPath()
		cookie2.setPath("/01_Servlet/CookieServlet1");  // 서블릿 경로 : request.getRequestURI()
		
		// 쿠키 유효시간 설정하기 (생략하면 세션쿠기가 된다. : 브라우저를 닫으면 소멸)
		cookie1.setMaxAge(60 * 60 * 24 * 7); // 7일간 보관되는 쿠기 (1 = 1초)
		cookie2.setMaxAge(60 * 60); 		 // 1시간동안 보관되는 쿠키
		 
		// 쿠키 저장하기(응답으로 처리해야 한다.)
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		// CookieServlet2으로 redirect 이동
		response.sendRedirect("/01_Servlet/CookieServlet2");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
