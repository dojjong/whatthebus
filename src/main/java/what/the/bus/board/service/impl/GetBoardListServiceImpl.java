package what.the.bus.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.board.service.GetBoardListService;
import what.the.bus.comment.CommentVO;

@Service
public class GetBoardListServiceImpl implements GetBoardListService {
	@Autowired
	private BoardDAOImpl boardDAO;

	public void setBoardDAO(BoardDAOImpl boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> getBoardList(int start, int end, String searchOption, String keyword) {
		return boardDAO.getBoardList(start,end,searchOption,keyword);
	}

	@Override
	public Integer getListCount(BoardVO vo) {
		return boardDAO.getListCount(vo);
	}

	@Override
	public List<BoardVO> getBoardCommentList(int start, int end, String searchOption, String keyword) {
		return boardDAO.getBoardCommentList(start,end,searchOption,keyword);
	}

	@Override
	public List<BoardVO> getBoardCNameList(int start, int end, String searchOption, String keyword) {
		return boardDAO.getBoardCNameList(start,end,searchOption,keyword);
	}

	@Override
	public Integer getBoardCommentContentListCount(CommentVO vo) {
		return boardDAO.getBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getBoardCommentNameListCount(CommentVO vo) {
		return boardDAO.getBoardCommentNameListCount(vo);
	}


}
