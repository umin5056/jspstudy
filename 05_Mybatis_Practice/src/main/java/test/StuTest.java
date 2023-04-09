package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Student;
import respository.StuDAO;

public class StuTest {
	private StuDAO dao = StuDAO.getInstance();
	
	@Test
	public void 목록테스트() {
		assertEquals(0, dao.getAllStudent().size());
	}
	@Test
	public void 삽입테스트() {
		Student stu = new Student();
		stu.setName("김떢상");
		stu.setAve(1.0);
		stu.setEng(1);
		stu.setGrade("A");
		stu.setKor(1);
		stu.setMath(1);
		stu.setStuNo(1);
		assertEquals(1, dao.addStudent(stu));
	}
	
}
