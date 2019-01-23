package what.the.bus.driver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.DeleteDriverService;

@Controller
public class DeleteDriverController {
	@Autowired
	private DeleteDriverService driverService;

	// 회원탈퇴
	@RequestMapping("/view/**/insertDriver.do")
	public String deleteDriver(DriverVO vo) {
		driverService.deleteDriver(vo);
		return "redirect:../main/main.jsp";
	}
}
