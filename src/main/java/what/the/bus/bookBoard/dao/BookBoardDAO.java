package what.the.bus.bookBoard.dao;

import java.util.List;
import what.the.bus.bookBoard.BookBoardVO;

public interface BookBoardDAO {
	void insertBookBoard(BookBoardVO vo);

	List<BookBoardVO> getBookBoardList();

	int getBookBoardListCount();

	BookBoardVO getBookBoard(int seq);
	
	void updateBookBoard(BookBoardVO vo);
}
