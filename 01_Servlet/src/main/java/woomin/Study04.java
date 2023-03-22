package woomin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Study04")
public class Study04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		response.setCharacterEncoding("UTF-8");
		
		String model = request.getParameter("model"); 
		String strPrice = request.getParameter("price");
		
		int price = 0;
		if(strPrice != null || strPrice.isEmpty() == false) {
			price = Integer.parseInt(strPrice);
		}
		

		if(price < 0) {
			throw new RuntimeException(price + "원은 입력이 불가능한 금액입니다.");
		}
		
		response.setContentType("text/plain; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("model : " + model + ", price : " + price +"원");
		out.flush();
		out.close();
		}catch(RuntimeException e) {
			
			response.setContentType("text/plain; charset=UTF-8");

			response.setStatus(600);
			
			PrintWriter out = response.getWriter();
			
			out.println(e.getMessage());
			out.flush();
			out.close();
			
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
