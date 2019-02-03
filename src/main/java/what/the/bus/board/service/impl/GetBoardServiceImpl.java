package what.the.bus.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.impl.BoardDAOImpl;
import what.the.bus.board.service.GetBoardService;

@Service
public class GetBoardServiceImpl implements GetBoardService {
	@Autowired
	private BoardDAOImpl boardDAO;

	@Override
	public BoardVO getBoard(int seq) {
		return boardDAO.getBoard(seq);

	}

	@Override
	public int getCheckBest(BestVO vo) {
		return boardDAO.getCheckBest(vo);
	}

	@Override
	public int getCheckBestCheck(BestVO vo) {
		return boardDAO.getCheckBestCheck(vo);
	}

}
