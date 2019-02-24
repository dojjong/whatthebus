package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.admin.service.GetMemberListService;
import what.the.bus.driver.DriverVO;
import what.the.bus.mail.service.MailService;
import what.the.bus.member.MemberVO;

@Controller
public class GetMemberListController {

	@Autowired
	private GetMemberListService getMemberListService;
	@Autowired
	private MailService mailService;
	private String fullSearchOption = "all";
	private String fullKeyword = "";

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

	@RequestMapping("/view/**/allExpulstionMember.do")
	@ResponseBody
	public String allExpulstionMember(@RequestParam String id) {
		if (getMemberListService.getExpulstionMember(id) >= 1) {
			getMemberListService.expulsionMember(id);
		} else if (getMemberListService.getExpulstionDriver(id) >= 1) {
			getMemberListService.expulsionDriver(id);
		}
		return "success";
	}

	@RequestMapping("/view/**/expulsionMember.do")
	@ResponseBody
	public String expulsionMember(@RequestParam String id) {
		getMemberListService.expulsionMember(id);
		return "success";
	}

	@RequestMapping("/view/**/expulsionDriver.do")
	@ResponseBody
	public String expulsionDriver(@RequestParam String id) {
		getMemberListService.expulsionDriver(id);
		return "success";
	}

	@RequestMapping("/view/**/allReturnMember.do")
	@ResponseBody
	public String allReturnMember(@RequestParam String id) {
		if (getMemberListService.getExpulstionMember(id) >= 1) {
			getMemberListService.returnMember(id);
		} else if (getMemberListService.getExpulstionDriver(id) >= 1) {
			getMemberListService.returnDriver(id);
		}
		return "success";
	}

	@RequestMapping("/view/**/returnMember.do")
	@ResponseBody
	public String returnMember(@RequestParam String id) {
		getMemberListService.returnMember(id);
		return "success";
	}

	@RequestMapping("/view/**/returnDriver.do")
	@ResponseBody
	public String returnDriver(@RequestParam String id) {
		getMemberListService.returnDriver(id);
		return "success";
	}

	@RequestMapping("/view/**/searchMember.do")
	@ResponseBody
	public String searchMember(@RequestParam(defaultValue = "all") String searchOption,
			@RequestParam(defaultValue = "") String keyword, Model model) {
		fullSearchOption = searchOption;
		fullKeyword = keyword;
		return "success";
	}

	@RequestMapping("/view/**/returnSearchMember.do")
	public String returnSearchMember(Model model) {
		List<MemberVO> list = getMemberListService.searchMember(fullSearchOption, fullKeyword);
		model.addAttribute("list", list);
		return "admin/admin_all_member_list";
	}

	@RequestMapping("/view/**/sendMailMember.do")
	@ResponseBody
	public String moveSendMailForm() {
		return "success";
	}

	@RequestMapping("/view/**/sendMailForm.do")
	public String sendMail(String id, Model model) {
		model.addAttribute("id", id);
		return "admin/sendMailForm";
	}

	@RequestMapping("/view/**/adminSendMail.do")
	@ResponseBody
	public String adminSendMail(String id, String title, String content) {
		System.out.println(id + "," + title + "," + content);
		MemberVO vo = getMemberListService.getMemberOne(id);
		String email = vo.getEmail();
		mailService.send(title, content, "WhatTheBus1@gmail.com", email);
		return "success";
	}

}
