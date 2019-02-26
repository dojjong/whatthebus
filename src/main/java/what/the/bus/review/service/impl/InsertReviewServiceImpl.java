package what.the.bus.review.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.review.ReviewVO;
import what.the.bus.review.dao.ReviewDAO;
import what.the.bus.review.service.InsertReviewService;

@Service
public class InsertReviewServiceImpl implements InsertReviewService {
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public void inserReview(ReviewVO vo) {
		reviewDAO.insertReview(vo);
	}

}
