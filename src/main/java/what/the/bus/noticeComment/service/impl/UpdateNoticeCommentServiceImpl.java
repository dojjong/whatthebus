package what.the.bus.noticeComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.dao.NoticeCommentDAO;
import what.the.bus.noticeComment.service.UpdateNoticeCommentService;
@Repository
public class UpdateNoticeCommentServiceImpl implements UpdateNoticeCommentService{
	@Autowired
	private NoticeCommentDAO noticeCommentDAO;
	
	@Override
	public void updateNoticeComment(NoticeCommentVO vo) {
		noticeCommentDAO.updateNoticeComment(vo);
		
	}

}
