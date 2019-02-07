package what.the.bus.suggestBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.dao.impl.SuggestBoardDAOImpl;
import what.the.bus.suggestBoard.service.InsertSuggestBoardService;

@Service
public class InsertSuggestBoardServiceImpl implements InsertSuggestBoardService {
	@Autowired
	private SuggestBoardDAOImpl suggestBoardDAO;
	@Override
	public void insertSuggestBoard(SuggestBoardVO vo) {
		suggestBoardDAO.insertSuggestBoard(vo);
	}

}
