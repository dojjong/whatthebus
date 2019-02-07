package what.the.bus.bookBoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.board.BoardVO;
import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.service.UpdateBookBoardService;

@Controller
public class UpdateBookBoardController {
	@Autowired
	private UpdateBookBoardService bookBoardService;

	@RequestMapping("/view/**/updateBookForm.do")
	public String updateBookForm(int seq,BookBoardVO vo,Model model) {
		vo = bookBoardService.getBookBoard(seq);
		model.addAttribute("vo", vo);
		return "bookBoard/updateBookForm";
	}
	
	
	@RequestMapping("/view/**/updateBookBoard.do")
	public String updateBookBoard(@ModelAttribute BookBoardVO vo,int seq) {
		vo.setSeq(seq);
		bookBoardService.updateBookBoard(vo);
		return "redirect:getBookBoardList.do";
	}

}
