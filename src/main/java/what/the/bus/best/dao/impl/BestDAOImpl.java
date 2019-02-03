package what.the.bus.best.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.best.BestVO;
import what.the.bus.best.dao.BestDAO;
import what.the.bus.board.BoardVO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BestDAOImpl implements BestDAO {
	@Autowired
	private SqlSession mybatis;

	public BestDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void best_check(BestVO vo) {
		mybatis.update("BestDAO.best_check", vo);
	}

	@Override
	public void best_cancel(BestVO vo) {
		mybatis.update("BestDAO.best_cancel", vo);
	}

	@Override
	public BestVO getBest(BestVO vo) {
		return mybatis.selectOne("BestDAO.getBest", vo);
	}

	@Override
	public void boardOnBestUpdate(BestVO vo) {
		mybatis.update("BestDAO.boardOnBestUpdate", vo);
	}

	@Override
	public void boardOffBestUpdate(BestVO vo) {
		mybatis.update("BestDAO.boardOffBestUpdate", vo);
	}

	@Override
	public int getBoardBest(int seq) {
		return mybatis.selectOne("BestDAO.getBoardBest", seq);
	}

	@Override
	public int getCheckBest(BestVO vo) {
		return mybatis.selectOne("BestDAO.getCheckBest", vo);
	}

	@Override
	public void insertBest(BestVO vo) {
		mybatis.insert("BestDAO.insertBest", vo);
	}

	

}
