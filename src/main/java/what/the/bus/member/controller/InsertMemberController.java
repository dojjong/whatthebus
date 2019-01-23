package what.the.bus.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;

@Controller
public class InsertMemberController {
	@Autowired
	private InsertMemberService memberService;

	// 회원가입
	@RequestMapping("/view/**/insertMember.do")
	public String insertMember(MemberVO vo) {
		memberService.insertMember(vo);
		return "redirect:../main/main.jsp";
	}

	// 기사님으로 가입인지 고객으로 가입인지
	@RequestMapping("/view/**/memberChoice.do")
	public String pageMember(@RequestParam(value = "check", defaultValue = "member", required = false) String check) {
		if (check.equals("driver")) {
			return "redirect:../driver/insertDriver.jsp";
		} else {
			return "redirect:../member/insertMember.jsp";
		}

	}
}
