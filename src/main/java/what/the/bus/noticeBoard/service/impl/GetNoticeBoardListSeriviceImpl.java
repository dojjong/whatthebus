package what.the.bus.noticeBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeBoard.dao.impl.NoticeBoardDAOImpl;
import what.the.bus.noticeBoard.service.GetNoticeBoardListService;
import what.the.bus.noticeComment.NoticeCommentVO;

@Service
public class GetNoticeBoardListSeriviceImpl implements GetNoticeBoardListService{

	@Autowired
	private NoticeBoardDAOImpl noticeBoardDAO;
	
	
	
	public void setNoticeBoardDAO(NoticeBoardDAOImpl noticeBoardDAO) {
		this.noticeBoardDAO = noticeBoardDAO;
	}

	@Override
	public List<NoticeBoardVO> getNoticeBoardList(int start, int end, String searchOption, String keyword) {
		return noticeBoardDAO.getNoticeBoardList(start, end, searchOption, keyword);
	}
	
	@Override
	public Integer getNoticeBoardListCount(NoticeBoardVO vo) {
		return noticeBoardDAO.getNoticeBoardListCount(vo);
	}

	@Override
	public Integer getNoticeCommentContentListCount(NoticeCommentVO vo) {
		return noticeBoardDAO.getNoticeCommentContentListCount(vo);
	}

	@Override
	public Integer getNoticeCommentNameListCount(NoticeCommentVO vo) {
		return noticeBoardDAO.getNoticeCommentNameListCount(vo);
	}

	@Override
	public Integer getNoticeCommentCount(int seq) {
		return noticeBoardDAO.getNoticeCommentCount(seq);
	}

	

}
