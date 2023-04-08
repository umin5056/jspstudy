package test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Member;
import repository.MemberDAO;

public class MemberUnitTest {
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	@BeforeClass	// MemberUnitTest 클래스(테스트 파일) 실행 이전에 한 번 먼저 실행된다. (static 필수)
	public static void 삽입테스트() {
		Member member = new Member(0, "admin", "관리자", "M", "seoul");
		assertEquals(1, MemberDAO.getInstance().insertMember(member));
	}
	
	@Test
	public void 목록테스트() {
		assertEquals(1, MemberDAO.getInstance().selectAllMembers().size());
	}

	@Test
	public void 상세테스트() {
		Member member = new Member(1, "admin", "관리자", "M", "seoul");
		assertEquals(MemberDAO.getInstance().selectMemberByNo(1), member); 
	}
	
	@Test
	public void 수정테스트() {
		Member member = new Member(1, null, "new관리자", "F", "newSeoul");
		assertEquals(1, MemberDAO.getInstance().updateMember(member));
	}
	
	@AfterClass		// MemberUnitTest 클래스(테스트 파일) 실행 이후에 한 번 먼저 실행된다. (static 필수)
	public static void 삭제테스트() {
		assertEquals(1, MemberDAO.getInstance().deleteMember(1));
	}
	
}	
