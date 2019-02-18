package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.admin.service.GetApprovalDriverListService;
import what.the.bus.driver.DriverVO;

@Controller
public class GetApprovalDriverListController {
	@Autowired
	private GetApprovalDriverListService service;

	@RequestMapping("/view/**/moveApprovalDriverList.do")
	public String getApprovalDriverList(Model model) {
		List<DriverVO> list = service.getApprovalDriverList();
		model.addAttribute("list", list);
		return "admin/admin_approval_driver_list";
	}

	@RequestMapping("/view/**/setStateCount.do")
	public String setStateCount(@RequestParam String id) {
		service.setStateCount(id);
		return "redirect:moveApprovalDriverList.do";
	}
}
