package what.the.bus.qaBoard.service;

import what.the.bus.qaBoard.QaBoardVO;

public interface DeleteQaBoardService {
	void deleteQaBoard(QaBoardVO vo);
	QaBoardVO getQaBoard(int seq);
}
