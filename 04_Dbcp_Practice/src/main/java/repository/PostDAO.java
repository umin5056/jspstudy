package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.PostVO;

public class PostDAO {

	private DataSource dataSource;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql = "";
	
	
	private static PostDAO dao = new PostDAO();
	private PostDAO() {
//		dataSource를 활성화 하는 코드
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static PostDAO getInstance() {
		return dao;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<PostVO> getAllPosts() throws Exception {
		List<PostVO> posts = new ArrayList<>();
		con = dataSource.getConnection();
		sql =  "SELECT POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE";
		sql += "  FROM POST"; // 앞에 공백은 필수 (위 문자와 바로 붙기 때문)
		sql += " ORDER BY POST_NO DESC";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			PostVO post = PostVO.builder() // select에 적힌순서가 매개변수로 들어간다.
								.post_no(rs.getInt(1)) 	// setPost_no(rs.getInt(1)과 같은 역할이다.
								.writer(rs.getString(2))
								.title(rs.getString(3))
								.content(rs.getString(4))
								.ip(rs.getString(5))
								.modified_date(rs.getDate(6))
								.created_date(rs.getDate(7))
								.build();
			posts.add(post);
		}
		close();
		
		return posts;
	}
	
	public int savePost(PostVO post) throws Exception{
		con = dataSource.getConnection();
		sql = "INSERT INTO POST(POST_NO, WRITER, TITLE, CONTENT, IP, MODIFIED_DATE, CREATED_DATE)";
		sql += " VALUES(POST_SEQ.NEXTVAL, ?, ?, ?, ?, NULL, SYSDATE)";
		ps = con.prepareStatement(sql);
		ps.setString(1, post.getWriter());
		ps.setString(2, post.getTitle());
		ps.setString(3, post.getContent());
		ps.setString(4, post.getIp());
		
		int saveResult = ps. executeUpdate();
		
		close();
		
		return saveResult;
	}
	
	
	
	
	
}
