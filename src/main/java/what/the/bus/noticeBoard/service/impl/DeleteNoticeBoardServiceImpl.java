package what.the.bus.noticeBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.NoticeBoardDAO;
import what.the.bus.noticeBoard.service.DeleteNoticeBoardService;


@Service
public class DeleteNoticeBoardServiceImpl implements DeleteNoticeBoardService{
	
	@Autowired
	private NoticeBoardDAO noticeBoardDAO;

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
