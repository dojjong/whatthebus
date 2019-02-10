package what.the.bus.qaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.UpdateQaBoardService;

@Controller
public class UpdateQaBoardController {
	
	@Autowired
	private UpdateQaBoardService qaBoardService;
	
	@RequestMapping("view/**/updateQaForm.do")
	public String updateQaForm(int seq, QaBoardVO vo, Model model) {
		vo = qaBoardService.getQaBoard(seq);
		model.addAttribute("vo", vo);
		return "qaBoard/updateQaForm";
	}
	
	@RequestMapping("view/**/updateQaBoard.do")
	public String updateQaBoard(@ModelAttribute QaBoardVO vo, int seq) {
		vo.setSeq(seq);
		qaBoardService.updateQaBoard(vo);
		return "redirect:getQaBoardList.do";
	}

}
