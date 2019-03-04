package what.the.bus.afterBoard.service.imsi;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.AfterBoardDAO;
import what.the.bus.afterBoard.service.GetAfterBoardService;

@Service
public class GetAfterBoardServiceImsi implements GetAfterBoardService {

	@Autowired
	AfterBoardDAO afterBoardDAO;

	@Override
	public AfterBoardVO getAfterBoard(int seq) throws Exception {
		return afterBoardDAO.getAfterBoard(seq);
	}

	@Override
	public void increaseViewCnt(int seq, HttpSession session) throws Exception {
		long update_time = 0;
		// 세션에 저장된 조회시간 검색
		// 최초로 조회할 경우 세션에 저장된 값이 없기 때문에 if문은 실행x
		if (session.getAttribute("update_time_" + seq) != null) {
			// 세션에서 읽어오기
			update_time = (long) session.getAttribute("update_time_" + seq);
		}

		// 시스템의 현재시간을 current_time에 저장
		long current_time = System.currentTimeMillis();
		// 일정 시간이 경과 한 후 조회수 증가 처리 24*60*60*1000(24시간)
		// 시스템 현재시간 - 열람시간 > 일정시간(조회수 증가가 가능하도록 지정한 시간)
		if (current_time - update_time > 5 * 1000) {
			afterBoardDAO.increaseViewCnt(seq);
			// 세션에 시간을 저장 : "update_time_"+seq는 다른 변수와 중복되지 않게 명명한 것
			session.setAttribute("update_time_" + seq, current_time);
		}

	}

}
