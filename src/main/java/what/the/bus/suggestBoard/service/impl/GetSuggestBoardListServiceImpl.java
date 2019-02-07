package what.the.bus.suggestBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.suggestBoard.SuggestBoardVO;
import what.the.bus.suggestBoard.dao.impl.SuggestBoardDAOImpl;
import what.the.bus.suggestBoard.service.GetSuggestBoardListService;

@Service
public class GetSuggestBoardListServiceImpl implements GetSuggestBoardListService {
	@Autowired
	private SuggestBoardDAOImpl suggestBoardDAO;


	@Override
	public List<SuggestBoardVO> getSuggestBoardList() {
		return suggestBoardDAO.getSuggestBoardList();
	}

	@Override
	public Integer getSuggestBoardListCount() {
		return suggestBoardDAO.getSuggestBoardListCount();
	}


}