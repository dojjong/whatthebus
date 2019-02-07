package what.the.bus.bookBoard.service;

import what.the.bus.bookBoard.BookBoardVO;

public interface DeleteBookBoardService {
	void deleteBookBoard(BookBoardVO vo);
	BookBoardVO getBookBoard(int seq);
}
