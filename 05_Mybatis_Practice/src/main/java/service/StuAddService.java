package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Student;
import respository.StuDAO;

public class StuAddService implements IStuService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int stuNo = Integer.parseInt(request.getParameter("stuNo"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor").isEmpty() ? "0" : request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng").isEmpty() ? "0" : request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math").isEmpty() ? "0" : request.getParameter("math"));
		double ave = (kor + eng + math) / 3.0;
		String grade = (ave >= 90) ? "A" : (ave >= 80) ? "B" : (ave >= 70) ? "C" : "F";
		
		Student student = new Student();
		student.setStuNo(stuNo);
		student.setName(name);
		student.setKor(kor);
		student.setEng(eng);
		student.setMath(math);
		student.setAve(ave);
		student.setGrade(grade);
		
		int insertResult = StuDAO.getInstance().addStudent(student);
		
		ActionForward af = new ActionForward();
		af.setPath("stu/list.jsp");
		
		if(insertResult == 1) {
			af.setRedirect(true);
		}else {
			af.setRedirect(false);			
		}
		return af;
	}

}
