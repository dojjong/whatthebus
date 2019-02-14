package what.the.bus.reply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.reply.dao.ReplyDAO;
import what.the.bus.reply.service.DeleteReplyService;
@Service
public class DeleteReplyServiceImpl implements DeleteReplyService{
	@Autowired
	ReplyDAO replyDAO;
	

	@Override
	public void deleteReply(Integer rno) {
		// TODO Auto-generated method stub
		
	}
}
