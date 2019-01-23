package what.the.bus.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.LoginDriverService;

@Controller
@SessionAttributes("driver")
public class LoginDriverController {
	@Autowired
	private LoginDriverService driverService;

	@RequestMapping("/view/**/loginDriver.do")
	public String loginDriver(DriverVO vo, Model model) {

		if (driverService.loginDriver(vo) == true) {
			model.addAttribute("driver", driverService.getDriver(vo));
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../login/loginError.jsp";
		}
	}
}
