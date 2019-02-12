package what.the.bus.afterBoard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.impl.AfterBoardDAOImpl;
import what.the.bus.afterBoard.service.GetAfterBoardListService;

@Service
public class GetAfterBoardListServiceImpl implements GetAfterBoardListService{
	
	@Autowired
	AfterBoardDAOImpl afterBoardDAO;

	@Override
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception {
		return afterBoardDAO.getAfterBoardList(start, end);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title(String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_title(keyword);
	}
	
	@Override
	public List<AfterBoardVO> getAfterBoardList_writer(String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_writer(keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title_content(String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_title_content(keyword);
	}

	@Override
	public Integer countAfterBoardList() throws Exception {
		return afterBoardDAO.countAfterBoardList();
	}
}
