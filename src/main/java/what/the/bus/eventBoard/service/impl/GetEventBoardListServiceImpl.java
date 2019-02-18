package what.the.bus.eventBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventBoard.dao.impl.EventBoardDAOImpl;
import what.the.bus.eventBoard.service.GetEventBoardListService;
import what.the.bus.eventComment.EventCommentVO;

@Service
public class GetEventBoardListServiceImpl implements GetEventBoardListService{
	
	@Autowired
	private EventBoardDAO eventboardDAO;
	
	

	public void setEventboardDAO(EventBoardDAOImpl eventboardDAO) {
		this.eventboardDAO = eventboardDAO;
	}

	@Override
	public List<EventBoardVO> getEventBoardList(int start, int end, String searchOption, String keyword) {
		return eventboardDAO.getEventBoardList(start, end, searchOption, keyword);
	}

	@Override
	public Integer getEventBoardListCount(EventBoardVO vo) {
		return eventboardDAO.getEventBoardListCount(vo);
	}

	@Override
	public Integer getEventBoardCommentContentListCount(EventCommentVO vo) {
		return eventboardDAO.getEventBoardCommentContentListCount(vo);
	}

	@Override
	public Integer getEventBoardCommentNameListCount(EventCommentVO vo) {
		return eventboardDAO.getEventBoardCommentNameListCount(vo);
	}

	@Override
	public Integer getEventCommentCount(int seq) {
		return eventboardDAO.getEventCommentCount(seq);
	}
	
	
	

}
