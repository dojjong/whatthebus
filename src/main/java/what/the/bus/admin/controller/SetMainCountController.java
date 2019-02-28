package what.the.bus.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.admin.service.SetMainCountService;

@Controller
public class SetMainCountController {
	@Autowired
	private SetMainCountService service;

	@RequestMapping("/view/**/moveSetMainCount.do")
	public String moveSetBestCount() {
		return "admin/admin_setMainCount";
	}

	@RequestMapping("/view/**/setMainCount.do")
	@ResponseBody
	public String setMainCount(@RequestParam String mainCount) {
		service.setMainCount(Integer.parseInt(mainCount));
		return "success";
	}
}
