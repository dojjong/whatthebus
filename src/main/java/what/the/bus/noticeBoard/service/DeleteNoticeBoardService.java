package what.the.bus.noticeBoard.service;

import what.the.bus.noticeBoard.NoticeBoardVO;

public interface DeleteNoticeBoardService {
		void deleteNoticeBoard(NoticeBoardVO vo);
		NoticeBoardVO getNoticeBoard(int seq);

}
