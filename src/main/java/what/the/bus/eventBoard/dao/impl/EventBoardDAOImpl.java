package what.the.bus.eventBoard.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventBoard.dao.EventBoardDAO;
import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class EventBoardDAOImpl implements EventBoardDAO{
	@Autowired
	private SqlSession mybatis;
	

	public EventBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertEventBoard(EventBoardVO vo) {
		mybatis.insert("EventBoardDAO.insertEventBoard", vo);
	}

	@Override
	public List<EventBoardVO> getEventBoardList(int start, int end, String searchOption, String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("EventBoardDAO.getEventBoardList", map);
	}

	@Override
	public EventBoardVO getEventBoard(int seq) {
		mybatis.update("EventBoardDAO.updateEventCnt", seq);
		return mybatis.selectOne("EventBoardDAO.getEventBoard", seq);
	}

	@Override
	public void updateEventBoard(EventBoardVO vo) {
		mybatis.update("EventBoardDAO.updateEventBoard", vo);
		
	}

	@Override
	public void deleteEventBoard(EventBoardVO vo) {
		mybatis.delete("EventBoardDAO.deleteEventBoard", vo);
		
	}

	@Override
	public int getEventBoardListCount(EventBoardVO vo) {
		return mybatis.selectOne("EventBoardDAO.getEventBoardListCount", vo);
	}

	@Override
	public void deleteEventComment(EventBoardVO vo) {
		mybatis.delete("EventBoardDAO.deleteEventComment", vo);
		
	}

	@Override
	public int getEventBoardCommentContentListCount(EventCommentVO vo) {
		return mybatis.selectOne("EventBoardDAO.getEventBoardCommentContentListCount", vo);
	}

	@Override
	public int getEventBoardCommentNameListCount(EventCommentVO vo) {
		return mybatis.selectOne("EventBoardDAO.getEventBoardCommentNameListCount", vo);
	}

	@Override
	public int getEventCommentCount(int seq) {
		return mybatis.selectOne("EventBoardDAO.getEventCommentCount", seq);
	}
	

}
