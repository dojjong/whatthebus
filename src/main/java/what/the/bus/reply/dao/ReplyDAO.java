package what.the.bus.reply.dao;

import java.util.List;

import what.the.bus.reply.ReplyVO;

public interface ReplyDAO {
	//댓글 목록
	public List<ReplyVO> getReplyList(Integer bno);
	
	//댓글 입력
	public void insertReply(ReplyVO vo);
	
	//댓글 수정
	public void updateReply(ReplyVO vo);
	
	//댓글 삭제
	public void deleteReply(Integer rno);
}
