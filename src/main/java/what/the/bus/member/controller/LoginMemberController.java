package what.the.bus.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.JsonNode;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;
import what.the.bus.member.service.LoginMemberService;
import what.the.bus.util.KakaoLogin;

@Controller
@SessionAttributes("member")
public class LoginMemberController {
	@Autowired
	private LoginMemberService memberService;
	@Autowired
	private LoginDriverService driverService;
	@Autowired
	private InsertMemberService insertMemberService;

	@RequestMapping("/view/**/loginMember.do")
	public String loginMember(MemberVO mvo, DriverVO dvo, Model model) {
		if (memberService.loginMember(mvo) == true) {
			if (memberService.getMember(mvo).getStatecount() == 2) {
				return "main/withdrawMember";
			}
			model.addAttribute("member", memberService.getMember(mvo));
			return "main/main";
		} else if (driverService.loginDriver(dvo) == true) {
			if (driverService.getDriver(dvo).getStatecount() == 2) {
				return "main/withdrawMember";
			}
			if (driverService.getDriver(dvo).getStatecount() == 3) {
				return "main/approval";
			}
			model.addAttribute("member", driverService.getDriver(dvo));
			return "main/main";
		} else {
			return "main/main";
		}
	}

	@RequestMapping(value = "/view/**/loginMemberCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String loginCheckError(MemberVO mvo, DriverVO dvo) {
		if (memberService.loginMember(mvo) == true) {
			return "success";
		} else if (driverService.loginDriver(dvo) == true) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping(value = "/kakaologin.do", produces = "application/json", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) throws Exception {

		JsonNode token = KakaoLogin.getAccessToken(code);

		JsonNode profile = KakaoLogin.getKakaoUserInfo(token.path("access_token").toString());
		// System.out.println(profile);
		MemberVO vo = KakaoLogin.changeData(profile);
		vo.setId("kakao_" + vo.getId());

		// System.out.println(session);
		//System.out.println(vo.toString());

		if (insertMemberService.checkMember(vo.getId()) == 0) {
			model.addAttribute("member", vo);
			return "member/insertKakaoMember";
		}
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}

	@RequestMapping(value = "insertKakaoMember.do", method = RequestMethod.POST)
	public String insertKakaoMember(MemberVO vo,Model model) {
		
		vo.setPassword("임의값");
		insertMemberService.insertKakaoMember(vo);
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}
}
