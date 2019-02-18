package what.the.bus.suggestBoard.service;

import what.the.bus.board.BoardVO;

public interface InsertSuggestBoardService {
	void insertSuggestBoard(BoardVO vo);
	void totalBestCount(BoardVO vo);
}
