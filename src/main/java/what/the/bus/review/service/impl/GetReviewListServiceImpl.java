package what.the.bus.review.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import what.the.bus.review.ReviewVO;
import what.the.bus.review.dao.ReviewDAO;
import what.the.bus.review.service.GetReviewListService;

@Service
public class GetReviewListServiceImpl implements GetReviewListService {
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public List<ReviewVO> getAllReviewList() {
		return reviewDAO.getAllReviewList();
	}

}
