package what.the.bus.noticeBoard.dao;

import java.util.List;

import what.the.bus.noticeBoard.NoticeBoardVO;

public interface NoticeBoardDAO {

	void insertNoticeBoard(NoticeBoardVO vo);
	List<NoticeBoardVO> getNoticeBoardList();
	NoticeBoardVO getNoticeBoard(int seq);
	void updateNoticeBoard(NoticeBoardVO vo);
	void deleteNoticeBoard(NoticeBoardVO vo);
	int getNoticeBoardListCount();
	
}
