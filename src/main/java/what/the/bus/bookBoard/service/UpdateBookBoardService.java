package what.the.bus.bookBoard.service;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface UpdateBookBoardService {
	void updateBookBoard(SuggestBoardVO vo);
	SuggestBoardVO getBookBoard(int seq);
}
