package what.the.bus.noticeBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.NoticeBoardDAO;
import what.the.bus.noticeBoard.service.GetNoticeBoardService;

@Service
public class GetNoticeBoardServiceImpl implements GetNoticeBoardService{

	@Autowired
	private NoticeBoardDAO noticeBoardDAO;
	
	
	@Override
	public NoticeBoardVO getNoticeBoard(int seq) {
		return noticeBoardDAO.getNoticeBoard(seq);
	}

}
