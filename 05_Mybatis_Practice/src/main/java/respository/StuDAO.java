package respository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Student;

public class StuDAO {

	SqlSessionFactory factory;
	
	private static StuDAO dao = new StuDAO();
	private StuDAO() {
		
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static StuDAO getInstance() {
		return dao;
	}
	
	private final String NS = "mybatis.mapper.stu.";
	
	// 목록
	public List<Student> getAllStudent() {
		SqlSession ss = factory.openSession();
		List<Student> studentList = ss.selectList(NS + "getAllStudent");
		ss.close();
		return studentList;
	}
	
	// 상세
	public Student detailStudent(int stuNo) {
		SqlSession ss = factory.openSession();
		Student student = ss.selectOne(NS + "detailStudent", stuNo);
		ss.close();
		return student;
	}
	
	// 추가
	public int addStudent(Student student) {
		SqlSession ss = factory.openSession();
		int insertResult = ss.insert(NS + "addStudent", student);
		ss.close();
		return insertResult;
	}
	
	// 삭제
	public int removeStudent(int stuNo) {
		SqlSession ss = factory.openSession();
		int deleteResult = ss.delete(NS + "removeStudent", stuNo);
		ss.close();
		return deleteResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
