package what.the.bus.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/view/**/main.do")
	public String mainStart() {
		return "main/main";
	}

}
