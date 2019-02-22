package what.the.bus.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.admin.service.SetBestCountService;

@Controller
public class SetBestCountController {
	@Autowired
	private SetBestCountService service;

	@RequestMapping("/view/**/moveSetBestCount.do")
	public String moveSetBestCount() {
		return "admin/admin_setBestCount";
	}

	// @RequestMapping("/view/**/setBestCount.do")
	// public String setBestCount(AdminVO vo) {
	// service.setBestCount(vo.getBestcount());
	// return "admin/admin_main";
	// }
	@RequestMapping("/view/**/setBestCount.do")
	@ResponseBody
	public String setStateCount(@RequestParam String bestcount) {
		service.setBestCount(Integer.parseInt(bestcount));
		// return "redirect:moveApprovalDriverList.do";
		return "success";
	}
}
