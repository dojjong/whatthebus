package what.the.bus.bookBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.dao.BookBoardDAO;
import what.the.bus.bookBoard.service.InsertBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Service
public class InsertBookBoardServiceImpl implements InsertBookBoardService {
	@Autowired
	private BookBoardDAO bookBoardDAO;
	@Override
	public void insertBookBoard(SuggestBoardVO vo) {
		bookBoardDAO.insertBookBoard(vo);
	}

}
