package what.the.bus.afterBoard.dao;

import java.util.List;

import what.the.bus.afterBoard.AfterBoardVO;

public interface AfterBoardDAO {

	public void insertAfterBoard(AfterBoardVO vo) throws Exception;
	public AfterBoardVO getAfterBoard(int seq) throws Exception;
	public void updateAfterBoard(AfterBoardVO vo) throws Exception;
	public void deleteAfterBoard(int seq) throws Exception;
	
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title(String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_writer(String keyword) throws Exception;
	public List<AfterBoardVO> getAfterBoardList_title_content(String keyword) throws Exception;
	
	public Integer countAfterBoardList() throws Exception;

	public void increaseViewCnt(int seq) throws Exception;
	
}
