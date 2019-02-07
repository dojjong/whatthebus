package what.the.bus.bookBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.service.GetBookBoardListService;

@Controller
public class GetBookBoardListController {
	@Autowired
	private GetBookBoardListService bookBoardService;

	@RequestMapping("/view/**/getBookBoardList.do")
	public String getBookBoardList(Model model) {
		// boardService.getListCount();
		List<BookBoardVO> list = bookBoardService.getBookBoardList();
		model.addAttribute("list", list);
		return "bookBoard/list";
	}
}