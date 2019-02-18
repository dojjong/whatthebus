package what.the.bus.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.service.SetBestCountService;

@Controller
public class SetBestCountController {
	@Autowired
	private SetBestCountService service;
	
	@RequestMapping("/view/**/moveSetBestCount.do")
	public String moveSetBestCount() {
		return "admin/admin_setBestCount";
	}
	
	@RequestMapping("/view/**/setBestCount.do")
	public String setBestCount(AdminVO vo) {
		service.setBestCount(vo.getBestcount());
		return "admin/admin_setBestCount";
	}
}
