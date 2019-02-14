package what.the.bus.afterBoard.dao;

import java.util.List;

import what.the.bus.afterBoard.AfterBoardVO;

public interface AfterBoardDAO {

	public void insertAfterBoard(AfterBoardVO vo) throws Exception;
	public AfterBoardVO getAfterBoard(int seq) throws Exception;
	public void updateAfterBoard(AfterBoardVO vo) throws Exception;
	public void deleteAfterBoard(int seq) throws Exception;
	
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title(int start, int end, String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_writer(int start, int end, String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title_content(int start, int end, String keyword) throws Exception;
	
	public Integer countAfterBoardList() throws Exception;
	public Integer countAfterBoardList_title(String keyword) throws Exception;
	public Integer countAfterBoardList_writer(String keyword) throws Exception;
	public Integer countAfterBoardList_title_content(String keyword) throws Exception;

	public void increaseViewCnt(int seq) throws Exception;
	
}
