package what.the.bus.bookBoard.service;


import java.util.List;

import what.the.bus.suggestBoard.SuggestBoardVO;

public interface GetBookBoardListService {
	List<SuggestBoardVO> getBookBoardList();

	Integer getBookBoardListCount();
}
