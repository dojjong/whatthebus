package what.the.bus.bookBoard.service;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface DeleteBookBoardService {
	void deleteBookBoard(BookBoardVO vo);
	SuggestBoardVO getBookBoard(int seq);
}
