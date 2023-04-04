package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardRemoveService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// get방식으로 삭제를 방지 (주소를 이용해서 아무나 삭제가 가능하기 떄문에
		try {
			if(request.getMethod().equalsIgnoreCase("get")) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 요청입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;	// 컨트롤러로 null 값을 반환하면 컨트롤러는 이동하지 않는다.
								// 서비스에서 직접 이동하는 경우에 이 방법을 사용한다.
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 1. 요청 파라미터
		String strBoard_no = request.getParameter("board_no");
		// <form>으로 파라미터를 전달할 땐 null 값이 오지 않는다. name 속성으로 파라미터를 생성했고, 그 값은 빈문자열이다.
		int board_no = Integer.parseInt(strBoard_no.isEmpty() ? "0" : strBoard_no);
		
		// 2. BoardDAO의 deleteBoard 메소드 호출
		int removeResult = BoardDAO.getInstance().deleteBoard(board_no);
		System.out.println(removeResult == 1 ? "성공" : "실패");
		
		// 3. 어디로 어떻게 이동할 지 지정
		return new ActionForward(request.getContextPath() + "/getAllBoardList.do", true);
	}

}
