package what.the.bus.suggestBoard.dao;

import java.util.List;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.comment.CommentVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface SuggestBoardDAO {
	void insertSuggestBoard(BoardVO vo);

	List<BoardVO> getSuggestBoardList(int start, int end, String searchOption, String keyword,int bestcount);

	int getSuggestBoardListCount(BoardVO vo);

	BoardVO getSuggestBoard(int seq);

	void updateSuggestBoard(BoardVO vo);

	void deleteSuggestBoard(BoardVO vo);

	int getCheckBest(BestVO vo);

	int getCheckBestCheck(BestVO vo);

	int getBoardCommentContentListCount(CommentVO vo);

	int getBoardCommentNameListCount(CommentVO vo);

	int getCommentCount(int seq);
	
	void deleteSuggestComment(BoardVO vo);
	
	void totalBestCount(BoardVO vo);
	
	}
