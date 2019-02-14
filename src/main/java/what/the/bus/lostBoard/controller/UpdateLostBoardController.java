package what.the.bus.lostBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.service.UpdateLostBoardService;

@Controller
public class UpdateLostBoardController {

	@Autowired
	private UpdateLostBoardService lostBoardService;
	
	@RequestMapping("view/**/updateLostForm.do") 
	public String updateLostForm(int seq, LostBoardVO vo, Model model) {
		vo = lostBoardService.getLostBoard(seq);
		model.addAttribute("vo", vo);
		
		return "lostBoard/updateLostForm";
		
	}
	
	@RequestMapping("view/**/updateLostBoard.do")
	public String updateLostBoard(@ModelAttribute LostBoardVO vo, int seq) {
		vo.setSeq(seq);
		lostBoardService.updateLostBoard(vo);
		return "redirect:getLostBoardList.do";
	}
}
