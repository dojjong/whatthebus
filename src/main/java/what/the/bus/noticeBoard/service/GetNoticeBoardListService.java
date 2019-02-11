package what.the.bus.noticeBoard.service;

import java.util.List;

import what.the.bus.noticeBoard.NoticeBoardVO;

public interface GetNoticeBoardListService {
	List<NoticeBoardVO> getNoticeBoardList();
	Integer getNoticeBoardListCount(NoticeBoardVO vo);

}
