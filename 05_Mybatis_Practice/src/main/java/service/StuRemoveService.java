package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import respository.StuDAO;

public class StuRemoveService implements IStuService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		
		System.out.println(stuNo);

		
		int deleteResult = StuDAO.getInstance().removeStudent(stuNo);
		
		if(deleteResult == 1) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('정보가 삭제되었습니다')");
				out.println("location.href='" + request.getContextPath() + "/list.do'");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return new ActionForward(request.getContextPath() + "/list.do", true);
	}

}
