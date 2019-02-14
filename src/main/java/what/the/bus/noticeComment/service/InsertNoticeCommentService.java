package what.the.bus.noticeComment.service;

import java.util.List;

import what.the.bus.noticeComment.NoticeCommentVO;

public interface InsertNoticeCommentService {
	void insertNoticeComment(NoticeCommentVO vo);
	
	List<NoticeCommentVO> getNoticeCommentList(NoticeCommentVO vo);

}
