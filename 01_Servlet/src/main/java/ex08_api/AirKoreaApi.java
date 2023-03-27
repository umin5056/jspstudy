package ex08_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AirKoreaApi")
public class AirKoreaApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미
		String sidoName = request.getParameter("sidoName");
		String returnType = request.getParameter("returnType");
		
		// 서비스키
		String serviceKey = "HTH+GuFVSHV08Xp5UnBTYr9Z5H0xYtsU1LQXZe1XuqP1umWgGSUMlMc0JtnkzyAlxDQ8r5O2c2OiqtN2vxbYjA==";
		
		// 요청 주소
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		apiURL += "&sidoName=" + URLEncoder.encode(sidoName,"UTF-8"); // 한글이 포함되어 있어 인코딩 필요
		apiURL += "&returnType=" + URLEncoder.encode(returnType,"UTF-8"); // 코드의 통일성을 주기위해 인코딩(할 필요는 없음)
		
		// URL
		URL url = new URL(apiURL);
		
		// HttpURLConnection
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		// 요청 메소드
		con.setRequestMethod("GET");
		
		// returnType에 따른 Content-Type
		con.setRequestProperty("Content-Type", "application/" + returnType +"; charset=UTF-8");
		
		// 입력 스트림 생성
		BufferedReader reader = null;
		
		if(con.getResponseCode() == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		// 입력 (API의 응답 결과를 StringBuilder에 저장
		StringBuilder sb = new StringBuilder();
		String line = null;
		
		while((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		
		// 입력 스트림, 접속 종료
		reader.close();
		con.disconnect();

//		System.out.println(sb);

		
		// API 결과를 ajax 응답 처리하기
		response.setContentType("application/" + returnType +"; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
