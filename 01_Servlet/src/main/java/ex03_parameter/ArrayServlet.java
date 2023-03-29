package ex03_parameter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArrayServlet")
public class ArrayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ArrayServlet() {
		
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 요청 파라미터(배열)
		String[] tel = request.getParameterValues("tel");
		String[] hobbies = request.getParameterValues("hobbies");
		
		PrintWriter out = response.getWriter();
		out.append("tel : ");
	for(int i=0; i<tel.length; i++) {
		out.append(tel[i] + " ");
	}
		out.append(", hobbies11 : " + Arrays.toString(hobbies));

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
