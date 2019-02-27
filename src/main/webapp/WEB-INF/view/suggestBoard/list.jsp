<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>   	
</head>
<body>

	<!-- 화면 센터 -->
	<div align="center">
	<table width="1000px">
      <tr><td colspan="5"><h3><b>배차대기 게시판</b></h3></td></tr>
      <tr><td colspan="3"></td><td colspan="2" align="right"><b>Total : ${map.count } </b></td></tr>
      
      </table>
	
	<!-- 	<b>글목록(전체 글 :${map.count } )</b> -->
		<table id="listtab" class="list">
			<tr id="boardhead">
				<th align="center" width="100">번호</th>
				<th align="center" width="550">제목</th>
				<th align="center" width="200">작성자</th>
				<th align="center" width="250">작성일</th>
				<th align="center" width="200">조회수</th>
				<th align="center" width="100">추천</th>
				<th align="center" width="250">배차상태</th>
				<c:if test="${member.license!=null }">
					<th align="center" width="120">배차신청</th>
				</c:if>
			</tr>
			<%---- 글이 없을 경우 -->
			<c:if test="${count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if> --%>

			<c:forEach var="vo" items="${map.list }" varStatus="status">
				<c:if test="${vo.best>=map.bestcount}">
					<c:set var="doneLoop" value="false" />
					<c:set var="bestLoop" value="false" />
					<tr height="30">
						<td align="center" width="100">${vo.seq }</td>
						<td width="550"><a
							href="getSuggestBoard.do?seq=${vo.seq}&&id=${member.id}&&curPage=${map.pagination.curPage }&searchOption=${map.searchOption}&keyword=${map.keyword}">
								${vo.title }</a>&nbsp; <c:if
								test="${map.commentCount[status.index]!=0}">
								[${map.commentCount[status.index]}]
								</c:if></td>
						<td align="center" width="150">${vo.name }</td>
						<td align="center" width="150">${vo.regDate }</td>
						<td align="center" width="150">${vo.cnt }</td>
						<td align="center" width="100">${vo.best }</td>

						<td align="center" width="250"><c:if
								test="${vo.totalbest==vo.best }">
								<font color="#FF0000">미배차</font>
								<c:set var="doneLoop" value="true" />
							</c:if> <c:if test="${vo.totalbest<25&&not doneLoop  }">
								<font color="#0000FF">배차완료</font>
								<c:set var="doneLoop" value="true" />
								<c:set var="bestLoop" value="true" />
							</c:if> <c:if test="${vo.totalbest<vo.best&&not doneLoop }">
								<font color="#00FF00">일부배차</font>
							</c:if></td>
						<c:if test="${member.license!=null}">
							<c:if test="${bestLoop }">
								<td align="center" width="120">배차종료</td>
							</c:if>
							<c:if test="${not bestLoop }">
								<td align="center" width="120"><a
									href="updateSuggestForm.do?seq=${vo.seq }"><input
										type="button" class="contentbt" value="배차신청"></a></td>
							</c:if>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>

		</table>
		<table width="700">

			<tr>
				<td align="right">

					<div align="center">
						<c:if test="${map.pagination.curBlock > 1 }">
							<a href="#"
								onClick="fn_paging(1,'${searchOption }','${keyword }')">[처음]</a>
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
		<form method="post" action="getSuggestBoardList.do">
			<table>
				<tr>
					<td align="left"><select name="searchOption">
							<option value="all"
								<c:out value="${map.searchOption=='all'?'selected':'' }"/>>전체검색</option>
							<option value="content"
								<c:out value="${map.searchOption=='content'?'selected':'' }"/>>제목+내용</option>
							<option value="title"
								<c:out value="${map.searchOption=='title'?'selected':'' }"/>>제목만</option>
							<option value="name"
								<c:out value="${map.searchOption=='name'?'selected':'' }"/>>글작성자</option>
							<option value="comment"
								<c:out value="${map.searchOption=='comment'?'selected':'' }"/>>댓글내용</option>
							<option value="cname"
								<c:out value="${map.searchOption=='cname'?'selected':'' }"/>>댓글작성자</option>
					</select></td>
					<td align="left"><input name="keyword" value="${map.keyword}"></td>
					<td align="right"><a href="#">

							<button style='font-size:14px' type="submit" class="btn btn-primary"><i class='fas fa-search'style='color:white'> 검색</i></button>
                     <!-- <button type="submit" class="btn btn-default">
                        <span class="glyphicon glyphicon-search"></span> Search
                     </button> -->
					</a></td>
				<tr>
					<td colspan="2"><a href="dataTransform.do">지도 데이터 변환</a><a
						href="cluster.do">클러스터통계</a></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
		function fn_paging(curPage) {
			location.href = "getSuggestBoardList.do?curPage=" + curPage
					+ "&searchOption=${map.searchOption}"
					+ "&keyword=${map.keyword}";
		}
	</script>

	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<script type="text/javascript" src="../resources/js/userRegistMap.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>