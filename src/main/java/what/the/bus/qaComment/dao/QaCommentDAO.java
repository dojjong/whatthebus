package what.the.bus.qaComment.dao;

import java.util.List;

import what.the.bus.qaComment.QaCommentVO;

public interface QaCommentDAO {
	void insertQaComment(QaCommentVO vo);
	
	List<QaCommentVO> getQaCommentList(QaCommentVO vo);
	
	void deleteQaComment(int cno);
	
	QaCommentVO getQaComment(int cno);
	
	void updateQaComment(QaCommentVO vo);
	

}
