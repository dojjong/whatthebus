package what.the.bus.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.mail.service.MailService;
import what.the.bus.main.service.MainService;
import what.the.bus.member.MemberVO;

@Controller
public class MainController {

	@Autowired
	private MailService mailService;
	@Autowired
	private MainService mainService;

	@RequestMapping("/view/**/main.do")
	public String mainStart() {
		return "main/main";
	}

	// 02.04 테스트용
	@RequestMapping("/view/**/mainfooter.do")
	public String mainFooter() {
		return "main/mainFooter";
	}

	@RequestMapping("/view/**/mainheader.do")
	public String mainHeader() {
		return "main/mainHeader";
	}

	@RequestMapping("/view/**/adminmain.do")
	public String adminMain() {
		return "admin/admin_main";
	}

	@RequestMapping("/view/**/findidandpass.do")
	public String findIdAndPass() {
		return "login/findIdAndPassword";
	}

	@RequestMapping("/view/**/site.do")
	public String site() {
		return "main/site";
	}

	@RequestMapping("/view/**/termsAndConditions.do")
	public String termsAndConditions() {
		return "main/termsAndConditions";
	}

	// 아이디찾기
	@RequestMapping(value = "/view/**/sendFindId.do", method = RequestMethod.POST)
	public String sendMail(HttpSession session, MemberVO vo, @RequestParam String email) {
		int check = mainService.getIdCheck(vo);
		if (check == 0) {
			return "login/checkIdError";
		} else if (check > 0) {
			String id = mainService.getId(vo);

			String subject = "WTB 아이디 분실 서비스입니다.";
			StringBuilder sb = new StringBuilder();
			sb.append("고객님의 ID는").append(id).append("입니다.");
			mailService.send(subject, sb.toString(), "WhatTheBus1@gmail.com", email);
			return "login/checkIdOK";
		}
		return "login/checkIdError";
	}

}
