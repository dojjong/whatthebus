package what.the.bus.suggestBoard.service;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.comment.CommentVO;

public interface GetSuggestBoardListService {
	List<BoardVO> getBoardList(int start, int end, String searchOption, String keyword);

	Integer getListCount(BoardVO vo);

	Integer getBoardCommentContentListCount(CommentVO vo);

	Integer getBoardCommentNameListCount(CommentVO vo);
	
	Integer getCommentCount(int seq);
}
