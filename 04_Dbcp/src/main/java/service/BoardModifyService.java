package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardModifyService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		// 1. 요청 파라미터
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int board_no = Integer.parseInt(request.getParameter("board_no").isEmpty() ? "0" :request.getParameter("board_no"));
		
		// 2. 요청 파라미터를 이용해서 BoardDTO board 객체 생성
		BoardDTO board = new BoardDTO();
		board.setTitle(title);
		board.setContent(content);
		board.setBoard_no(board_no);
		
		// 3. BoardDAO의 updateBoard() 호출
		int updateResult = BoardDAO.getInstance().updateBoard(board);
		
		System.out.println(updateResult == 1 ? "성공" : "실패");
		
		// 4. 어디로 어떻게 이동할 지 지정
		return new ActionForward(request.getContextPath() + "/getBoardByNo.do?board_no=" + board_no, true);
	}

}
