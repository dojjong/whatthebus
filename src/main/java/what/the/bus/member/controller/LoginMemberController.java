package what.the.bus.member.controller;

import java.io.IOException;

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
import com.github.scribejava.core.model.OAuth2AccessToken;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;
import what.the.bus.member.service.LoginMemberService;
import what.the.bus.util.JsonStringParse;
import what.the.bus.util.KakaoLogin;
import what.the.bus.util.NaverLoginBO;

@Controller
@SessionAttributes("member")
public class LoginMemberController {
	@Autowired
	private LoginMemberService memberService;
	@Autowired
	private LoginDriverService driverService;
	@Autowired
	private InsertMemberService insertMemberService;
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;
	private JsonStringParse jsonparse = new JsonStringParse();

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

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
		// System.out.println(vo.toString());

		if (insertMemberService.checkMember(vo.getId()) == 0) {
			model.addAttribute("member", vo);
			return "member/insertKakaoMember";
		}
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}

	@RequestMapping(value = "insertKakaoMember.do", method = RequestMethod.POST)
	public String insertKakaoMember(MemberVO vo, Model model) {

		vo.setPassword("임의값");
		insertMemberService.insertKakaoMember(vo);
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/view/**/main.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {

		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);

		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		// System.out.println("네이버:" + naverAuthUrl);

		// 네이버
		model.addAttribute("url", naverAuthUrl);

		/* 생성한 인증 URL을 View로 전달 */
		return "main/main";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/**/callback.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException {
		// System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);
		// System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
		model.addAttribute("result", apiResult);
		// System.out.println("result" + apiResult);
		/* 네이버 로그인 성공 페이지 View 호출 */
		org.json.simple.JSONObject jsonobj = jsonparse.stringToJson(apiResult, "response");
		String snsId = jsonparse.JsonToString(jsonobj, "id");
		String name = jsonparse.JsonToString(jsonobj, "name");

		MemberVO vo = new MemberVO();
		vo.setId("naver_" + snsId);
		vo.setName(name);

		if (insertMemberService.checkMember(vo.getId()) == 0) {
			model.addAttribute("member", vo);
			return "member/insertNaverMember";
		}
		model.addAttribute("member", memberService.getMember(vo));
		return "main/main";
	}
	@RequestMapping(value = "insertNaverMember.do", method = RequestMethod.POST)
	public String insertNaverMember(MemberVO vo, Model model) {

		vo.setPassword("임의값");
		insertMemberService.insertNaverMember(vo);
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}
}
