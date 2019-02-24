package what.the.bus.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.service.LogoutMemberService;

@Controller
public class LogoutMemberController {
	@Autowired
	private LogoutMemberService memberService;

	@RequestMapping("/view/**/logoutMember.do")
	public String logoutMember(HttpSession session) {
		memberService.logoutMember(session);
		return "redirect:main.do";
	}

}
