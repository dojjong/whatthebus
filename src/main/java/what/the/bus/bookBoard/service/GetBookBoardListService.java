package what.the.bus.bookBoard.service;

import java.util.List;

import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface GetBookBoardListService {
	List<SuggestBoardVO> getBookBoardList(int start, int end, String searchOption, String keyword);

	Integer getBookBoardListCount(SuggestBoardVO vo);

	Integer getListCount(SuggestBoardVO vo);

	Integer getBoardCommentContentListCount(BookCommentVO vo);

	Integer getBoardCommentNameListCount(BookCommentVO vo);

	Integer getCommentCount(int seq);
	
	List<SuggestBoardVO> cluster();
}
