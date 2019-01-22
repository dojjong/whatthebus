package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.UpdateMemberService;
@Controller
@SessionAttributes("member")
public class UpdateMemberController {
	@Autowired
	private UpdateMemberService memberService;

	// 회원정보 수정
	@RequestMapping("/view/**/updateMember.do")
	public String updateMember(@ModelAttribute("member")MemberVO vo) {
		memberService.updateMember(vo);
		return "redirect:../main/main.jsp";
	}
}
