package what.the.bus.comment.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.dao.CommentDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	private SqlSession mybatis;

	public CommentDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertComment(CommentVO vo) {
		mybatis.insert("CommentDAO.insertComment", vo);
	}

	@Override
	public List<CommentVO> getCommentList(CommentVO vo) {
		return mybatis.selectList("CommentDAO.getCommentList", vo);
	}

	@Override
	public void deleteComment(int cno) {
		mybatis.delete("CommentDAO.deleteComment", cno);
	}

}
