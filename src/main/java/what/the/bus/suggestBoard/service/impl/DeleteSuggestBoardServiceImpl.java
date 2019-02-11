package what.the.bus.suggestBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.dao.impl.SuggestBoardDAOImpl;
import what.the.bus.suggestBoard.service.DeleteSuggestBoardService;

@Service
public class DeleteSuggestBoardServiceImpl implements DeleteSuggestBoardService {
	@Autowired
	private SuggestBoardDAOImpl suggestBoardDAO;

	@Override
	public void deleteSuggestBoard(SuggestBoardVO vo) {
		suggestBoardDAO.deleteSuggestBoard(vo);
	}

	@Override
	public BoardVO getSuggestBoard(int seq) {
		return suggestBoardDAO.getSuggestBoard(seq);
	}

}
