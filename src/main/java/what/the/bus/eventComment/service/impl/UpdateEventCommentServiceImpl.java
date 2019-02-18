package what.the.bus.eventComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.dao.EventCommentDAO;
import what.the.bus.eventComment.service.UpdateEventCommentService;

@Service
public class UpdateEventCommentServiceImpl implements UpdateEventCommentService{

	@Autowired
	private EventCommentDAO eventcommentDAO;

	@Override
	public void updateEventComment(EventCommentVO vo) {
		eventcommentDAO.updateEventComment(vo);
	}
	
	
}
