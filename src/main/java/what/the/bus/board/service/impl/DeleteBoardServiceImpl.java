package what.the.bus.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.board.service.DeleteBoardService;

@Service
public class DeleteBoardServiceImpl implements DeleteBoardService {
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public void deleteAdminBoard(BoardVO vo) {
		boardDAO.deleteAdminBoard(vo);
	}

	@Override
	public void deleteComment(BoardVO vo) {
		boardDAO.deleteComment(vo);
	}

	@Override
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);
	}

}
