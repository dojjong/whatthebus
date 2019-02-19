package what.the.bus.noticeComment.controller;

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

import what.the.bus.noticeComment.NoticeCommentVO;
import what.the.bus.noticeComment.service.InsertNoticeCommentService;

@Controller
public class InsertNoticeCommentController {

	@Autowired
	private InsertNoticeCommentService noticeCommentService;
	
	@RequestMapping("/view/**/insertNoticeComment.do")
	@ResponseBody
	public String insertNoticeComment(NoticeCommentVO noticeCommentvo) {
		noticeCommentService.insertNoticeComment(noticeCommentvo);
		return "success";
	}
	
	@RequestMapping(value = "/view/**/noticeCommentList.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity getNoticeCommentList(NoticeCommentVO vo, HttpServletRequest request) throws Exception{
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
		
		List<NoticeCommentVO> noticeCommentVO = (List<NoticeCommentVO>) noticeCommentService.getNoticeCommentList(vo);
		
		if(noticeCommentVO.size() > 0 ) {
			for(int i = 0; i < noticeCommentVO.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cid", noticeCommentVO.get(i).getId());
				hm.put("cno", noticeCommentVO.get(i).getCno());
				hm.put("content", noticeCommentVO.get(i).getContent());
				hm.put("name", noticeCommentVO.get(i).getName());
				hm.put("regdate", noticeCommentVO.get(i).getRealregdate());
				
				hmlist.add(hm);
			}
		}
		
		JSONArray json = new JSONArray(hmlist);
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
		
		
	}
}
