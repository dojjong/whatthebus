package what.the.bus.afterBoard.service;

import javax.servlet.http.HttpSession;

import what.the.bus.afterBoard.AfterBoardVO;

public interface GetAfterBoardService {
	public void increaseViewCnt(int seq, HttpSession session) throws Exception;
	public AfterBoardVO getAfterBoard(int seq) throws Exception;
}
