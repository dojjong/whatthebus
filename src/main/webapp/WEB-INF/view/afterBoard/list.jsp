<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../resources/css/boardStyle.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$("#searchBt").click(function() {
		if(document.searchForm.searchCondition.value=="제목만"){
			alert(document.searchForm.keyword.value);
			document.searchForm.action="getAfterBoardList_title.do?keyword2="+document.searchForm.keyword.value;
			alert(document.searchForm.action);
			document.searchForm.submit();
		}else if(document.searchForm.searchCondition.value=="글작성자"){
			alert(document.searchForm.keyword.value);
			document.searchForm.action="getAfterBoardList_writer.do?keyword2="+document.searchForm.keyword.value;
			alert(document.searchForm.action);
			document.searchForm.submit();
		}else if(document.searchForm.searchCondition.value=="제목+내용"){
			alert(document.searchForm.keyword.value);
			document.searchForm.action="getAfterBoardList_title_content.do?keyword2="+document.searchForm.keyword.value;
			alert(document.searchForm.action);
			document.searchForm.submit();
		}else{
			document.searchForm.action="getAfterBoardList.do";
			alert(document.searchForm.action);
			document.searchForm.submit();
		}
	});	
	
	//**원하는 페이지로 이동시 검색조건, 키워드 값을 유지하기 위해
	/*
	function list(page){
		alert()
		location.href="getAfterBoardList.do?curPage="+page;
	}
	*/
		
});
</script>
</head>
<body>

	<!-- 화면 센터 -->
	<div align="center">
		<b>글목록(전체 글 : ${map.count })</b>
		<table border="1" width="700" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" id="boardhead">
				<td align="center" width="55">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="100">조회</td>
				<td align="center" width="50">추천</td>
			</tr>
			<%---- 글이 없을 경우 -->
			<c:if test="${count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if> --%>

			<c:forEach var="vo" items="${map.list }">
				<tr height="30">
					<td align="center" width="50">${vo.seq }</td>
					<td width="250"><a href="getAfterBoard.do?seq=${vo.seq}">${vo.title }</a></td>
					<td align="center" width="100">${vo.name }</td>
					<td align="center" width="150">${vo.regDate }</td>
					<td align="center" width="50">${vo.cnt }</td>
					<td align="center" width="50">${vo.best }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">
					<!-- 처음 페이지로 이동: 현재페이지가 1보다 크면 [처음]하이퍼링크를 화면에 출력 -->
					<c:if test="${map.boardPager.curPage>1 }">
						<!-- <a href="javascript:list('1')">[처음]</a> -->
						<a href="getAfterBoardList.do?curPage=1">[처음]</a>
					</c:if>
					
					<!-- 이전페이지 블록으로 이동:현재 페이지 블록이 1보다 크면 [이전]하이퍼링크를 화면에 출력 -->
					<c:if test="${map.boardPager.curBlock>1 }">
						<!-- <a href="javascript:list('${map.boardPager.prevPage }')">[이전]</a> -->
						<a href="getAfterBoardList.do?curPage=${map.boardPager.prevPage }">[이전]</a> 
					</c:if>
					
					<!-- 하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
					<c:forEach var="seq" begin="${map.boardPager.blockBegin }" end="${map.boardPager.blockEnd }">
						<!-- 현재페이지면 하이퍼링크 제거 -->
						<c:choose>
							<c:when test="${seq==map.boardPager.curPage }">
								<span style="color: red">${seq}</span>&nbsp;
							</c:when>
							<c:otherwise>
								<!-- <a href="javascript:list('${seq }')">${seq }</a>&nbsp;-->
								<a href="getAfterBoardList.do?curPage=${seq }">${seq }</a> 
							</c:otherwise>
						</c:choose>
					</c:forEach>
					
					<!-- 다음페이지 블록으로 이동:현재 페이지 블록이 전체 페이지블록 갯수보다 작거나 같으면 [다음]하이퍼링크를 화면에 출력 -->
					<c:if test="${map.boardPager.curBlock <= map.boardPager.totBlock }">
						<!-- <a href="javascript:list('${map.boardPager.nextPage }')">[다음]</a> -->
						<a href="getAfterBoardList.do?curPage=${map.boardPager.nextPage }">[다음]</a> 
					</c:if>
					
					<!-- 끝 페이지로 이동: 현재페이지가 전체 페이지보다 작거나 같으면 [끝]하이퍼링크를 화면에 출력 -->
					<c:if test="${map.boardPager.curPage <= map.boardPager.totPage }">
						<!-- <a href="javascript:list('${map.boardPager.totPage }')">[끝]</a> -->
						<a href="getAfterBoardList.do?curPage=${map.boardPager.totPage }">[끝]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<table width="700">
			<tr>
				<td align="right">
					<form name="form" action="writeAfterBoard.do" method="GET">
						<input type="hidden" id="member" value="${member }"> <input
							type="button" id="writebt">
					</form>

				</td>
			</tr>
		</table>
		<form method="post" name="searchForm" action="#">
		<table>
			<tr>
				<td align="left"><select name="search" id="searchCondition">
						<option value="제목+내용">제목+내용</option>
						<option value="제목만">제목만</option>
						<option value="글작성자">글작성자</option>
						<option value="댓글내용">댓글내용</option>
						<option value="댓글작성자">댓글작성자</option>
				</select></td>
				
				<td align="left"><input type="text" size="100px" id="keyword" name="keyword"/></td>
				<td align="right"><a href="#">
						<button type="button" class="btn btn-default" id="searchBt">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
				</a></td>
		</table>
	</form>
	</div>
	
<script type="text/javascript" src="../resources/js/boardScript.js"></script>
<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>