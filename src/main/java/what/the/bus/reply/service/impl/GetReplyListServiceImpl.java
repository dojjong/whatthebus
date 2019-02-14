package what.the.bus.reply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.reply.ReplyVO;
import what.the.bus.reply.dao.ReplyDAO;
import what.the.bus.reply.service.GetReplyListService;

@Service
public class GetReplyListServiceImpl implements GetReplyListService{
	@Autowired
	ReplyDAO replyDAO;
	
	@Override
	public List<ReplyVO> getReplyList(Integer seq) throws Exception  {
		return replyDAO.getReplyList(seq);
	}



}
