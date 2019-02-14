package what.the.bus.reply.service;

import java.util.List;

import what.the.bus.reply.ReplyVO;

public interface GetReplyListService {
	//댓글목록
	public List<ReplyVO> getReplyList(Integer seq) throws Exception ;
	
}
