package what.the.bus.bookBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.dao.impl.BookBoardDAOImpl;
import what.the.bus.bookBoard.service.GetBookBoardService;

@Service
public class GetBookBoardServiceImpl implements GetBookBoardService{
	@Autowired
	private BookBoardDAOImpl bookBoardDAO;

	@Override
	public BookBoardVO getBookBoard(int seq) {
		return bookBoardDAO.getBookBoard(seq);
		
	}

}