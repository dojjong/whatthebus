package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.DeleteMemberService;

@Controller
public class DeleteMemberController {
	@Autowired
	private DeleteMemberService memberService;

	// 회원탈퇴
	@RequestMapping("/view/**/deleteMember.do")
	public String deleteMember(MemberVO vo) {
		memberService.deleteMember(vo);
		return "redirect:../main/main.jsp";
	}
}
