package what.the.bus.suggestBoard.service;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface DeleteSuggestBoardService {
	void deleteSuggestBoard(BoardVO vo);

	void deleteSuggestComment(BoardVO vo);

	BoardVO getSuggestBoard(int seq);
}
