package what.the.bus.bookBoard.service;

import what.the.bus.bookBoard.BookBoardVO;

public interface UpdateBookBoardService {
	void updateBookBoard(BookBoardVO vo);
	BookBoardVO getBookBoard(int seq);
}
