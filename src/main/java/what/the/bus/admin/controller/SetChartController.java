package what.the.bus.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetChartController {

	@RequestMapping("/view/**/getAdminMain.do")
	public String getAdminMain(Model model) {
		
		return "admin/admin_main";
	}
	
	@RequestMapping("/view/**/getAdminChartMenu.do")
	public String getAdminChart(Model model) {
		
		return "admin/admin_chartMenu";
	}
}
