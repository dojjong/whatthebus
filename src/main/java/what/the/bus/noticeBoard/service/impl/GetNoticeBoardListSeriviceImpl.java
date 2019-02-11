package what.the.bus.noticeBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.impl.NoticeBoardDAOImpl;
import what.the.bus.noticeBoard.service.GetNoticeBoardListService;

@Service
public class GetNoticeBoardListSeriviceImpl implements GetNoticeBoardListService{

	@Autowired
	private NoticeBoardDAOImpl noticeBoardDAO;
	
	
	
	public void setNoticeBoardDAO(NoticeBoardDAOImpl noticeBoardDAO) {
		this.noticeBoardDAO = noticeBoardDAO;
	}

	@Override
	public List<NoticeBoardVO> getNoticeBoardList() {
		return noticeBoardDAO.getNoticeBoardList();
	}

	@Override
	public Integer getNoticeBoardListCount(NoticeBoardVO vo) {
		return noticeBoardDAO.getNoticeBoardListCount();
	}

}
