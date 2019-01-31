package what.the.bus.best.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.best.BestVO;
import what.the.bus.best.service.BestService;
import what.the.bus.board.BoardVO;

@Controller
public class BestController {
	@Autowired
	private BestService bestService;

	@ResponseBody
	@RequestMapping(value = "/view/**/bestClick.do", produces = "text/plain;charset=UTF-8")
	public String best(int seq, String id, BoardVO boardVO, BestVO bestVO) {

		JSONObject obj = new JSONObject();
		ArrayList<String> msgs = new ArrayList<String>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("seq", seq);
		hashMap.put("id", id);
		bestVO.setId(id);
		bestVO.setSeq(seq);
		bestVO = bestService.getBest(bestVO);
		
		int best_cnt = bestService.getBoardBest(seq);
		int best_check = 0;
		best_check = bestVO.getBestCheck();
		if (best_check == 0) {
			msgs.add("추천하셨습니다.");
			bestService.best_check(bestVO);
			best_check++;
			best_cnt++;
			bestService.boardOnBestUpdate(bestVO);
		} else {
			msgs.add("추천을 취소하셨습니다.");
			bestService.best_cancel(bestVO);
			best_check--;
			best_cnt--;
			bestService.boardOffBestUpdate(bestVO);
		}
		obj.put("seq", bestVO.getSeq());
		obj.put("best_check", best_check);
		obj.put("best_cnt", best_cnt);
		obj.put("msg", msgs);
		return obj.toString();

	}

}
