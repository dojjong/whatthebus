package what.the.bus.reply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.dao.ReplyDAO;
import what.the.bus.reply.service.InsertReplyService;
@Service
public class InsertReplyServiceImpl implements InsertReplyService{
	@Autowired
	ReplyDAO replyDAO;


	@Override
	public void insertReply(ReplyVO vo) {
		replyDAO.insertReply(vo);
	}

}
