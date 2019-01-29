package what.the.bus.board.service;

import what.the.bus.board.BoardVO;

public interface DeleteBoardService {
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(int seq);
}
