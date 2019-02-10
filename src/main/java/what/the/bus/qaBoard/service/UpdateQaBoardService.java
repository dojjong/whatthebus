package what.the.bus.qaBoard.service;

import what.the.bus.qaBoard.QaBoardVO;

public interface UpdateQaBoardService {
	QaBoardVO getQaBoard(int seq);
	void updateQaBoard(QaBoardVO vo);

}
