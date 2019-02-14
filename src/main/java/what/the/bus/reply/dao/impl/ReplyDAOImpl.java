package what.the.bus.reply.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.dao.ReplyDAO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	SqlSession mybatis;

	@Override
	public List<ReplyVO> getReplyList(Integer seq) {
		return mybatis.selectList("replyDAO.getReplyList", seq);
	}

	@Override
	public void insertReply(ReplyVO vo) {
		mybatis.insert("replyDAO.insertReply", vo);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReply(Integer rno) {
		// TODO Auto-generated method stub
		
	}
	
	
}
