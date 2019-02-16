package what.the.bus.suggestBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.comment.CommentVO;
import what.the.bus.suggestBoard.dao.SuggestBoardDAO;
import what.the.bus.suggestBoard.service.GetSuggestBoardListService;
@Service
public class GetSuggestBoardListServiceImpl implements GetSuggestBoardListService {

	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private SuggestBoardDAO suggestBoardDAO;
	public void setBoardDAO(BoardDAOImpl boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> getSuggestBoardList(int start, int end, String searchOption, String keyword,int bestcount) {
		return suggestBoardDAO.getSuggestBoardList(start, end, searchOption, keyword,bestcount);
	}

	@Override
	public Integer getSuggestBoardListCount(BoardVO vo) {
		return suggestBoardDAO.getSuggestBoardListCount(vo);
	}

	@Override
	public Integer getBoardCommentContentListCount(CommentVO vo) {
		return suggestBoardDAO.getBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getBoardCommentNameListCount(CommentVO vo) {
		return suggestBoardDAO.getBoardCommentNameListCount(vo);
	}

	@Override
	public Integer getCommentCount(int seq) {
		return suggestBoardDAO.getCommentCount(seq);
	}

}
