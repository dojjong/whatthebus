package what.the.bus.afterBoard.service.imsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.imsi.AfterBoardDAOImsi;
import what.the.bus.afterBoard.service.UpdateAfterBoardService;

@Service
public class UpdateAfterBoardServiceImsi implements UpdateAfterBoardService{
	@Autowired
	AfterBoardDAOImsi afterBoardDAO;

	@Override
	public void updateAfterBoard(AfterBoardVO vo) throws Exception {
		afterBoardDAO.updateAfterBoard(vo);
	}

	@Override
	public AfterBoardVO getAfterBoard(int seq) throws Exception {
		return afterBoardDAO.getAfterBoard(seq);
	}

	
}
