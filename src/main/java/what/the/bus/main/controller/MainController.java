package what.the.bus.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/view/**/main.do")
	public String mainStart() {
		return "main/main";
	}
	
	
	//02.04 테스트용 
	@RequestMapping("/view/**/mainfooter.do")
	public String mainFooter() {
		return "main/mainFooter";
	}
	
	@RequestMapping("/view/**/mainheader.do")
	public String mainHeader() {
		return "main/mainHeader";
	}
	
	@RequestMapping("/view/**/adminmain.do")
	public String adminMain() {
		return "admin/admin_main";
	}
	
	@RequestMapping("/view/**/findidandpass.do")
	public String findIdAndPass() {
		return "login/findIdAndPassword";
	}
	
	


}
