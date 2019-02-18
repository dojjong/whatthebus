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
			if(memberService.getMember(mvo).getStatecount()==2) {
				return "main/withdrawMember";
			}
			model.addAttribute("member", memberService.getMember(mvo));
			return "main/main";
		} else if (driverService.loginDriver(dvo) == true) {
			if(driverService.getDriver(dvo).getStatecount()==2) {
				return "main/withdrawMember";
			}
			if(driverService.getDriver(dvo).getStatecount()==3) {
				return "main/approval";
			}
			model.addAttribute("member", driverService.getDriver(dvo));
			return "main/main";
		} else {
			return "login/loginError";
		}
	}
}
