package what.the.bus.suggestBoard.service;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface UpdateSuggestBoardService {
	SuggestBoardVO getSuggestBoard(int seq);
	void updateSuggestBoard(SuggestBoardVO vo);
}
