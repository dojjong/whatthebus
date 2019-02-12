package what.the.bus.afterBoard.service;

import what.the.bus.afterBoard.AfterBoardVO;

public interface UpdateAfterBoardService {

	public void updateAfterBoard(AfterBoardVO vo) throws Exception;
	public AfterBoardVO getAfterBoard(int seq) throws Exception;
}
