package what.the.bus.eventComment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.eventComment.dao.EventCommentDAO;
import what.the.bus.eventComment.service.DeleteEventCommentService;

@Service
public class DeleteEventCommentServiceImpl implements DeleteEventCommentService{

	@Autowired
	private EventCommentDAO eventcommentDAO;


	public void deleteEventComment(int cno) {
		eventcommentDAO.deleteEventComment(cno);
	}
	
	
}
