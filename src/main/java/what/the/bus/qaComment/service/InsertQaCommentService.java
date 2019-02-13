package what.the.bus.qaComment.service;

import java.util.List;

import what.the.bus.qaComment.QaCommentVO;

public interface InsertQaCommentService {
	void insertQaComment(QaCommentVO vo);
	
	List<QaCommentVO> getQaCommentList(QaCommentVO vo);
}
