package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.LoginMemberService;

@Controller
@SessionAttributes("member")
public class LoginMemberController {
	@Autowired
	private LoginMemberService memberService;
	@Autowired
	private LoginDriverService driverService;

	@RequestMapping("/view/**/loginMember.do")
	public String loginMember(MemberVO mvo,DriverVO dvo,Model model) {
		if (memberService.loginMember(mvo) == true) {
			model.addAttribute("member", memberService.getMember(mvo));
			return "redirect:../main/main.jsp";
		} else if (driverService.loginDriver(dvo) == true) {
			model.addAttribute("member", driverService.getDriver(dvo));
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../login/loginError.jsp";
		}
	}
}
