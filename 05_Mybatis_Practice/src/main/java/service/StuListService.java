package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Student;
import respository.StuDAO;

public class StuListService implements IStuService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		List<Student> studentList = StuDAO.getInstance().getAllStudent();
		
		request.setAttribute("studentList", studentList);
		
		ActionForward af = new ActionForward();
		
		af.setPath("stu/list.jsp");
		af.setRedirect(false);
		
		return af;
	}

}
