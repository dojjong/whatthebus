package what.the.bus.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.DeleteMemberService;

@Controller
@SessionAttributes("member")
public class DeleteMemberController {
	@Autowired
	private DeleteMemberService memberService;

	// 회원탈퇴
	@RequestMapping("/view/**/deleteMember.do")
	public String deleteMember(@ModelAttribute("member") MemberVO vo, HttpSession session) {
		if(memberService.pwCheckMember(vo) == true) {
			session.invalidate();	
			memberService.deleteMember(vo);
			return "main/main";
	} else {
			return "member/errorPW";
	}
}
	
	@RequestMapping("/view/**/moveDeleteMember.do")
	public String moveDeleteMember() {
		return "member/deleteMember";
	}
}
