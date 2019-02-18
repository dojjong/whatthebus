<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="../resources/css/testBoard.css" />
<!-- 글쓰기 버튼  -->
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>


</head>
<body>
	<br>
	<br>
	<!-- 화면 센터 -->
	<div align="center">
		
	<b>글목록(전체 글 : ${map.count } )</b>
	
		<table class="list">
			<tr>
				<th width="50">번호</th>
				<th>제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
				<th width="60">조회수</th>
			</tr>
			<%---- 글이 없을 경우 -->
			<c:if test="${count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if> --%>

			<c:forEach var="vo" items="${map.list }" varStatus="status" >
				<tr height="30">
					<td align="center" width="50">${vo.seq }</td>
					
					<td width="650"><a href="getNoticeBoard.do?seq=${vo.seq}&&id=${member.id}&&curPage=${map.pagination.curPage }&searchOption=${map.searchOption}&keyword=${map.keyword}">
					${vo.title }</a>&nbsp;<c:if test="${map.commentCount[status.index]!=0}">
					[${map.commentCount[status.index]}]</c:if></td>
					<td align="center" width="100">${vo.name }</td>
					<td align="center" width="150">${vo.regdate }</td>
					<td align="center" width="50">${vo.cnt }</td>
				</tr>
			</c:forEach>

		</table>
		<table width="700">
			<tr>
				<td align="right">
					<form name="form" action="writeNoticeBoard.do" method="POST">
						<input type="hidden" id="member" value="${member }"><input type="button" id="writebt" value="글쓰기">
					</form>
					
					<div align="center">
						<c:if test="${map.pagination.curBlock > 1 }">
							<a href="#" onClick="fn_paging(1,'${searchOption }','${keyword }')">[처음]</a>
						</c:if>
						<c:if test="${map.pagination.curBlock > 1}">
							<a href="#"
								onClick="fn_paging('${map.pagination.prevPage }','${searchOption }','${keyword }')">[이전]</a>
						</c:if>
						<c:forEach var="pageNum" begin="${map.pagination.blockBegin }"
							end="${map.pagination.blockEnd }">
							<c:choose>
								<c:when test="${pageNum ==  map.pagination.curPage}">
									<span style="font-weight: bold;"><a href="#"
										onClick="fn_paging('${pageNum }','${searchOption }','${keyword }')">${pageNum }</a></span>
								</c:when>
								<c:otherwise>
									<a href="#"
										onClick="fn_paging('${pageNum }','${searchOption }','${keyword }')">${pageNum }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${map.pagination.curBlock <= map.pagination.totBlock}">
							<a href="#"
								onClick="fn_paging('${map.pagination.nextPage }','${searchOption }','${keyword }')">[다음]</a>
						</c:if>
						<c:if test="${map.pagination.curPage <= map.pagination.totPage}">
							<a href="#"
								onClick="fn_paging('${map.pagination.totPage }','${searchOption }','${keyword }')">[끝]</a>
						</c:if>
					</div>
					
					
					
				</td>
			</tr>
		</table>
	<form method="post" action="getNoticeBoardList.do">
			<table>
				<tr>
					<td align="left"><select name="searchOption">
						<option value="all" <c:out value="${map.searchOption=='all'?'selected':''}"/>>전체검색</option>
						<option value="content" <c:out value="${map.searchOption=='content'?'selected':''}"/>>제목+내용</option>
						<option value="title" <c:out value="${map.searchOption=='title'?'selected':''}"/>>제목만</option>
						<option value="name" <c:out value="${map.searchOption=='name'?'selected':''}"/>>글작성자</option>
						<option value="comment" <c:out value="${map.searchOption=='comment'?'selected':''}"/>>댓글내용</option>
						<option value="cname" <c:out value="${map.searchOption=='cname'?'selected':''}"/>>댓글작성자</option> 
					</select></td>
					<td align="left"><input name="keyword" value="${map.keyword}"></td>
					<td align="right"><a href="#">

							<button style='font-size:14px' type="submit" class="btn btn-primary"><i class='fas fa-search'style='color:white'> 검색</i></button>
					</a></td>
			</table>
	</form>
	</div>
	
	<script>
		function fn_paging(curPage) {
			location.href = "getNoticeBoardList.do?curPage=" + curPage
					+ "&searchOption=${map.searchOption}"
					+ "&keyword=${map.keyword}";
		}
	</script>
	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>