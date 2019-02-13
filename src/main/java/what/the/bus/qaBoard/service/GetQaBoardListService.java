package what.the.bus.qaBoard.service;

import java.util.List;

import what.the.bus.qaBoard.QaBoardVO;
import what.the.bus.qaComment.QaCommentVO;

public interface GetQaBoardListService {
	
List<QaBoardVO> getQaBoardList(int start, int end, String searchOption, String keyword);

Integer getQaBoardListCount(QaBoardVO vo);

Integer getQaBoardCommentContentListCount(QaCommentVO vo);

Integer getQaBoardCommentNameListCount(QaCommentVO vo);

Integer getQaCommentCount(int seq);




}
