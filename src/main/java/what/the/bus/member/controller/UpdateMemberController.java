package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.UpdateMemberService;
@Controller
public class UpdateMemberController {
	@Autowired
	private UpdateMemberService memberService;

	// 회원정보 수정
	public String updateMember(MemberVO vo) {
		memberService.updateMember(vo);
		return "redirect:../main/main.jsp";
	}
}
