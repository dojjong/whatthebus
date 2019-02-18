package what.the.bus.lostComment.controller;

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

import what.the.bus.lostComment.LostCommentVO;
import what.the.bus.lostComment.service.InsertLostCommentService;

@Controller
public class InsertLostCommentController {
	
	@Autowired
	private InsertLostCommentService lostCommentService;
	
	@RequestMapping("/view/**/insertLostComment.do")
	@ResponseBody
	public String insertLostComment(LostCommentVO lostCommentvo) {
		lostCommentService.insertLostComment(lostCommentvo);
		return "success";
	}
	
	@RequestMapping(value = "/view/**/lostCommentList.do", produces = "application/json; charset=UTF-8" )
	@ResponseBody
	public ResponseEntity getLostCommentList(LostCommentVO vo, HttpServletRequest request) throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		List<LostCommentVO> lostCommentVO  = (List<LostCommentVO>) lostCommentService.getLostCommentList(vo);
		
		
		if(lostCommentVO.size() > 0) {
			for(int i =0; i< lostCommentVO.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cid", lostCommentVO.get(i).getId());
				hm.put("cno", lostCommentVO.get(i).getCno());
				hm.put("content", lostCommentVO.get(i).getContent());
				hm.put("name", lostCommentVO.get(i).getName());
				hm.put("regdate", lostCommentVO.get(i).getRealregdate());
				hmlist.add(hm);
				
			}
		}
		
		JSONArray json = new JSONArray(hmlist);
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
		
		
		
		
		
	}
	
}
