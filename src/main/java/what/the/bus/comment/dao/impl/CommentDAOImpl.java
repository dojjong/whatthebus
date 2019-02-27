package what.the.bus.comment.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public CommentVO getComment(int cno) {
		return mybatis.selectOne("CommentDAO.getComment", cno);
	}

	@Override
	public void updateComment(CommentVO vo) {
		mybatis.update("CommentDAO.updateComment", vo);
	}

	@Override
	public void deleteAdminComment(int cno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("content", "관리자에 의해 삭제된 댓글입니다.");
		map.put("id", "admin");
		map.put("name", "관리자");
		map.put("cno", cno);
		mybatis.update("CommentDAO.deleteAdminComment", map);
	}

}
