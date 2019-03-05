package what.the.bus.review.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import what.the.bus.admin.ChartVO3;
import what.the.bus.admin.ReportVO1;
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
	public List<ReviewVO> getAllReviewList(int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		return mybatis.selectList("ReviewDAO.getAllReviewList", map);
	}

	@Override
	public int getAllReviewListCount() {
		return mybatis.selectOne("ReviewDAO.getAllReviewListCount");
	}

	@Override
	public int getReviewCount(ReviewVO vo) {
		return mybatis.selectOne("ReviewDAO.getReviewCount", vo);
	}
	
	@Override
	public List<ChartVO3> getAvgStarPerDriver() {
		return mybatis.selectList("ReviewDAO.getAvgStarPerDriver");
	}

	@Override
	public List<ReportVO1> getReviewListPerDriver() {
		return mybatis.selectList("ReviewDAO.getReviewListPerDriver");
	}

}
