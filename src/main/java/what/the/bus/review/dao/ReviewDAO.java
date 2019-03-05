package what.the.bus.review.dao;

import java.util.List;

import what.the.bus.admin.ChartVO3;
import what.the.bus.admin.ReportVO1;
import what.the.bus.review.ReviewVO;

public interface ReviewDAO {
	void insertReview(ReviewVO vo);

	List<ReviewVO> getAllReviewList(int start,int end);

	int getAllReviewListCount();
	
	int getReviewCount(ReviewVO vo);
	
	List<ChartVO3> getAvgStarPerDriver();
	
	List<ReportVO1> getReviewListPerDriver();
}
