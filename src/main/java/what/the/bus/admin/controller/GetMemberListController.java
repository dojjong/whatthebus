package what.the.bus.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.admin.service.GetMemberListService;
import what.the.bus.member.MemberVO;

@Controller
public class GetMemberListController {
	
	@Autowired
	private GetMemberListService getMemberListService;
	
	@RequestMapping("/view/**/getMemberList.do")
	public String getMemberList(Model model) {
		List<MemberVO> list = getMemberListService.getMemberList();
		model.addAttribute("list",list);
		return "admin/admin_member_list";
	}
	

}
