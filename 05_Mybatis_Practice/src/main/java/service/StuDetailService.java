package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Student;
import respository.StuDAO;

public class StuDetailService implements IStuService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getParameter("stuNo"));

		
		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		
		Student student = StuDAO.getInstance().detailStudent(stuNo);
		
		request.setAttribute("student", student);
		
		System.out.println(student);

		
		return new ActionForward("stu/detail.jsp", false) ;
	}

}
