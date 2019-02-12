package what.the.bus.afterBoard.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import what.the.bus.afterBoard.AfterBoardVO;

public interface GetAfterBoardListService {

	
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title(String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_writer(String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title_content(String keyword) throws Exception;

	public Integer countAfterBoardList() throws Exception;
	
}
