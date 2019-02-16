package what.the.bus.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.DeleteDriverService;

@Controller
@SessionAttributes("member")
public class DeleteDriverController {
	@Autowired
	private DeleteDriverService driverService;

	// 회원탈퇴
	@RequestMapping("/view/**/deleteDriver.do")
	public String deleteDriver(@ModelAttribute("member") DriverVO vo, SessionStatus session) {
		if (driverService.pwCheckDriver(vo) == true) {
			driverService.deleteDriver(vo);
			session.setComplete();
			return "redirect:main.do";
		} else {
			return "driver/errorPW";
		}
	}

	@RequestMapping("/view/**/moveDeleteDriver.do")
	public String moveDeleteDriver() {
		return "driver/deleteDriver";
	}
}
