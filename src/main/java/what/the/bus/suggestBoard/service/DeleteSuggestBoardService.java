package what.the.bus.suggestBoard.service;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface DeleteSuggestBoardService {
	void deleteSuggestBoard(SuggestBoardVO vo);
	SuggestBoardVO getSuggestBoard(int seq);
}
