package what.the.bus.qaBoard.service;

import java.util.List;

import what.the.bus.qaBoard.QaBoardVO;

public interface GetQaBoardListService {
	
List<QaBoardVO> getQaBoardList();

Integer getQaBoardListCount(QaBoardVO vo);


}
