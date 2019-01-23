package what.the.bus.driver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.driver.service.LogoutDriverService;

@Controller
public class LogoutDriverController {
	@Autowired
	private LogoutDriverService driverService;

	@RequestMapping("/view/**/logoutDriver.do")
	public String logoutDriver(HttpSession session) {
		driverService.logoutDriver(session);
		return "redirect:../main/main.jsp";
	}
}
