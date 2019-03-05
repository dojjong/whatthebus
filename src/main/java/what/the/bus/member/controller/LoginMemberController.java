package what.the.bus.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.ChartVO1;
import what.the.bus.admin.ChartVO2;
import what.the.bus.admin.service.GetBannerListService;
import what.the.bus.board.BoardVO;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;
import what.the.bus.main.service.MainListService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.InsertMemberService;
import what.the.bus.member.service.LoginMemberService;
import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.GetSuggestBoardListService;
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
	@Autowired
	private GetBannerListService getBannerListService;
	@Autowired
	private GetBoardListService boardService;
	@Autowired
	private GetSuggestBoardListService suggestBoardService;
	@Autowired
	private MainListService listService;
	@Autowired
	private BookingPayService bookingPayService;
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
		List<AdminVO> bannerList = getBannerListService.getBannerList();
		model.addAttribute("bannerList", bannerList);
		if (memberService.loginMember(mvo) == true) {
			if (memberService.getMember(mvo).getStatecount() == 2) {
				return "main/withdrawMember";
			}
			// model.addAttribute("point", bookingPayService.getMemberPoint(mvo.getId()));
			model.addAttribute("member", memberService.getMember(mvo));
			return "redirect:main.do";
		} else if (driverService.loginDriver(dvo) == true) {
			if (driverService.getDriver(dvo).getStatecount() == 2) {
				return "main/withdrawMember";
			}
			if (driverService.getDriver(dvo).getStatecount() == 3) {
				return "main/approval";
			}
			// model.addAttribute("point", bookingPayService.getDriverPoint(dvo.getId()));
			model.addAttribute("member", driverService.getDriver(dvo));
			return "redirect:main.do";
		} else {
			return "redirect:main.do";
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
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		int maincount = listService.getMainCount();

		model.addAttribute("url", naverAuthUrl);
		List<AdminVO> bannerList = getBannerListService.getBannerList();
		model.addAttribute("bannerList", bannerList);
		List<BoardVO> hotList = listService.hotList(maincount);
		model.addAttribute("hotList", hotList);
		List<BoardVO> recentList = listService.recentList(maincount);
		model.addAttribute("recentList", recentList);
		List<SuggestBoardVO> finishTimeList = listService.finishTimeList(maincount);
		model.addAttribute("finishTimeList", finishTimeList);
		List<NoticeBoardVO> noticeList = listService.noticeList(maincount);
		model.addAttribute("noticeList", noticeList);
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
		return "redirect:view/main.do";
	}

	@RequestMapping(value = "insertNaverMember.do", method = RequestMethod.POST)
	public String insertNaverMember(MemberVO vo, Model model) {

		vo.setPassword("임의값");
		insertMemberService.insertNaverMember(vo);
		model.addAttribute("member", memberService.getMember(vo));
		return "redirect:view/main.do";
	}

	

	@RequestMapping("/view/**/getMyWriteList.do")
	public String getMyWriteList(BoardVO boardVO, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int curPage) {

		MemberVO vo = (MemberVO) session.getAttribute("member");
		String id = vo.getId();

		// 전체리스트 개수
		int listCnt = 0;
		listCnt = memberService.getMyWriteListCount(id);

		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		List<BoardVO> list = memberService.getMyWriteList(start, end, id);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int seq = list.get(i).getSeq();
			int commentCount = boardService.getCommentCount(seq);
			commentCountList.add(i, commentCount);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "member/getMyWriteList";
	}

	@RequestMapping("/view/**/getMyDriveList.do")
	public String getMyDriveList(SuggestBoardVO boardVO, Model model, HttpSession session,
			@RequestParam(defaultValue = "1") int curPage) {

		DriverVO vo = (DriverVO) session.getAttribute("member");
		String id = vo.getId();

		// 전체리스트 개수
		int listCnt = 0;
		listCnt = memberService.getMyDriveListCount(id);

		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();
		List<SuggestBoardVO> list = memberService.getMyDriveList(start, end, id);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int seq = list.get(i).getSeq();
			int commentCount = suggestBoardService.getCommentCount(seq);
			commentCountList.add(i, commentCount);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "driver/getMyDriveList";
	}
}
