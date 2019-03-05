package what.the.bus.bookBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.bookBoard.dao.BookBoardDAO;
import what.the.bus.bookBoard.dao.impl.BookBoardDAOImpl;
import what.the.bus.bookBoard.service.GetBookBoardListService;
import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Service
public class GetBookBoardListServiceImpl implements GetBookBoardListService {
	@Autowired
	private BookBoardDAO bookBoardDAO;

	public void setBookBoardDAO(BookBoardDAOImpl bookBoardDAO) {
		this.bookBoardDAO = bookBoardDAO;
	}

	@Override
	public List<SuggestBoardVO> getBookBoardList(int start, int end, String searchOption, String keyword) {
		return bookBoardDAO.getBookBoardList(start,end,searchOption,keyword);
	}

	@Override
	public Integer getBookBoardListCount(SuggestBoardVO vo) {
		return bookBoardDAO.getBookBoardListCount(vo);
	}
	
	@Override
	public Integer getListCount(SuggestBoardVO vo) {
		return bookBoardDAO.getListCount(vo);
	}

	@Override
	public Integer getBoardCommentContentListCount(BookCommentVO vo) {
		return bookBoardDAO.getBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getBoardCommentNameListCount(BookCommentVO vo) {
		return bookBoardDAO.getBoardCommentNameListCount(vo);
	}

	@Override
	public Integer getCommentCount(int seq) {
		return bookBoardDAO.getCommentCount(seq);
	}

	@Override
	public List<SuggestBoardVO> cluster() {
		return bookBoardDAO.cluster();
	}

	@Override
	public List<SuggestBoardVO> getBookBoardListReport(SuggestBoardVO vo) {
		return bookBoardDAO.getBookBoardListReport(vo);
	}
}