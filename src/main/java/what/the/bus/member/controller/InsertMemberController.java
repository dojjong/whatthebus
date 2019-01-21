package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;

@Controller
public class InsertMemberController {
	@Autowired
	private InsertMemberService memberService;

	// 회원가입
	@RequestMapping("/view/join/insertMember.do")
	public String insertMember(MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:../main/main.jsp";
	}
}
