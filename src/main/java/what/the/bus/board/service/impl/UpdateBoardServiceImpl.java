package what.the.bus.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.board.service.UpdateBoardService;

@Service
public class UpdateBoardServiceImpl implements UpdateBoardService {
	@Autowired
	private BoardDAOImpl boardDAO;

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}
	@Override
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
		
	}


}
