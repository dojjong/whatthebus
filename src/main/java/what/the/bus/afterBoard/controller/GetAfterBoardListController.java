package what.the.bus.afterBoard.controller;

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
		System.out.println("count="+count);
		
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
	public String getAfterBoardList_title(@RequestParam String keyword2, Model model) throws Exception {
		System.out.println("keyword2="+keyword2);
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_title(keyword2);
		model.addAttribute("count", list.size());
		model.addAttribute("list", list);
		return "afterBoard/list";
	}
	
	@RequestMapping("/view/**/getAfterBoardList_writer.do")
	public String getAfterBoardList_writer(@RequestParam String keyword2, Model model) throws Exception {
		System.out.println(keyword2);
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_writer(keyword2);
		model.addAttribute("count", list.size());
		model.addAttribute("list", list);
		return "afterBoard/list";
	}
	
	@RequestMapping("/view/**/getAfterBoardList_title_content.do")
	public String getAfterBoardList_title_content(@RequestParam String keyword2, Model model) throws Exception {
		System.out.println(keyword2);
		List<AfterBoardVO> list = afterBoardService.getAfterBoardList_title_content(keyword2);
		model.addAttribute("count", list.size());
		model.addAttribute("list", list);
		return "afterBoard/list";
	}
}
