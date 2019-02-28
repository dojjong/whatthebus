package what.the.bus.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.board.BoardVO;
import what.the.bus.main.dao.MainDAO;
import what.the.bus.main.service.MainListService;
import what.the.bus.noticeBoard.NoticeBoardVO;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Service
public class MainListServiceImpl implements MainListService {
	@Autowired
	private MainDAO mainDAO;

	@Override
	public List<BoardVO> hotList(int maincount) {
		return mainDAO.hotList(maincount);
	}

	@Override
	public List<BoardVO> recentList(int maincount) {
		return mainDAO.recentList(maincount);
	}

	@Override
	public List<SuggestBoardVO> finishTimeList(int maincount) {
		return mainDAO.finishTimeList(maincount);
	}

	@Override
	public List<NoticeBoardVO> noticeList(int maincount) {
		return mainDAO.noticeList(maincount);
	}

	@Override
	public int getMainCount() {
		return mainDAO.getMainCount();
	}

}
