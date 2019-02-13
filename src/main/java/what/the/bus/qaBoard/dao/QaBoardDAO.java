package what.the.bus.qaBoard.dao;

import java.util.List;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaComment.QaCommentVO;


public interface QaBoardDAO {
	void insertQaBoard(QaBoardVO vo); //작성
	
	List<QaBoardVO> getQaBoardList(int start, int end, String searchOption, String keyword); //게시글 전체 목록
	
	QaBoardVO getQaBoard(int seq); //게시글 보기
	
	void updateQaBoard(QaBoardVO vo); //게시글 수정
	
	void deleteQaBoard(QaBoardVO vo); //게시글 삭제
	
	int getQaBoardListCount(QaBoardVO vo); //게시글 조회

	void deleteQaComment(QaBoardVO vo);
	
	int getQaBoardCommentContentListCount(QaCommentVO vo);
	
	int getQaBoardCommentNameListCount(QaCommentVO vo);
	
	int getQaCommentCount(int seq);


}
