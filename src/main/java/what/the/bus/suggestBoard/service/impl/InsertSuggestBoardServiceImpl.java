package what.the.bus.suggestBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.dao.SuggestBoardDAO;
import what.the.bus.suggestBoard.service.InsertSuggestBoardService;

@Service
public class InsertSuggestBoardServiceImpl implements InsertSuggestBoardService {
	@Autowired
	private SuggestBoardDAO suggestBoardDAO;
	@Override
	public void insertSuggestBoard(BoardVO vo) {
		suggestBoardDAO.insertSuggestBoard(vo);
	}
	@Override
	public void totalBestCount(BoardVO vo) {
		suggestBoardDAO.totalBestCount(vo);
	}
}
