package what.the.bus.main.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.mail.service.MailService;
import what.the.bus.main.service.MainService;
import what.the.bus.member.MemberVO;

@Controller
public class MainController {

	@Autowired
	private MailService mailService;
	@Autowired
	private MainService mainService;

	// @RequestMapping("/view/**/main.do")
	// public String mainStart(Model model) {

	// return "main/main";
	// }

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
	public String adminMain(HttpSession session) {
		MemberVO vo = (MemberVO) session.getAttribute("member");
		if (vo == null) {
			return "main/main";
		}
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

	@RequestMapping("/view/**/guide.do")
	public String guide() {
		return "main/guide";
	}

	@RequestMapping("/view/**/termsAndConditions.do")
	public String termsAndConditions() {
		return "main/termsAndConditions";
	}

	// 아이디찾기
	@RequestMapping(value = "/view/**/sendFindId.do", method = RequestMethod.POST)
	public String sendId(MemberVO vo, @RequestParam String email) {
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

	// 비밀번호 찾기 메일전송
	@RequestMapping(value = "/view/**/sendFindPass.do", method = RequestMethod.POST)
	public String sendPass(HttpSession session, MemberVO vo, Model model, @RequestParam String email) {

		int check = mainService.getPWCheck(vo);
		if (check > 0) {
			int randomCode = new Random().nextInt(10000) + 1000;
			String joinCode = String.valueOf(randomCode);
			session.setAttribute("joinCode", joinCode);

			String subject = "WTB 비밀번호 분실 인증번호입니다.";
			StringBuilder sb = new StringBuilder();
			sb.append("고객님의 비밀번호 분실 인증번호는").append(joinCode).append("입니다.");
			mailService.send(subject, sb.toString(), "WhatTheBus1@gmail.com", email);
			session.setAttribute("id", vo.getId());
			return "login/checkPWOK";
		}
		return "login/checkPWError";
	}

	// 이메일 인증코드와 입력값 확인코드
	@RequestMapping(value = "/view/**/findPasswordCheck.do", method = RequestMethod.POST)
	public String getJoin(HttpSession session, @RequestParam String joinCode) {
		String getJoin = (String) session.getAttribute("joinCode");
		if (getJoin.equals(joinCode)) {

			return "login/findUpdatePWCheck";
		}
		return "login/checkPWError";
	}

	// 비밀번호 변경 확인코드
	@RequestMapping(value = "/view/**/findUpdatePassword.do", method = RequestMethod.POST)
	public String updatePWCheck(HttpSession session, @RequestParam String passwordCheck,
			@RequestParam String password) {

		if (password.equals(passwordCheck)) {
			session.setAttribute("password", password);
			return "redirect:findUpdatePW.do";
		}
		return "login/findUpdatePWCheck";
	}

	// 비밀번호 변경코드
	@RequestMapping("/view/**/findUpdatePW.do")
	public String updatePW(HttpSession session, MemberVO vo) {
		vo.setId((String) session.getAttribute("id"));
		vo.setPassword((String) session.getAttribute("password"));
		if (mainService.idCheckMember(vo) > 0) {
			mainService.updatePWMember(vo);
		} else if (mainService.idCheckDriver(vo) > 0) {
			mainService.updatePWDriver(vo);
		}
		session.invalidate();
		return "login/PWUpdate";
	}

}
