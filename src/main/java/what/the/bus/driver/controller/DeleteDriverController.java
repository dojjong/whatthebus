package what.the.bus.driver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import what.the.bus.driver.DriverVO;
import what.the.bus.driver.service.DeleteDriverService;

@Controller
@SessionAttributes("member")
public class DeleteDriverController {
	@Autowired
	private DeleteDriverService driverService;

	// 회원탈퇴
	@RequestMapping("/view/**/deleteDriver.do")
	public String deleteDriver(@ModelAttribute("member") DriverVO vo, HttpSession session) {
		if (driverService.pwCheckDriver(vo) == true) {
			
			driverService.deleteDriver(vo);
			session.invalidate();
			return "redirect:../main/main.jsp";
		} else {
			return "redirect:../driver/errorPW.jsp";
		}
	
	}
}
