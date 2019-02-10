package what.the.bus.qaBoard.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaBoard.dao.QaBoardDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class QaBoardDAOImpl implements QaBoardDAO{
	
	@Autowired
	private SqlSession mybatis;

	
	public QaBoardDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}


	@Override
	public void insertQaBoard(QaBoardVO vo) {
		mybatis.insert("QaBoardDAO.insertQaBoard", vo);
	}
	
	@Override
	public List<QaBoardVO> getQaBoardList() {
		return mybatis.selectList("QaBoardDAO.getQaBoardList");
	}
	
	@Override
	public int getQaBoardListCount() {
		return mybatis.selectOne("QaBoardDAO.getQaBoardListCount");
	}
	
	
	@Override
	public QaBoardVO getQaBoard(int seq) {
		return mybatis.selectOne("QaBoardDAO.getQaBoard", seq);
	}

	@Override
	public void updateQaBoard(QaBoardVO vo) {
		mybatis.update("QaBoardDAO.updateQaBoard", vo);
	}

	@Override
	public void deleteQaBoard(QaBoardVO vo) {
		mybatis.delete("QaBoardDAO.deleteQaBoard", vo);
		
	}

	

	
	

}
