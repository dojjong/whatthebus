package what.the.bus.afterBoard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.dao.impl.AfterBoardDAOImpl;
import what.the.bus.afterBoard.service.InsertAfterBoardService;

@Service
public class InsertAfterBoardServiceImpl implements InsertAfterBoardService {
	
	@Autowired
	AfterBoardDAOImpl afterBoardDAO;

	@Override
	public void insertAfterBoard(AfterBoardVO vo) throws Exception {
		String title = vo.getTitle();
		String content = vo.getContent();
		String id = vo.getId();
		//* 태그 문자 처리 (< ==> &lt; > ==> &gt);
		//replace(A,B) A를 B로 변경
		title = title.replace("<", "&lt;");
		title = title.replace("<", "&gt;");
		id = id.replace("<", "&lt");
		id = id.replace("<", "&gt;");
		//공백문자처리
		title = title.replace("  ", "&nbsp;&nbsp;");
		id = id.replace("  ", "&nbsp;&nbsp;");
		//줄바꿈 문자처리
		content = content.replace("\n", "<br>");
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		afterBoardDAO.insertAfterBoard(vo);
	}
}
