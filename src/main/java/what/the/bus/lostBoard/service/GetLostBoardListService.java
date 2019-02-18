package what.the.bus.lostBoard.service;

import java.util.List;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostComment.LostCommentVO;

public interface GetLostBoardListService {

	List<LostBoardVO>  getLostBoardList(int start, int end, String searchOption, String keyword);
	
	Integer getLostBoardListCount(LostBoardVO vo);
	
	Integer getLostBoardCommentContentListCount(LostCommentVO vo);
	
	Integer getLostBoardCommentNameListCount(LostCommentVO vo);
	
	Integer getLostCommentCount(int seq);
}
