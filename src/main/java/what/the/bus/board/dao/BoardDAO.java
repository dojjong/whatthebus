package what.the.bus.board.dao;

import java.util.List;

import what.the.bus.best.BestVO;
import what.the.bus.board.BoardVO;
import what.the.bus.board.ChartVO1;
import what.the.bus.comment.CommentVO;

public interface BoardDAO {
	void insertBoard(BoardVO vo);

	List<BoardVO> getBoardList(int start,int end, String searchOption,String keyword);

	int getListCount(BoardVO vo);

	BoardVO getBoard(int seq);

	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	void deleteComment(BoardVO vo);
	
	int getCheckBest(BestVO vo);

	int getCheckBestCheck(BestVO vo);

	int getBoardCommentContentListCount(CommentVO vo);

	int getBoardCommentNameListCount(CommentVO vo);

	int getCommentCount(int seq);
	
	List<ChartVO1> getBoardCountPerRegdate();
	
}
