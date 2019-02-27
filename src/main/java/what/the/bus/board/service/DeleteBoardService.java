package what.the.bus.board.service;

import what.the.bus.board.BoardVO;

public interface DeleteBoardService {
	void deleteBoard(BoardVO vo);

	void deleteComment(BoardVO vo);

	BoardVO getBoard(int seq);

	void deleteAdminBoard(BoardVO vo);
}
