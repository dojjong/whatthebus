package what.the.bus.bookBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.dao.impl.BookBoardDAOImpl;
import what.the.bus.bookBoard.service.DeleteBookBoardService;

@Service
public class DeleteBookBoardServiceImpl implements DeleteBookBoardService {
	@Autowired
	private BookBoardDAOImpl bookBoardDAO;

	@Override
	public void deleteBookBoard(BookBoardVO vo) {
		bookBoardDAO.deleteBookBoard(vo);
	}

	@Override
	public BookBoardVO getBookBoard(int seq) {
		return bookBoardDAO.getBookBoard(seq);
	}

}