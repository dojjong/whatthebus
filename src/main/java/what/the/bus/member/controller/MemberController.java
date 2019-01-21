package what.the.bus.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;
import what.the.bus.member.impl.MemberDAO;

@Controller
public class MemberController {
	// 회원가입
	@RequestMapping("/view/join/insertMember.do")
	public String insertMember(MemberVO vo, MemberDAO memberDAO) {
		memberDAO.insertMember(vo);
		return "redirect:../main/main.jsp";
	}

	// 회원정보 수정
	public String updateMember(MemberVO vo, MemberDAO memberDAO) {
		memberDAO.updateMember(vo);
		return "redirect:../main/main.jsp";
	}

	// 회원탈퇴
	public String deleteMember(MemberVO vo, MemberDAO memberDAO) {
		memberDAO.deleteMember(vo);
		return "redirect:../main/main.jsp";
	}

	// 로그인처리
	@RequestMapping("/view/login/loginMember.do")
	public String loginMember(MemberVO vo, MemberDAO memberDAO) {
		if (vo.getPassword().equals(memberDAO.loginMember(vo).getPassword())) {
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../login/loginError.jsp";
		}
	}
}
