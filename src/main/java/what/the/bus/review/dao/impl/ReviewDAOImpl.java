package what.the.bus.review.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.review.ReviewVO;
import what.the.bus.review.dao.ReviewDAO;
import what.the.bus.util.SqlSessionFactoryBean;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	private SqlSession mybatis;

	public ReviewDAOImpl() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}

	@Override
	public void insertReview(ReviewVO vo) {
		mybatis.insert("ReviewDAO.insertReview", vo);
	}

	@Override
	public List<ReviewVO> getAllReviewList() {
		return mybatis.selectList("ReviewDAO.getAllReviewList");
	}

}
