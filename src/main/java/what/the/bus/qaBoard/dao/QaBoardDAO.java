package what.the.bus.qaBoard.dao;

import java.util.List;

import what.the.bus.qaBoard.QaBoardVO;


public interface QaBoardDAO {
	void insertQaBoard(QaBoardVO vo); //작성
	
	List<QaBoardVO> getQaBoardList(); //게시글 전체 목록
	
	QaBoardVO getQaBoard(int seq); //게시글 보기
	
	void updateQaBoard(QaBoardVO vo); //게시글 수정
	
	void deleteQaBoard(QaBoardVO vo); //게시글 삭제
	
	int getQaBoardListCount(); //게시글 조회
	

}
