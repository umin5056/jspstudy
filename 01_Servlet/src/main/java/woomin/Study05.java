package woomin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/Study05")
public class Study05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setCharacterEncoding("UTF-8");
			
			String name = request.getParameter("name");
			String strAge = request.getParameter("age");
			
			int age = 0;
			if(strAge != null && strAge.isEmpty() == false) {
				age = Integer.parseInt(strAge);
			}
			
			if(age < 0) {
				throw new RuntimeException(age + "살은 불가능합니다.");
			}
			
			JSONObject obj = new JSONObject();
			
			obj.put("name", name);
			obj.put("age", age);
			
			response.setContentType("application/json; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
		
			out.println(obj.toString());
			out.flush();
			out.close();
		}catch(RuntimeException e) {
			
			response.setContentType("application/json; charset=UTF-8");
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
