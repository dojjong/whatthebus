package what.the.bus.afterBoard.service.imsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.dao.AfterBoardDAO;
import what.the.bus.afterBoard.service.DeleteAfterBoardService;

@Service
public class DeleteAfterBoardServiceImsi implements DeleteAfterBoardService {

	@Autowired
	AfterBoardDAO afterBoardDAO;

	@Override
	public void deleteAfterBoard(int seq) throws Exception {
		afterBoardDAO.deleteAfterBoard(seq);

	}

}
