package what.the.bus.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.LoginMemberService;

@Controller
@SessionAttributes("member")
public class LoginMemberController {
	@Autowired
	private LoginMemberService memberService;

	@RequestMapping("/view/login/loginMember.do")
	public String loginMember(MemberVO vo, Model model) {

		if (memberService.loginMember(vo) == true) {
			model.addAttribute("member", memberService.getMember(vo));
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../login/loginError.jsp";
		}
	}
}
