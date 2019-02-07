package what.the.bus.bookBoard.service;


import java.util.List;

import what.the.bus.bookBoard.BookBoardVO;

public interface GetBookBoardListService {
	List<BookBoardVO> getBookBoardList();

	Integer getBookBoardListCount();
}
