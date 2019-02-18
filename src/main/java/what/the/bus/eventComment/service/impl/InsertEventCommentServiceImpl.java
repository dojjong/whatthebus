package what.the.bus.eventComment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.dao.EventCommentDAO;
import what.the.bus.eventComment.service.InsertEventCommentService;

@Service
public class InsertEventCommentServiceImpl implements InsertEventCommentService{

	@Autowired
	private EventCommentDAO eventcommentDAO;

	@Override
	public void insertEventComment(EventCommentVO vo) {
		eventcommentDAO.insertEventComment(vo);
		
	}

	@Override
	public List<EventCommentVO> getEventCommentList(EventCommentVO vo) {
		return eventcommentDAO.getEventCommentList(vo);
	}
	
	
}
