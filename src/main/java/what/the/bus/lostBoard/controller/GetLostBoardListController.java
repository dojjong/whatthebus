package what.the.bus.lostBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.GetLostBoardListService;

@Controller
public class GetLostBoardListController {
	
	@Autowired
	private GetLostBoardListService lostBoardService;
	
	@RequestMapping("/view/**/getLostBoardList.do")
	public String getLostBoardList(Model model) {
		List<LostBoardVO> list = lostBoardService.getLostBoardList();
		model.addAttribute("list", list);
		
		return "lostBoard/list";
	}
}
