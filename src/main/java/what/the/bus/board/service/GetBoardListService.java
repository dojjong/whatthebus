package what.the.bus.board.service;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.comment.CommentVO;

public interface GetBoardListService {
	List<BoardVO> getBoardList(int start, int end, String searchOption, String keyword);

	Integer getListCount(BoardVO vo);

	List<BoardVO> getBoardCommentList(int start, int end, String searchOption, String keyword);

	List<BoardVO> getBoardCNameList(int start, int end, String searchOption, String keyword);

	Integer getBoardCommentContentListCount(CommentVO vo);

	Integer getBoardCommentNameListCount(CommentVO vo);

}
