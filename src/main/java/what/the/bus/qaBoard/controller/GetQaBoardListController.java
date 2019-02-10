package what.the.bus.qaBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.GetQaBoardListService;

@Controller
public class GetQaBoardListController {

	@Autowired
	private GetQaBoardListService qaBoardService;
	
	@RequestMapping("/view/**/getQaBoardList.do")
	public String getQaBoardList(Model model) {
		List<QaBoardVO> list = qaBoardService.getQaBoardList();
		model.addAttribute("list", list);
		return "qaBoard/list";
		
	}
}
