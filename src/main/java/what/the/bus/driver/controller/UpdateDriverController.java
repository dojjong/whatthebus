package what.the.bus.driver.controller;

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
import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.UpdateDriverService;
import what.the.bus.member.MemberVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
@SessionAttributes("member")
public class UpdateDriverController {
	@Autowired
	private UpdateDriverService driverService;
	@Autowired
	private BookingPayService bookingPayService;
	@Autowired
	private GetBookBoardService bookBoardService;

	// 회원정보 수정후 수정완료 창으로
	@RequestMapping("/view/**/updateDriver.do")
	public String updateDriver(@ModelAttribute("member") DriverVO vo) {
		driverService.updateDriver(vo);
		return "driver/updateCheck";
	}

	// 정보수정전 DB와 비밀번호 일치여부 체크 후 정보 수정창으로.
	@RequestMapping("/view/**/updateCheckDriver.do")
	public String updateCheckDriver(@ModelAttribute("member") DriverVO vo) {
		if (driverService.pwCheckDriver(vo) == true) {
			return "driver/updateDriver";
		} else {
			return "driver/errorUpdatePW";
		}

	}

	// 비번 변경전 DB와 비밀번호 일치여부 체크 후 비번 변경창으로.
	@RequestMapping("/view/**/pwCheckDriver.do")
	public String pwCheckDriver(@ModelAttribute("member") DriverVO vo) {
		// 비번 일치 검증 후
		if (driverService.pwCheckDriver(vo) == true) {
			return "driver/pwUpdateDriver";
		} else {
			return "driver/errorPW";
		}
	}

	// 회원 비밀번호 변경 후 확인창으로
	@RequestMapping("/view/**/pwUpdateDriver.do")
	public String pwUpdateDriver(@ModelAttribute("member") DriverVO vo) {
		driverService.pwUpdateDriver(vo);
		return "driver/updateCheck";
	}

	// 변경 후 메인페이지로 이동
	@RequestMapping("/view/**/updateCheck.do")
	public String updateCheck() {
		return "main/main";
	}

	// 마이페이지로 이동
	@RequestMapping("/view/**/driverMypage.do")
	public String driverMypage(HttpSession session, Model model) {
		if (session.getAttribute("member").getClass() == DriverVO.class) {
			DriverVO dvo = (DriverVO) session.getAttribute("member");
			model.addAttribute("point", bookingPayService.getDriverPoint(dvo.getId()));
		}
		return "driver/driverMypage";
	}

	// 수정비번확인 창으로 이동
	@RequestMapping("view/**/moveUpdateCheckDriver.do")
	public String moveUpdateCheckDriver() {
		return "driver/updateCheckDriver";
	}

	// 비번변경비번확인 창으로 이동
	@RequestMapping("view/**/movePwCheckDriver.do")
	public String movePwCheckDriver() {
		return "driver/pwCheckDriver";
	}

	@RequestMapping("/view/**/getDriverPointList.do")
	public String getDriverPointList(@RequestParam(defaultValue = "1") int curPage, Model model, HttpSession session) {
		DriverVO vo = (DriverVO) session.getAttribute("member");
		int listCnt = driverService.getDriverPointListCount(vo.getId());
		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();

		List<BookingPayVO> list = driverService.getDriverPointList(start, end, vo.getId());

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

		return "driver/getDriverPointList";
	}
}
