package what.the.bus.suggestBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.service.GetSuggestBoardListService;

@Controller
public class GetSuggestBoardListController {
	@Autowired
	private GetSuggestBoardListService suggestBoardService;

	
	
	@RequestMapping("/view/**/getSuggestBoardList.do")
	public String getSuggestBoardList(Model model) {
		// boardService.getListCount();
		List<SuggestBoardVO> list =  suggestBoardService.getSuggestBoardList();
		model.addAttribute("list", list); 
		return "suggestBoard/list";             
	}

	
   @RequestMapping("/view/**/dataTransform.do") 
	@ResponseBody
	public List<SuggestBoardVO> data(SuggestBoardVO vo) {
		// boardService.getListCount();
		List<SuggestBoardVO> list = suggestBoardService.getSuggestBoardList();
		return list;
	}
	
	
	
    @RequestMapping("/view/**/cluster.do") 
	public String data(Model model) {
    	List<SuggestBoardVO> list =  suggestBoardService.getSuggestBoardList();
		model.addAttribute("list", list); 
		return  "suggestBoard/cluster";
	}
}