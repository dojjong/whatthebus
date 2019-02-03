package what.the.bus.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import what.the.bus.mail.service.MailService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;

@Controller
public class InsertMemberController {
	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	@Autowired
	private InsertMemberService memberService;
	@Autowired
	private MailService mailService;

	// 회원가입
	@RequestMapping("/view/**/insertMember.do")
	public String insertMember(MemberVO vo) {
		memberService.insertMember(vo);
		return "main/main";
	}

	@RequestMapping("/view/**/insertMemberChoice.do")
	public String insertMemberChoice() {
		return "member/insertMemberChoice";
	}
	
	// 기사님으로 가입인지 고객으로 가입인지
	@RequestMapping("/view/**/memberChoice.do")
	public String pageMember(@RequestParam(value = "check", defaultValue = "member", required = false) String check) {
		if (check.equals("driver")) {
			return "driver/insertDriver";
		} else {
			return "member/insertMember";
		}
	}

	// 가입된 아이디가 있는지
	@RequestMapping(value = "/view/**/checkMember.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> checkMember(@RequestBody String checkmember) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		int count = 0;
		count = memberService.checkMember(checkmember);
		map.put("check", count);
		return map;
	}

	// 이메일 중복체크
	@RequestMapping(value = "/view/**/checkEmail.do", method = RequestMethod.POST, produces = "application/text;charset=utf8")
	@ResponseBody
	private String checkMail(HttpSession session, @RequestParam String email) {
		String emailCheck = memberService.checkEmail(email);
		session.invalidate();
		return gson.toJson(emailCheck);
	}

	// 이메일 인증코드.
	@RequestMapping(value = "/view/**/sendEmail.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean sendMail(HttpSession session, @RequestParam String email) {
		int randomCode = new Random().nextInt(10000) + 1000;
		String joinCode = String.valueOf(randomCode);
		session.setAttribute("joinCode", joinCode);

		String subject = "회원가입 승인 번호입니다.";
		StringBuilder sb = new StringBuilder();
		sb.append("회원가입 승인번호는").append(joinCode).append("입니다.");
		return mailService.send(subject, sb.toString(), "WhatTheBus1@gmail.com", email);
	}
	
	//이메일 인증코드와 입력값 확인코드 
	@RequestMapping(value = "/view/**/getJoin.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object,Object> getJoin(HttpSession session,@RequestBody String joinCode) {
		String getJoin = (String)session.getAttribute("joinCode");
		int count = 0;
		if(getJoin.equals(joinCode)) {
			count = 1;
		}else {
			count = 0;
		}
		Map<Object,Object> map = new HashMap<Object,Object>();
		map.put("getJoin", count);
		return map;
	}
	

	
}
