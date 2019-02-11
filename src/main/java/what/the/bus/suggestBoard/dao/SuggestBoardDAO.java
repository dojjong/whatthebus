package what.the.bus.suggestBoard.dao;

import java.util.List;

import what.the.bus.board.BoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

public interface SuggestBoardDAO {
	void insertSuggestBoard(BoardVO vo);

	List<SuggestBoardVO> getSuggestBoardList();

	int getSuggestBoardListCount();

	BoardVO getSuggestBoard(int seq);

	void updateSuggestBoard(SuggestBoardVO vo);

	void deleteSuggestBoard(SuggestBoardVO vo);

	
}
