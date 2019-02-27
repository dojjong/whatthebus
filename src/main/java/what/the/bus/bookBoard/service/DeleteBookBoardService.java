package what.the.bus.bookBoard.service;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface DeleteBookBoardService {
	void deleteBookBoard(SuggestBoardVO vo);
	SuggestBoardVO getBookBoard(int seq);
}
