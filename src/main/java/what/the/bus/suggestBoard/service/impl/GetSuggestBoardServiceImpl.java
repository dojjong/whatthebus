package what.the.bus.suggestBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.dao.impl.SuggestBoardDAOImpl;
import what.the.bus.suggestBoard.service.GetSuggestBoardService;

@Service
public class GetSuggestBoardServiceImpl implements GetSuggestBoardService{
	@Autowired
	private SuggestBoardDAOImpl suggestBoardDAO;

	@Override
	public BoardVO getSuggestBoard(int seq) {
		return suggestBoardDAO.getSuggestBoard(seq);
		
	}

}