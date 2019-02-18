package what.the.bus.eventBoard.dao;

import java.util.List;

import what.the.bus.eventBoard.EventBoardVO;
import what.the.bus.eventComment.EventCommentVO;

public interface EventBoardDAO {

	void insertEventBoard(EventBoardVO vo); // 작성

	List<EventBoardVO> getEventBoardList(int start, int end, String searchOption, String keyword); // 게시글 전체 목록

	EventBoardVO getEventBoard(int seq); // 게시글 보기

	void updateEventBoard(EventBoardVO vo); // 게시글 수정

	void deleteEventBoard(EventBoardVO vo); // 게시글 삭제

	int getEventBoardListCount(EventBoardVO vo); // 게시글 조회

	void deleteEventComment(EventBoardVO vo);

	int getEventBoardCommentContentListCount(EventCommentVO vo);

	int getEventBoardCommentNameListCount(EventCommentVO vo);

	int getEventCommentCount(int seq);

}
