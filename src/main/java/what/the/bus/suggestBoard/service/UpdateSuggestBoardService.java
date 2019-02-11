package what.the.bus.suggestBoard.service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface UpdateSuggestBoardService {
	BoardVO getSuggestBoard(int seq);
	void updateSuggestBoard(SuggestBoardVO vo);
}
