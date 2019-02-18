package what.the.bus.noticeComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.dao.NoticeCommentDAO;
import what.the.bus.noticeComment.service.GetNoticeCommentService;
@Repository
public class GetNoticeCommentServiceImpl implements GetNoticeCommentService{
	@Autowired
	private NoticeCommentDAO noticeCommentDAO;
	
	@Override
	public NoticeCommentVO getNoticeComment(int cno) {
		return noticeCommentDAO.getNoticeComment(cno);
	}

}
