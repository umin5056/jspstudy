package service;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberCheckIdService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		Member member = MemberDAO.getInstance().checkMemberId(request.getParameter("id"));
		
		JSONObject obj = new JSONObject();
		obj.put("member", member);

		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
	}

}
