package what.the.bus.suggestBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.dao.SuggestBoardDAO;
import what.the.bus.suggestBoard.service.UpdateSuggestBoardService;

@Service
public class UpdateSuggestBoardServiceImpl implements UpdateSuggestBoardService {
	@Autowired
	private SuggestBoardDAO suggestBoardDAO;

	@Override
	public void updateSuggestBoard(BoardVO vo) {
		suggestBoardDAO.updateSuggestBoard(vo);
	}
	@Override
	public BoardVO getSuggestBoard(int seq) {
		return suggestBoardDAO.getSuggestBoard(seq);
	}
	


}