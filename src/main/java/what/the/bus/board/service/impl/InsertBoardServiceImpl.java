package what.the.bus.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.board.dao.BoardDAO;
import what.the.bus.board.service.InsertBoardService;
@Service
public class InsertBoardServiceImpl implements InsertBoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

}
