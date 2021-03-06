package what.the.bus.afterBoard.service.imsi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.AfterBoardDAO;
import what.the.bus.afterBoard.service.GetAfterBoardListService;

@Service
public class GetAfterBoardListServiceImsi implements GetAfterBoardListService {

	@Autowired
	AfterBoardDAO afterBoardDAO;

	@Override
	public List<AfterBoardVO> getAfterBoardList(int start, int end) throws Exception {
		return afterBoardDAO.getAfterBoardList(start, end);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title(int start, int end, String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_title(start, end, keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_writer(int start, int end, String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_writer(start, end, keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardList_title_content(int start, int end, String keyword) throws Exception {
		return afterBoardDAO.getAfterBoardList_title_content(start, end, keyword);
	}

	@Override
	public Integer countAfterBoardList() throws Exception {
		return afterBoardDAO.countAfterBoardList();
	}

	@Override
	public Integer countAfterBoardList_title(String keyword) throws Exception {
		return afterBoardDAO.countAfterBoardList_title(keyword);
	}

	@Override
	public Integer countAfterBoardList_writer(String keyword) throws Exception {
		return afterBoardDAO.countAfterBoardList_writer(keyword);
	}

	@Override
	public Integer countAfterBoardList_title_content(String keyword) throws Exception {
		return afterBoardDAO.countAfterBoardList_title_content(keyword);
	}

	@Override
	public List<AfterBoardVO> getAfterBoardListAll() throws Exception {

		return afterBoardDAO.getAfterBoardListAll();
	}
}
