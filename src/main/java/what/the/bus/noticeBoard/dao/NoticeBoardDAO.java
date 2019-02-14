package what.the.bus.noticeBoard.dao;

import java.util.List;

import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.noticeComment.NoticeCommentVO;

public interface NoticeBoardDAO {

	void insertNoticeBoard(NoticeBoardVO vo);
	List<NoticeBoardVO> getNoticeBoardList(int start, int end, String searchOption, String keyword);
	NoticeBoardVO getNoticeBoard(int seq);
	void updateNoticeBoard(NoticeBoardVO vo);
	void deleteNoticeBoard(NoticeBoardVO vo);
	int getNoticeBoardListCount(NoticeBoardVO vo);
	
	void deleteNoticeComment(NoticeBoardVO vo);
	int getNoticeCommentContentListCount(NoticeCommentVO vo);
	int getNoticeCommentNameListCount(NoticeCommentVO vo);
	int getNoticeCommentCount(int seq);
	
}
