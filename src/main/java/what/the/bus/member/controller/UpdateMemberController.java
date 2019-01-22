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

	// 회원정보 수정후 수정완료 창으로
	@RequestMapping("/view/**/updateMember.do")
	public String updateMember(@ModelAttribute("member") MemberVO vo) {
		memberService.updateMember(vo);
		return "redirect:../join/updateCheck.jsp";
	}

	// 정보수정전 DB와 비밀번호 일치여부 체크 후 정보 수정창으로.
	@RequestMapping("/view/**/updateCheckMember.do")
	public String updateCheckMember(@ModelAttribute("member") MemberVO vo) {
		if (memberService.pwCheckMember(vo) == true) {
			return "redirect:../join/updateMember.jsp";
		} else {
			return "redirect:../join/errorUpdatePW.jsp";
		}

	}

	// 비번 변경전 DB와 비밀번호 일치여부 체크 후 비번 변경창으로.
	@RequestMapping("/view/**/pwCheckMember.do")
	public String pwCheckMember(@ModelAttribute("member") MemberVO vo) {
		// 비번 일치 검증 후
		if (memberService.pwCheckMember(vo) == true) {
			return "redirect:../join/pwUpdateMember.jsp";
		} else {
			return "redirect:../join/errorPW.jsp";
		}
	}

	// 회원 비밀번호 변경 후 확인창으로
	@RequestMapping("/view/**/pwUpdateMember.do")
	public String pwUpdateMember(@ModelAttribute("member") MemberVO vo) {
		memberService.pwUpdateMember(vo);
		return "redirect:../join/updateCheck.jsp";
	}

	// 변경 후 메인페이지로 이동
	@RequestMapping("/view/**/updateCheck.do")
	public String updateCheck() {
		return "redirect:../main/main.jsp";
	}
}
