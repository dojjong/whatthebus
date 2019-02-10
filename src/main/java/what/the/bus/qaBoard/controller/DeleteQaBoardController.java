package what.the.bus.qaBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.service.DeleteQaBoardService;

@Controller
public class DeleteQaBoardController {
	@Autowired
	private DeleteQaBoardService qaBoardService;
	
	@RequestMapping("view/**/deleteQaBoard.do")
	public String deleteQaBoard(@ModelAttribute QaBoardVO vo, int seq) {
		vo.setSeq(seq);
		qaBoardService.deleteQaBoard(vo);
		return "redirect:getQaBoardList.do";
	}

}
