package what.the.bus.eventComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.dao.EventCommentDAO;
import what.the.bus.eventComment.service.GetEventCommentService;
@Service
public class GetEventCommentServiceImpl implements GetEventCommentService{
	@Autowired
	private EventCommentDAO eventcommentDAO;

	@Override
	public EventCommentVO getEventComment(int cno) {
		return eventcommentDAO.getEventComment(cno);
	}
	
	

}
