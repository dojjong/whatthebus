package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.DeleteMemberService;

@Controller
public class DeleteMemberController {
	@Autowired
	private DeleteMemberService memberService;

	// 회원탈퇴
	public String deleteMember(MemberVO vo) {
		memberService.deleteMember(vo);
		return "redirect:../main/main.jsp";
	}
}
