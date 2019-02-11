package what.the.bus.noticeBoard.service;

import what.the.bus.noticeBoard.NoticeBoardVO;

public interface UpdateNoticeBoardService {
	NoticeBoardVO getNoticeBoard(int seq);
	void updateNoticeBoard(NoticeBoardVO vo);
	
}
