package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.admin.service.GetMemberListService;
import what.the.bus.driver.DriverVO;
import what.the.bus.member.MemberVO;

@Controller
public class GetMemberListController {

	@Autowired
	private GetMemberListService getMemberListService;

	@RequestMapping("/view/**/getAllMemberList.do")
	public String getAllMemberList(Model model) {
		List<MemberVO> list = getMemberListService.getAllMemberList();
		model.addAttribute("list", list);
		return "admin/admin_all_member_list";
	}

	@RequestMapping("/view/**/getMemberList.do")
	public String getMemberList(Model model) {
		List<MemberVO> list = getMemberListService.getMemberList();
		model.addAttribute("list", list);
		return "admin/admin_member_list";
	}

	@RequestMapping("/view/**/getDriverList.do")
	public String getDriverList(Model model) {
		List<DriverVO> list = getMemberListService.getDriverList();
		model.addAttribute("list", list);
		return "admin/admin_driver_list";
	}

	@RequestMapping("/view/**/expulsionMember.do")
	public String expulsionMember(@RequestParam String id) {
		getMemberListService.expulsionMember(id);
		return "success";
	}

	@RequestMapping("/view/**/expulsionDriver.do")
	public String expulsionDriver(@RequestParam String id) {
		getMemberListService.expulsionDriver(id);
		return "success";
	}
}
