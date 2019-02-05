package what.the.bus.comment.controller;

import java.sql.Date;
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

import what.the.bus.comment.CommentVO;
import what.the.bus.comment.service.InsertCommentService;

@Controller
public class InsertCommentController {
	@Autowired
	private InsertCommentService commentService;

	// 디비에 댓글 등록
	// @RequestMapping("/view/**/insertComment.do")
	// public void insertComment(CommentVO vo) {
	// commentService.insertComment(vo);
	// }

//ajax로 디비에 댓글등록
	@RequestMapping("/view/**/insertComment.do")
	@ResponseBody
	public String insertComment(CommentVO commentvo) {
		commentService.insertComment(commentvo);
		return "success";
	}

	@RequestMapping(value = "/view/**/commentList.do", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ResponseEntity getCommentList(CommentVO vo, HttpServletRequest request) throws Exception {
		HttpHeaders responseHeaders = new HttpHeaders();
		ArrayList<HashMap> hmlist = new ArrayList<HashMap>();

		List<CommentVO> commentVO = (List<CommentVO>) commentService.getCommentList(vo);

		if (commentVO.size() > 0) {
			for (int i = 0; i < commentVO.size(); i++) {
				HashMap hm = new HashMap();
				hm.put("cid", commentVO.get(i).getId());
				hm.put("cno", commentVO.get(i).getCno());
				hm.put("content", commentVO.get(i).getContent());
				hm.put("name", commentVO.get(i).getName());
				hm.put("regdate", commentVO.get(i).getRealregdate());
			
				hmlist.add(hm);
			}
		}

		JSONArray json = new JSONArray(hmlist);
		return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
	}

}
