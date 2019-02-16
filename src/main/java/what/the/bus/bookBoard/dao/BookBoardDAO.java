package what.the.bus.bookBoard.dao;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface BookBoardDAO {
	void insertBookBoard(SuggestBoardVO vo);

	List<SuggestBoardVO> getBookBoardList(int start, int end, String searchOption, String keyword);

	int getBookBoardListCount(SuggestBoardVO vo);

	SuggestBoardVO getBookBoard(int seq);
	
	void updateBookBoard(BookBoardVO vo);
	
	void deleteBookBoard(BookBoardVO vo);
	
	int getBoardCommentContentListCount(BookCommentVO vo);

	int getBoardCommentNameListCount(BookCommentVO vo);

	int getCommentCount(int seq);
	
	int getListCount(SuggestBoardVO vo);
}
