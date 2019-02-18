package what.the.bus.eventComment.dao;

import java.util.List;

import what.the.bus.eventComment.EventCommentVO;

public interface EventCommentDAO {
	
	void insertEventComment(EventCommentVO vo);
	
	List<EventCommentVO> getEventCommentList(EventCommentVO vo);
	
	void deleteEventComment(int cno);
	
	EventCommentVO getEventComment(int cno);
	
	void updateEventComment(EventCommentVO vo);
	

}
