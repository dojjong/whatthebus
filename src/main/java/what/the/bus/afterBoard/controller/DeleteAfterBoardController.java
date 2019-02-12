package what.the.bus.afterBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.afterBoard.service.DeleteAfterBoardService;
@Controller
public class DeleteAfterBoardController {
	@Autowired
	private DeleteAfterBoardService afterBoardService;

	@RequestMapping(value="/view/**/deleteAfterBoard.do", method=RequestMethod.POST)
	public String deleteAfterBoard(@RequestParam int seq) throws Exception {
		System.out.println("seq="+seq);
		afterBoardService.deleteAfterBoard(seq);
		return "redirect:getAfterBoardList.do";
	}
}
