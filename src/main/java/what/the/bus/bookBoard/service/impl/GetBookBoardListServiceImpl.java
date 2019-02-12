package what.the.bus.bookBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.dao.impl.BookBoardDAOImpl;
import what.the.bus.bookBoard.service.GetBookBoardListService;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Service
public class GetBookBoardListServiceImpl implements GetBookBoardListService {
	@Autowired
	private BookBoardDAOImpl bookBoardDAO;

	public void setBookBoardDAO(BookBoardDAOImpl bookBoardDAO) {
		this.bookBoardDAO = bookBoardDAO;
	}

	@Override
	public List<SuggestBoardVO> getBookBoardList() {
		return bookBoardDAO.getBookBoardList();
	}

	@Override
	public Integer getBookBoardListCount() {
		return bookBoardDAO.getBookBoardListCount();
	}
}