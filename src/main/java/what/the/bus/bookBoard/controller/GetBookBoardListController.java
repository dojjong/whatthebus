package what.the.bus.bookBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import what.the.bus.bookBoard.BookBoardVO;
import what.the.bus.bookBoard.ClusterVO;
import what.the.bus.bookBoard.ClusterVO2;
import what.the.bus.bookBoard.service.GetBookBoardListService;
import what.the.bus.bookcomment.BookCommentVO;
import what.the.bus.pagination.Pagination;
import what.the.bus.suggestBoard.SuggestBoardVO;

@Controller
public class GetBookBoardListController {
	@Autowired
	private GetBookBoardListService bookBoardService;

	@RequestMapping("/view/**/getBookBoardList.do")
	public String getBookBoardList(SuggestBoardVO suggestVO, BookCommentVO commentVO, Model model,
			@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "all") String searchOption) {
		// boardService.getListCount();
		suggestVO.setSearchOption(searchOption);
		suggestVO.setKeyword(keyword);

		// 전체리스트 개수
		int listCnt = 0;
		if (searchOption.equals("comment")) {
			listCnt = bookBoardService.getBoardCommentContentListCount(commentVO);
		} else if (searchOption.equals("cname")) {
			listCnt = bookBoardService.getBoardCommentNameListCount(commentVO);
		} else {
			listCnt = bookBoardService.getBookBoardListCount(suggestVO);
		}

		Pagination pagination = new Pagination(listCnt, curPage);

		int start = pagination.getPageBegin();
		int end = pagination.getPageEnd();

		List<SuggestBoardVO> list = bookBoardService.getBookBoardList(start, end, searchOption, keyword);
		List<Integer> commentCountList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int seq = list.get(i).getSeq();
			int commentCount = bookBoardService.getCommentCount(seq);
			commentCountList.add(i, commentCount);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("commentCount", commentCountList);
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("count", listCnt);
		map.put("pagination", pagination);
		model.addAttribute("map", map);
		return "bookBoard/list";
	}
	
	@RequestMapping("/view/**/getClusterDate.do")
	@ResponseBody
	public ClusterVO2 getClusterDate(BookBoardVO vo, String sort) {
		//System.out.println("컨트롤러 들어옴 sort="+sort);
		List<SuggestBoardVO> imsiList = bookBoardService.cluster();
		List<ClusterVO> list2 = new ArrayList<ClusterVO>();
		//System.out.println("sort=" + sort);
		if (sort.equals("1")) {
			// 출발지
			System.out.println("출발지 갯수 컨트롤러");
			for (int i = 0; i < imsiList.size(); i++) {
				String imsiLat = imsiList.get(i).getStart_wido().trim();
				String imsiLng = imsiList.get(i).getStart_kyungdo().trim();
				Double lat = Double.parseDouble(imsiLat);
				Double lng = Double.parseDouble(imsiLng);

				ClusterVO clusterVO = new ClusterVO(lat, lng);
				list2.add(clusterVO);
				//System.out.println("출발지 갯수 = " + list2.size());
			}
			for(int m=0;m<list2.size();m++) {
				//System.out.println(m+"번째 : "+list2.get(m).getLat()+" : "+list2.get(m).getLng());
			}

		} else if (sort.equals("2")) {
			// 경유지
			//System.out.println("경유지 갯수 컨트롤러");
			for (int i = 0; i < imsiList.size(); i++) {
				if (imsiList.get(i).getMid_wido()==null||imsiList.get(i).getMid_wido().equals("")) {
					//System.out.println("널인경우:"+i);
					continue;
				}
				String imsiLat = imsiList.get(i).getMid_wido().trim();
				//System.out.println(imsiLat);
				String imsiLng = imsiList.get(i).getMid_kyungdo().trim();
				//System.out.println(imsiLng);
				String[] splitLat = imsiLat.split("/");
				String[] splitLng = imsiLng.split("/");
				Double[] lat = new Double[splitLat.length];
				Double[] lng = new Double[splitLng.length];
				for (int k = 1; k < splitLat.length; k++) {
					//System.out.println("splitLat.length=" + splitLat.length);
					//System.out.println(i + "번째:" + k + "찍기 : " + splitLat[k] + "/" + splitLng[k]);
					lat[k] = Double.parseDouble(splitLat[k]);
					lng[k] = Double.parseDouble(splitLng[k]);
					ClusterVO clusterVO = new ClusterVO(lat[k], lng[k]);
					list2.add(clusterVO);
					//System.out.println("경유지 갯수 = " + list2.size());
				}
			}
			
			for(int m=0;m<list2.size();m++) {
				//System.out.println(m+"번째 : "+list2.get(m).getLat()+" : "+list2.get(m).getLng());
			}
			
				
		} else if (sort.equals("3")) {
			// 도착지
			//System.out.println("도착지 갯수 컨트롤러");
			for (int i = 0; i < imsiList.size(); i++) {
				String imsiLat = imsiList.get(i).getEnd_wido().trim();
				String imsiLng = imsiList.get(i).getEnd_kyungdo().trim();
				Double lat = Double.parseDouble(imsiLat);
				Double lng = Double.parseDouble(imsiLng);
		
				ClusterVO clusterVO = new ClusterVO(lat, lng);
				list2.add(clusterVO);
				//System.out.println("도착지 갯수 = " + list2.size());
			}
			for(int m=0;m<list2.size();m++) {
				//System.out.println(m+"번째 : "+list2.get(m).getLat()+" : "+list2.get(m).getLng());
			}

		} else if (sort.equals("5")) {
			// 전체
				System.out.println("전체 갯수 컨트롤러");
				for (int i = 0; i < imsiList.size(); i++) {
					//출발지
					String s_imsiLat = imsiList.get(i).getStart_wido().trim();
					String s_imsiLng = imsiList.get(i).getStart_kyungdo().trim();
					Double s_lat = Double.parseDouble(s_imsiLat);
					Double s_lng = Double.parseDouble(s_imsiLng);
					ClusterVO s_clusterVO = new ClusterVO(s_lat, s_lng);
					list2.add(s_clusterVO);
					
					//도착지
					String e_imsiLat = imsiList.get(i).getEnd_wido().trim();
					String e_imsiLng = imsiList.get(i).getEnd_kyungdo().trim();
					Double e_lat = Double.parseDouble(e_imsiLat);
					Double e_lng = Double.parseDouble(e_imsiLng);
					ClusterVO e_clusterVO = new ClusterVO(e_lat, e_lng);
					list2.add(e_clusterVO);
					
					//경유지
					if (imsiList.get(i).getMid_wido()==null||imsiList.get(i).getMid_wido().equals("")) {
						//System.out.println("널인경우:"+i);
						continue;
					}
					String m_imsiLat = imsiList.get(i).getMid_wido().trim();
					//System.out.println(imsiLat);
					String m_imsiLng = imsiList.get(i).getMid_kyungdo().trim();
					//System.out.println(imsiLng);
					String[] m_splitLat = m_imsiLat.split("/");
					String[] m_splitLng = m_imsiLng.split("/");
					Double[] m_lat = new Double[m_splitLat.length];
					Double[] m_lng = new Double[m_splitLng.length];
					for (int k = 1; k < m_splitLat.length; k++) {
						//System.out.println("splitLat.length=" + splitLat.length);
						//System.out.println(i + "번째:" + k + "찍기 : " + splitLat[k] + "/" + splitLng[k]);
						m_lat[k] = Double.parseDouble(m_splitLat[k]);
						m_lng[k] = Double.parseDouble(m_splitLng[k]);
						ClusterVO m_clusterVO = new ClusterVO(m_lat[k], m_lng[k]);
						list2.add(m_clusterVO);
						//System.out.println("경유지 갯수 = " + list2.size());
					}					
				}
				System.out.println("all 갯수 = " + list2.size());
		} 
		// List<ClusterVO2> list = new ArrayList<ClusterVO2>();
		// list.add(new ClusterVO2(list2));
		ClusterVO2 list = new ClusterVO2(list2);
		System.out.println("최종 리스트2갯수 = "+list2.size());
		System.out.println("최종 리스트갯수 = "+list.getPositions().size());
		return list;
	}
}