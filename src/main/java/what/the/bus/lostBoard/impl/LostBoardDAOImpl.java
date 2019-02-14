package what.the.bus.lostBoard.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.lostBoard.LostBoardVO;
import what.the.bus.lostBoard.dao.LostBoardDAO;
import what.the.bus.util.SqlSessionFactoryBean;
@Repository
public class LostBoardDAOImpl implements LostBoardDAO {

	@Autowired
	private SqlSession mybatis;
	
	public LostBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	@Override
	public void insertLostBoard(LostBoardVO vo) {
		mybatis.insert("LostBoardDAO.insertLostBoard", vo);
	}

	
	@Override
	public List<LostBoardVO> getLostBoardList() {
		return mybatis.selectList("LostBoardDAO.getLostBoardList");
	}
	
	@Override
	public int getLostBoardListCount() {
		return mybatis.selectOne("LostBoardDAO.getLostBoardListCount");
	}
	
	@Override
	public LostBoardVO getLostBoard(int seq) {
		return mybatis.selectOne("LostBoardDAO.getLostBoard", seq);
	}
	
	@Override
	public void updateLostBoard(LostBoardVO vo) {
		mybatis.update("LostBoardDAO.updateLostBoard", vo);
	}
	
	@Override
	public void deleteLostBoard(LostBoardVO vo) {
		mybatis.delete("LostBoardDAO.deleteLostBoard", vo);
	}
}
