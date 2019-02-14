package what.the.bus.noticeBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.impl.NoticeBoardDAOImpl;
import what.the.bus.noticeBoard.service.DeleteNoticeBoardService;
import what.the.bus.noticeComment.NoticeCommentVO;


@Service
public class DeleteNoticeBoardServiceImpl implements DeleteNoticeBoardService{
	
	@Autowired
	private NoticeBoardDAOImpl noticeBoardDAO;

	@Override
	public void deleteNoticeBoard(NoticeBoardVO vo) {
		noticeBoardDAO.deleteNoticeBoard(vo);
		
	}

	@Override
	public NoticeBoardVO getNoticeBoard(int seq) {
		return noticeBoardDAO.getNoticeBoard(seq);
	}

	@Override
	public void deleteNoticeComment(NoticeBoardVO vo) {
		noticeBoardDAO.deleteNoticeComment(vo);
		
	}
	

}
