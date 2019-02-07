package what.the.bus.member.service.impl;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.member.MemberVO;
import what.the.bus.member.dao.impl.MemberDAOImpl;

@Service
public class FindIdMemberServiceImpl {
	@Autowired
	private MemberDAOImpl memberDAO;

	public String findId(HttpServletResponse response, MemberVO vo) throws Exception {

		PrintWriter out = response.getWriter();
		String id = memberDAO.findId(vo);

		if (id == null) {
			out.println("<script>");
			out.println("alert('가입된 아이디가 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return id;

		}

	}
}
