package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.admin.AdminVO;
import what.the.bus.admin.service.GetBannerListService;

@Controller
public class GetBannerListController {

	@Autowired
	private GetBannerListService getBannerListService;
	
	@RequestMapping("view/**/getBannerList.do")
	public String getBannerList(Model model) {
		List<AdminVO> list = getBannerListService.getBannerList();
		model.addAttribute("list", list);
		return "admin/admin_banner_list";
	}
	
	@RequestMapping("view/**/getBannerListChange.do")
	public String getBannerListChange(Model model) {
		List<AdminVO> list = getBannerListService.getBannerList();
		model.addAttribute("list", list);
		return "main/main_banner_center";
	}
	
}
