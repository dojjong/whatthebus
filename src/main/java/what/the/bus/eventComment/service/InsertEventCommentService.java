package what.the.bus.eventComment.service;

import java.util.List;

import what.the.bus.eventComment.EventCommentVO;

public interface InsertEventCommentService {
	void insertEventComment(EventCommentVO vo);
	List<EventCommentVO> getEventCommentList(EventCommentVO vo);

}
