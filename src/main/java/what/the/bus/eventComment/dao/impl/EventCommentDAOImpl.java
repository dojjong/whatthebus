package what.the.bus.eventComment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.dao.EventCommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class EventCommentDAOImpl implements EventCommentDAO{
	
	@Autowired
	private SqlSession mybatis;
	
	
	
	public EventCommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertEventComment(EventCommentVO vo) {
		mybatis.insert("EventCommentDAO.insertEventComment", vo);
	}

	@Override
	public List<EventCommentVO> getEventCommentList(EventCommentVO vo) {
		return mybatis.selectList("EventCommentDAO.getEventCommentList", vo);
	}

	@Override
	public void deleteEventComment(int cno) {
		mybatis.delete("EventCommentDAO.deleteEventComment", cno);
	}

	@Override
	public EventCommentVO getEventComment(int cno) {
		return mybatis.selectOne("EventCommentDAO.getEventComment", cno);
	}

	@Override
	public void updateEventComment(EventCommentVO vo) {
		mybatis.update("EventCommentDAO.updateEventComment", vo);
	}
	

}
