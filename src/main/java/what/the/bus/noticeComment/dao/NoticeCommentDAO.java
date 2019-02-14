package what.the.bus.noticeComment.dao;

import java.util.List;

import what.the.bus.noticeComment.NoticeCommentVO;

public interface NoticeCommentDAO {
	void insertNoticeComment(NoticeCommentVO vo);
	
	List<NoticeCommentVO> getNoticeCommentList(NoticeCommentVO vo);
	
	void deleteNoticeComment(int cno);
	
	NoticeCommentVO getNoticeComment(int cno);
	
	void updateNoticeComment(NoticeCommentVO vo);
	

}
