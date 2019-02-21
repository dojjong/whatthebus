package what.the.bus.afterBoard.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import what.the.bus.afterBoard.AfterBoardVO;

public interface GetAfterBoardListService {

	
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title(int start, int end, String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_writer(int start, int end, String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title_content(int start, int end, String keyword) throws Exception;

	public Integer countAfterBoardList() throws Exception;
	public Integer countAfterBoardList_title(String keyword) throws Exception;
	public Integer countAfterBoardList_writer(String keyword) throws Exception;
	public Integer countAfterBoardList_title_content(String keyword) throws Exception;
	
	public List<AfterBoardVO> getAfterBoardListAll() throws Exception;
}
