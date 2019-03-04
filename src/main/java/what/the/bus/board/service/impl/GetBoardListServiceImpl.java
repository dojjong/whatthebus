package what.the.bus.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.ChartVO1;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.comment.CommentVO;

@Service
public class GetBoardListServiceImpl implements GetBoardListService {
	@Autowired
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAOImpl boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> getBoardList(int start, int end, String searchOption, String keyword) {
		return boardDAO.getBoardList(start, end, searchOption, keyword);
	}

	@Override
	public Integer getListCount(BoardVO vo) {
		return boardDAO.getListCount(vo);
	}

	@Override
	public Integer getBoardCommentContentListCount(CommentVO vo) {
		return boardDAO.getBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getBoardCommentNameListCount(CommentVO vo) {
		return boardDAO.getBoardCommentNameListCount(vo);
	}

	@Override
	public Integer getCommentCount(int seq) {
		return boardDAO.getCommentCount(seq);
	}
	
	@Override
	public List<ChartVO1> getBoardCountPerRegdate() {
		return boardDAO.getBoardCountPerRegdate();
	}


}
