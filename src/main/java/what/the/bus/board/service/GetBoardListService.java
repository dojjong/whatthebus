package what.the.bus.board.service;

import java.util.List;

import what.the.bus.board.BoardVO;

public interface GetBoardListService {
	List<BoardVO> getBoardList();

	Integer getListCount();
}
