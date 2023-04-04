package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardAddService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		 // 1. 요청 파라미터 처리
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2. BoardDTO 객체 생성 (요청 파라미터를 하나로 모아 DB로 보내기 위함) : 통상적으로 Map과 객체를 이용한다.	
		BoardDTO board = new BoardDTO();
		board.setTitle(title);
		board.setContent(content);
		
		// 3. 삽입을 위해서 DB로 BoardDTO를 전달(BoardDAO의 insertBoard 메소드)
		int insertResult = BoardDAO.getInstance().insertBoard(board);
		
		System.out.println(insertResult == 1 ? "성공" : "실패");


		// 4. 어디로 어떻게 이동할 지 지정
		return new ActionForward("board/list.jsp", true); // Insert, Update, Delete 이후에는 리다이렉트로 이동
	}

}
