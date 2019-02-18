package what.the.bus.lostComment.dao;

import java.util.List;

import what.the.bus.lostComment.LostCommentVO;

public interface LostCommentDAO {

	void insertLostComment(LostCommentVO vo);
	
	List<LostCommentVO> getLostCommentList(LostCommentVO vo);
	
	void deleteLostComment(int cno);
	
	LostCommentVO getLostComment(int cno);
	
	void updateLostComment(LostCommentVO vo);
}
