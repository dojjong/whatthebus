package what.the.bus.eventComment.controller;

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

import what.the.bus.eventComment.EventCommentVO;
import what.the.bus.eventComment.service.InsertEventCommentService;


@Controller
public class InsertEventCommentController {

	@Autowired
	private InsertEventCommentService eventcommentService;
	
	@RequestMapping("/view/**/insertEventComment.do")
	@ResponseBody
	public String insertEventComment(EventCommentVO eventCommentvo) {
		eventcommentService.insertEventComment(eventCommentvo);
		return "success";
	}
	
	@RequestMapping(value = "/view/**/eventCommentList.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity getEventCommentList(EventCommentVO vo, HttpServletRequest request) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		List<EventCommentVO> eventCommnetVO = (List<EventCommentVO>) eventcommentService.getEventCommentList(vo);
		
		if(eventCommnetVO.size() > 0) {
			for(int i = 0; i < eventCommnetVO.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cid", eventCommnetVO.get(i).getId());
				hm.put("cno", eventCommnetVO.get(i).getCno());
				hm.put("content", eventCommnetVO.get(i).getContent());
				hm.put("name", eventCommnetVO.get(i).getName());
				hm.put("regdate", eventCommnetVO.get(i).getRealregdate());
				hmlist.add(hm);
				
			}
		}
		JSONArray json = new JSONArray(hmlist);
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}
}
