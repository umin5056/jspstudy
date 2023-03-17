package practice03;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/datetime")
public class DateTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
//		LocalDateTime now = LocalDateTime.now();
//		int year = now.getYear();
//		int month = now.getMonthValue();
//		int day = now.getDayOfMonth();
//		int hour = now.getHour();
//		int minute = now.getMinute();
//		int second = now.getSecond();
//		String date = (year + " ") + (month + " ") + (day +" ");
//		String time = hour + " " + minute + " " + second + " ";
		
		String result = null;
		switch(type) {
		case "1":  // 현재 날짜 요청
			result = LocalDate.now().toString();
			break;
		case "2":  // 현재 시간 요청
			result = LocalTime.now().toString();
			result = result.substring(0, result.indexOf("."));
			break;
		}
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();

		out.println("<script>");
//		if(type.equals("1")) {
//			System.out.println(date);
//			out.println("alert('" + date + "')");
//		}else {
//			System.out.println(time);
//			out.println("alert('" + time + "')");
//		}
		out.println("alert('요청 결과는 " + result + "입니다.')");
		out.println("</script>");
		out.flush();
		out.close();
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
