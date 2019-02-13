package what.the.bus.qaComment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.dao.QaCommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class QaCommentDAOImpl implements QaCommentDAO{
	@Autowired
	private SqlSession mybatis;

	public QaCommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertQaComment(QaCommentVO vo) {
		mybatis.insert("QaCommentDAO.insertQaComment", vo);
	}
	

	@Override
	public List<QaCommentVO> getQaCommentList(QaCommentVO vo) {
		return mybatis.selectList("QaCommentDAO.getQaCommentList", vo);
	}
	

	@Override
	public void deleteQaComment(int cno) {
		mybatis.delete("QaCommentDAO.deleteQaComment", cno);
	}

	@Override
	public QaCommentVO getQaComment(int cno) {
		return mybatis.selectOne("QaCommentDAO.getQaComment", cno);
	}

	@Override
	public void updateQaComment(QaCommentVO vo) {
		mybatis.update("QaCommentDAO.updateQaComment", vo);
	}

}
