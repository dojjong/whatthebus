package what.the.bus.reply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.dao.ReplyDAO;
import what.the.bus.reply.service.UpdateReplyService;

@Service
public class UpdateReplyServiceImpl implements UpdateReplyService{
	@Autowired
	ReplyDAO replyDAO;

	@Override
	public void updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

}
