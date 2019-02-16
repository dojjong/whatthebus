package what.the.bus.suggestBoard.service;

import what.the.bus.board.BoardVO;

public interface UpdateSuggestBoardService {
	BoardVO getSuggestBoard(int seq);
	void updateSuggestBoard(BoardVO vo);
}
