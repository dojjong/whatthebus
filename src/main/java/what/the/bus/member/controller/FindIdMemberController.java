package what.the.bus.member.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.member.MemberVO;

public class FindIdMemberController {
	
	@RequestMapping("view/**/findId.do")
	public String findId(MemberVO vo){
		return null;
		
	}
}
