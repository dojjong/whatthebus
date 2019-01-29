package what.the.bus.board.dao;

import java.util.List;

import what.the.bus.board.BoardVO;

public interface BoardDAO {
	void insertBoard(BoardVO vo);

	List<BoardVO> getBoardList();

	int getListCount();

	BoardVO getBoard(int seq);
	
	void updateBoard(BoardVO vo);
}
