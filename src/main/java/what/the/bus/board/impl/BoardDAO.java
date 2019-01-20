package what.the.bus.board.impl;

import org.apache.ibatis.session.SqlSession;

import what.the.bus.board.BoardVO;
import what.the.bus.util.SqlSessionFactoryBean;

public class BoardDAO {
	private SqlSession mybatis;

	public BoardDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
		mybatis.commit();
	}
}
