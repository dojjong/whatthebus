package what.the.bus.lostComment.service;

import java.util.List;

import what.the.bus.lostComment.LostCommentVO;

public interface InsertLostCommentService {

	
	void insertLostComment(LostCommentVO vo);
	
	List<LostCommentVO> getLostCommentList(LostCommentVO vo);
}
