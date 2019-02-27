package what.the.bus.review.service;

import java.util.List;

import what.the.bus.review.ReviewVO;

public interface GetReviewListService {
	List<ReviewVO> getAllReviewList(int start, int end);

	int getAllReviewListCount();

	int getReviewCount(ReviewVO vo);
}