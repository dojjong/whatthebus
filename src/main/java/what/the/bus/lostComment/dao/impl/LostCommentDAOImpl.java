package what.the.bus.lostComment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.dao.LostCommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class LostCommentDAOImpl implements LostCommentDAO {

	@Autowired
	private SqlSession mybatis;
	
	public LostCommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	@Override
	public void insertLostComment(LostCommentVO vo) {
		mybatis.insert("LostCommentDAO.insertLostComment", vo);
	}

	@Override
	public List<LostCommentVO> getLostCommentList(LostCommentVO vo) {
		return mybatis.selectList("LostCommentDAO.getLostCommentList", vo);
	}

	@Override
	public void deleteLostComment(int cno) {
		mybatis.delete("LostCommentDAO.deleteLostComment", cno);
	}

	@Override
	public LostCommentVO getLostComment(int cno) {
		return mybatis.selectOne("LostCommentDAO.getLostComment", cno);
	}

	@Override
	public void updateLostComment(LostCommentVO vo) {
		mybatis.update("LostCommentDAO.updateLostComment", vo);
	}

}
