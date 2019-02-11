package what.the.bus.noticeBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.impl.NoticeBoardDAOImpl;
import what.the.bus.noticeBoard.service.InsertNoticeBoardService;

@Service
public class InsertNoticeBoardServiceImpl implements InsertNoticeBoardService{

	@Autowired
	private NoticeBoardDAOImpl noticeBoardDAO;
	
	@Override
	public void insertNoticeBoard(NoticeBoardVO vo) {
		noticeBoardDAO.insertNoticeBoard(vo);
	}

}
