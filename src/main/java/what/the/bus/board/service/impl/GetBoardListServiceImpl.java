package what.the.bus.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.board.service.GetBoardListService;

@Service
public class GetBoardListServiceImpl implements GetBoardListService {
	@Autowired
	private BoardDAOImpl boardDAO;

	public void setBoardDAO(BoardDAOImpl boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public Integer getListCount() {
		return boardDAO.getListCount();
	}
}
