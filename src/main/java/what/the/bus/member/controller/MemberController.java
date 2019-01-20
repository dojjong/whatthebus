package what.the.bus.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;

@Controller
public class MemberController {
	@RequestMapping("/view/join/insertMember.do")
	public String insertBoard(MemberVO vo, MemberDAO memberDAO) {
		memberDAO.insertBoard(vo);
		return "redirect:../main/main.jsp";
	}
}
