package what.the.bus.member.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.bookBoard.service.GetBookBoardService;
import what.the.bus.booking.BookingPayVO;
import what.the.bus.booking.service.BookingPayService;
import what.the.bus.member.MemberVO;
import what.the.bus.member.service.UpdateMemberService;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
@SessionAttributes("member")
public class UpdateMemberController {
	@Autowired
	private UpdateMemberService memberService;
	@Autowired
	private BookingPayService bookingPayService;
	@Autowired
	private GetBookBoardService bookBoardService;

	// 회원정보 수정후 수정완료 창으로
	@RequestMapping("/view/**/updateMember.do")
	public String updateMember(@ModelAttribute("member") MemberVO vo) {
		memberService.updateMember(vo);
		return "member/updateCheck";
	}

	// 정보수정전 DB와 비밀번호 일치여부 체크 후 정보 수정창으로.
	@RequestMapping("/view/**/updateCheckMember.do")
	public String updateCheckMember(@ModelAttribute("member") MemberVO vo) {
		if (memberService.pwCheckMember(vo) == true) {
			return "member/updateMember";
		} else {
			return "member/errorUpdatePW";
		}

	}

	// 비번 변경전 DB와 비밀번호 일치여부 체크 후 비번 변경창으로.
	@RequestMapping("/view/**/pwCheckMember.do")
	public String pwCheckMember(@ModelAttribute("member") MemberVO vo) {
		// 비번 일치 검증 후
		if (memberService.pwCheckMember(vo) == true) {
			return "member/pwUpdateMember";
		} else {
			return "member/errorPW";
		}
	}

	// 회원 비밀번호 변경 후 확인창으로
	@RequestMapping("/view/**/pwUpdateMember.do")
	public String pwUpdateMember(@ModelAttribute("member") MemberVO vo) {
		memberService.pwUpdateMember(vo);
		return "member/updateCheck";
	}

	// 변경 후 메인페이지로 이동
	@RequestMapping("/view/member/updateCheck.do")
	public String updateCheck() {
		return "main/main";
	}

	// 마이페이지로 이동
	@RequestMapping("/view/**/memberMypage.do")
	public String memberMypage(HttpSession session, Model model) {
		if (session.getAttribute("member").getClass() == MemberVO.class) {
			MemberVO mvo = (MemberVO) session.getAttribute("member");
			model.addAttribute("point", bookingPayService.getMemberPoint(mvo.getId()));
		}
		return "member/memberMypage";
	}

	// 수정비번확인 창으로 이동
	@RequestMapping("/view/**/moveUpdateCheckMember.do")
	public String moveUpdateCheckMember() {
		return "member/updateCheckMember";
	}

	// 비번변경비번확인 창으로 이동
	@RequestMapping("/view/**/movePwCheckMember.do")
	public String movePwCheckMember() {
		return "member/pwCheckMember";
	}

	@RequestMapping("/view/**/getMemberPointList.do")
	public String getMemberPointList(@RequestParam(defaultValue = "1") int curPage, Model model, HttpSession session) {
		MemberVO vo = (MemberVO) session.getAttribute("member");
		int listCnt = memberService.getMemberPointListCount(vo.getId());
		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();

		List<BookingPayVO> list = memberService.getMemberPointList(start, end, vo.getId());
		List<String> titleList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			SuggestBoardVO svo = bookBoardService.getBookBoard(list.get(i).getBusseq());
			titleList.add(i, svo.getTitle());
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("titleList", titleList);
		map.put("list", list);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);

		return "member/getMemberPointList";
	}
}
