package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.LoginMemberService;

@Controller
public class LoginMemberController {
	@Autowired
	private LoginMemberService memberService;

	@RequestMapping("/view/login/loginMember.do")
	public String loginMember(MemberVO vo) {

		if (memberService.loginMember(vo) == true) {
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../login/loginError.jsp";
		}
	}
}
