package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.service.GetBannerListService;

@Controller
public class AdminMainController {
	
	@Autowired
	private GetBannerListService getBannerListService;
	
	@RequestMapping("/view/**/admin_banner.do")
	public String main_banner_center(Model model) {
		
		List<AdminVO> list = getBannerListService.getBannerList();
		model.addAttribute("list", list);
		
		return "admin/admin_banner";
	}

	@RequestMapping("/view/**/selectAdmin.do")
	public String selectAdmin() {
		return "admin/selectAdmin";
	}
}
