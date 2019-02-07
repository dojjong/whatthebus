package what.the.bus.suggestBoard.service;

import java.util.List;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface GetSuggestBoardListService {
	List<SuggestBoardVO> getSuggestBoardList();

	Integer getSuggestBoardListCount();
}
