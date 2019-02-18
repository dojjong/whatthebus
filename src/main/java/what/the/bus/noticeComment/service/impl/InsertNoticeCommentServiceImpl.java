package what.the.bus.noticeComment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.dao.NoticeCommentDAO;
import what.the.bus.noticeComment.service.InsertNoticeCommentService;
@Repository
public class InsertNoticeCommentServiceImpl implements InsertNoticeCommentService{
	@Autowired
	private NoticeCommentDAO noticeCommentDAO;

	@Override
	public void insertNoticeComment(NoticeCommentVO vo) {
		noticeCommentDAO.insertNoticeComment(vo);
		
	}

	@Override
	public List<NoticeCommentVO> getNoticeCommentList(NoticeCommentVO vo) {
		return noticeCommentDAO.getNoticeCommentList(vo);
		
	}



	}

