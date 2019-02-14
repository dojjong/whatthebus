package what.the.bus.lostBoard.dao;

import java.util.List;


import what.the.bus.lostBoard.LostBoardVO;

public interface LostBoardDAO {
	void insertLostBoard(LostBoardVO vo); // 작성

	
	List<LostBoardVO> getLostBoardList(); // 게시판 전체 목록

	LostBoardVO getLostBoard(int seq); // 게시글 보기

	void updateLostBoard(LostBoardVO vo); // 게시글 수정

	void deleteLostBoard(LostBoardVO vo); // 게시글 삭제

	int getLostBoardListCount(); // 게시글 조회
	
}
