package what.the.bus.bookBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.dao.impl.BookBoardDAOImpl;
import what.the.bus.bookBoard.service.UpdateBookBoardService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Service
public class UpdateBookBoardServiceImpl implements UpdateBookBoardService {
	@Autowired
	private BookBoardDAOImpl bookBoardDAO;

	@Override
	public void updateBookBoard(BookBoardVO vo) {
		bookBoardDAO.updateBookBoard(vo);
	}
	@Override
	public SuggestBoardVO getBookBoard(int seq) {
		return bookBoardDAO.getBookBoard(seq);
		
	}


}