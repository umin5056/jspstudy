package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain.BbsDTO;
import repository.BbsDAO;

public class BbsTest {

	// BbsDAO의 메소드 단위로 테스트를 진행한다.
	private BbsDAO dao = BbsDAO.getInstance();
	
	@Test
	public void 목록테스트() {
		// BbsList의 길이가 2이면 초록색 바가 나오고 아니면 붉은 바가 나온다.
		assertEquals(2, dao.selectAllBbsList().size());
	}
	
	@Test
	public void 상세테스트() {
		// No가 1인 게시글이 있는지 없는지 테스트
		assertNotNull(dao.selectBbsByNo(1));
	}
	
	@Test
	public void 삽입테스트() {
		BbsDTO bbs = new BbsDTO();
		bbs.setTitle("테스트제목");
		bbs.setContent("테스트내용");
		assertEquals(1, dao.insertBbs(bbs));
	}

}
