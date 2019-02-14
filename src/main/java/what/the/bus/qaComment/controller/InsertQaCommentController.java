package what.the.bus.qaComment.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.qaComment.QaCommentVO;
import what.the.bus.qaComment.service.InsertQaCommentService;

@Controller
public class InsertQaCommentController {
	@Autowired
	private InsertQaCommentService qaCommentService;
	
	@RequestMapping("/view/**/insertQaComment.do")
	@ResponseBody
	public String insertQaComment(QaCommentVO qaCommentvo) {
		qaCommentService.insertQaComment(qaCommentvo);
		return "success";
	}
	
	@RequestMapping(value = "/view/**/qaCommentList.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity getQaCommentList(QaCommentVO vo, HttpServletRequest request) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		List<QaCommentVO> qaCommnetVO = (List<QaCommentVO>) qaCommentService.getQaCommentList(vo);
		
		if(qaCommnetVO.size() > 0) {
			for(int i = 0; i < qaCommnetVO.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cid", qaCommnetVO.get(i).getId());
				hm.put("cno", qaCommnetVO.get(i).getCno());
				hm.put("content", qaCommnetVO.get(i).getContent());
				hm.put("name", qaCommnetVO.get(i).getName());
				hm.put("regdate", qaCommnetVO.get(i).getRealregdate());
				hmlist.add(hm);
				
			}
		}
		JSONArray json = new JSONArray(hmlist);
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
}
