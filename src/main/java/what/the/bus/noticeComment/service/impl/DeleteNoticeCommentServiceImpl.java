package what.the.bus.noticeComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeComment.dao.NoticeCommentDAO;
import what.the.bus.noticeComment.service.DeleteNoticeCommentService;

@Service
public class DeleteNoticeCommentServiceImpl implements DeleteNoticeCommentService{
	@Autowired
	private NoticeCommentDAO noticeCommentDAO;
	
	@Override
	public void deleteNoticeComment(int cno) {
		noticeCommentDAO.deleteNoticeComment(cno);
		
	}

}
