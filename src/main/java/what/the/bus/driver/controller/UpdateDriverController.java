package what.the.bus.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.UpdateDriverService;

@Controller
@SessionAttributes("member")
public class UpdateDriverController {
	@Autowired
	private UpdateDriverService driverService;

	// 회원정보 수정후 수정완료 창으로
	@RequestMapping("/view/**/updateDriver.do")
	public String updateDriver(@ModelAttribute("member") DriverVO vo) {
		driverService.updateDriver(vo);
		return "redirect:../driver/updateCheck.jsp";
	}

	// 정보수정전 DB와 비밀번호 일치여부 체크 후 정보 수정창으로.
	@RequestMapping("/view/**/updateCheckDriver.do")
	public String updateCheckDriver(@ModelAttribute("member") DriverVO vo) {
		if (driverService.pwCheckDriver(vo) == true) {
			return "redirect:../driver/updateDriver.jsp";
		} else {
			return "redirect:../driver/errorUpdatePW.jsp";
		}

	}

	// 비번 변경전 DB와 비밀번호 일치여부 체크 후 비번 변경창으로.
	@RequestMapping("/view/**/pwCheckDriver.do")
	public String pwCheckDriver(@ModelAttribute("member") DriverVO vo) {
		// 비번 일치 검증 후
		if (driverService.pwCheckDriver(vo) == true) {
			return "redirect:../driver/pwUpdateDriver.jsp";
		} else {
			return "redirect:../driver/errorPW.jsp";
		}
	}

	// 회원 비밀번호 변경 후 확인창으로
	@RequestMapping("/view/**/pwUpdateDriver.do")
	public String pwUpdateDriver(@ModelAttribute("member") DriverVO vo) {
		driverService.pwUpdateDriver(vo);
		return "redirect:../driver/updateCheck.jsp";
	}

	// 변경 후 메인페이지로 이동
	@RequestMapping("/view/driver/updateCheck.do")
	public String updateCheck() {
		return "redirect:../main/main.jsp";
	}
}
