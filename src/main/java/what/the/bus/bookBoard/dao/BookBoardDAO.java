package what.the.bus.bookBoard.dao;

import java.util.List;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface BookBoardDAO {
	void insertBookBoard(BookBoardVO vo);

	List<SuggestBoardVO> getBookBoardList();

	int getBookBoardListCount();

	SuggestBoardVO getBookBoard(int seq);
	
	void updateBookBoard(BookBoardVO vo);
	
	void deleteBookBoard(BookBoardVO vo);
}
