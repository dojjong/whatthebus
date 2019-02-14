package what.the.bus.noticeBoard.service;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeComment.NoticeCommentVO;

public interface DeleteNoticeBoardService {
		void deleteNoticeBoard(NoticeBoardVO vo);
		NoticeBoardVO getNoticeBoard(int seq);
		void deleteNoticeComment(NoticeBoardVO vo);

}
