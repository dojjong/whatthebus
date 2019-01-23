package what.the.bus.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.InsertDriverService;

@Controller
public class InsertDriverController {
	@Autowired
	private InsertDriverService driverService;

	// 회원가입
	@RequestMapping("/view/**/insertDriver.do")
	public String insertDriver(DriverVO vo) {
		driverService.insertDriver(vo);
		return "redirect:../main/main.jsp";
	}
}
