package what.the.bus.review.dao;

import java.util.List;

import what.the.bus.review.ReviewVO;

public interface ReviewDAO {
	void insertReview(ReviewVO vo);

	List<ReviewVO> getAllReviewList();
}
