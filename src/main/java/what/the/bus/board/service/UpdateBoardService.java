package what.the.bus.board.service;

import what.the.bus.board.BoardVO;

public interface UpdateBoardService {
	void updateBoard(BoardVO vo);
	BoardVO getBoard(int seq);
}
