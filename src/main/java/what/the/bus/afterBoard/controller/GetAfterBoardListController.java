package what.the.bus.afterBoard.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import what.the.bus.afterBoard.AfterBoardVO;
import what.the.bus.afterBoard.BoardPager;
import what.the.bus.afterBoard.service.GetAfterBoardListService;

@Controller
public class GetAfterBoardListController {
	
	@Autowired
	private GetAfterBoardListService afterBoardService;

	@RequestMapping("/view/**/getAfterBoardList.do")
	public String getAfterBoardList(@RequestParam(defaultValue="1") int curPage, Model model) throws Exception {
		// 레코드의 갯수 계산
		int count = afterBoardService.countAfterBoardList();//페이징 처리 없이 list 갯수 파악 count용
		
		
		//페이지 나누기 관련 처리
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList(start,end);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("boardPager", boardPager);
		model.addAttribute("map", map);
		return "afterBoard/list";
	}
	
	@RequestMapping("/view/**/getAfterBoardList_title.do")
	public String getAfterBoardList_title(@RequestParam String keyword2, @RequestParam(defaultValue="1") int curPage, Model model) throws Exception {
		// 레코드의 갯수 계산
		int count = afterBoardService.countAfterBoardList_title(keyword2);//페이징 처리 없이 list 갯수 파악 count용

		//페이지 나누기 관련 처리
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		System.out.println("start="+start);
		System.out.println("end="+end);
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_title(start,end,keyword2);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("boardPager", boardPager);
		map.put("keyword", keyword2);
		map.put("searchCondition", "제목만");
		model.addAttribute("map", map);
		return "afterBoard/list";
	}
	
	@RequestMapping("/view/**/getAfterBoardList_writer.do")
	public String getAfterBoardList_writer(@RequestParam String keyword2, @RequestParam(defaultValue="1") int curPage, Model model) throws Exception {
		
		// 레코드의 갯수 계산
		int count = afterBoardService.countAfterBoardList_writer(keyword2);//페이징 처리 없이 list 갯수 파악 count용

		//페이지 나누기 관련 처리
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_writer(start,end,keyword2);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("boardPager", boardPager);
		map.put("keyword", keyword2);
		map.put("searchCondition", "글작성자");
		model.addAttribute("map", map);
		return "afterBoard/list";
	}
	
	@RequestMapping("/view/**/getAfterBoardList_title_content.do")
	public String getAfterBoardList_title_content(@RequestParam String keyword2, @RequestParam(defaultValue="1") int curPage, Model model) throws Exception {
			
		// 레코드의 갯수 계산
		int count = afterBoardService.countAfterBoardList_title_content(keyword2);//페이징 처리 없이 list 갯수 파악 count용

		//페이지 나누기 관련 처리
		
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		System.out.println("start="+start+", end="+end);
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_title_content(start,end,keyword2);
		
		//데이터를 맵에 저장
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("boardPager", boardPager);
		map.put("keyword", keyword2);
		map.put("searchCondition", "제목만");
		model.addAttribute("map", map);
		return "afterBoard/list";
	}
	
	
}
