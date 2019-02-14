package what.the.bus.noticeBoard.service;

import java.util.List;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeComment.NoticeCommentVO;

public interface GetNoticeBoardListService {
	List<NoticeBoardVO> getNoticeBoardList(int start, int end, String searchOption, String keyword);
	Integer getNoticeBoardListCount(NoticeBoardVO vo);

	
	Integer getNoticeCommentContentListCount(NoticeCommentVO vo);
	Integer getNoticeCommentNameListCount(NoticeCommentVO vo);
	Integer getNoticeCommentCount(int seq);
}
