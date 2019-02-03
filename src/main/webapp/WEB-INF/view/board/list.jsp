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
</head>
<body>

	<!-- 화면 센터 -->
	<div align="center">
		<b>글목록(전체 글 : ${pagination.listCnt } )</b>
		<table border="1" width="700" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" id="boardhead">
				<td align="center" width="55">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="100">조회수</td>
				<td align="center" width="70">추천수</td>
			</tr>
			<%---- 글이 없을 경우 -->
			<c:if test="${count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if> --%>

			<c:forEach var="vo" items="${list }">
				<tr height="30">
					<td align="center" width="50">${vo.seq }</td>
					<td width="250"><a
						href="getBoard.do?seq=${vo.seq}&&id=${member.id}">${vo.title }</a></td>
					<td align="center" width="100">${vo.name }</td>
					<td align="center" width="150">${vo.regDate }</td>
					<td align="center" width="50">${vo.cnt }</td>
					<td align="center" width="50">${vo.best }</td>
				</tr>
			</c:forEach>

		</table>
		<table width="700">
			<tr>
				<td align="right">
					<form name="form" action="writeBoard.do" method="POST">
						<input type="hidden" id="member" value="${member }"> <input
							type="button" id="writebt">
					</form>
					<div align="center">
						<c:if test="${pagination.curRange ne 1 }">
							<a href="#" onClick="fn_paging(1)">[처음]</a>
						</c:if>
						<c:if test="${pagination.curPage ne 1}">
							<a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a>
						</c:if>
						<c:forEach var="pageNum" begin="${pagination.startPage }"
							end="${pagination.endPage }">
							<c:choose>
								<c:when test="${pageNum eq  pagination.curPage}">
									<span style="font-weight: bold;"><a href="#"
										onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
								</c:when>
								<c:otherwise>
									<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if
							test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
							<a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a>
						</c:if>
						<c:if
							test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
							<a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a>
						</c:if>
					</div>

					
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td align="left"><select name="search">
						<option value="제목+내용">제목+내용</option>
						<option value="제목만">제목만</option>
						<option value="글작성자">글작성자</option>
						<option value="댓글내용">댓글내용</option>
						<option value="댓글작성자">댓글작성자</option>
				</select></td>
				<td align="left"><input type="text" size="100px"></td>
				<td align="right"><a href="#">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
				</a></td>
		</table>

	</div>
	<script>
		function fn_paging(curPage) {
			location.href = "getBoardList.do?curPage=" + curPage;
		}
	</script>

	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>