package what.the.bus.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession mybatis;

	public BoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return mybatis.selectList("BoardDAO.getBoardList");
	}

	@Override
	public int getListCount() {
		return mybatis.selectOne("BoardDAO.getListCount");
	}

	@Override
	public BoardVO getBoard(int seq) {
		return mybatis.selectOne("BoardDAO.getBoard", seq);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

}
