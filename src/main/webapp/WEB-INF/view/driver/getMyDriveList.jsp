<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
	crossorigin='anonymous'>
</head>
<body>

	<!-- 화면 센터 -->
	<div align="center">
		<table width="800px">
			<tr>
				<td colspan="5"><h3>
						<b>배차조회 게시판</b>
					</h3></td>
			</tr>
			<tr>
				<td colspan="3"></td>
				<td colspan="2" align="right"><b>Total : ${map.count } </b></td>
			</tr>

		</table>

		<!-- <b>글목록(전체 글 : ${map.count })</b>  -->
		<table border="1" width="800" cellpadding="0" cellspacing="0"
			align="center" class="list">
			<tr height="30" id="boardhead">
				<th align="center" width="55">번호</th>
				<th align="center" width="250">제목</th>
				<th align="center" width="100">작성자</th>
				<th align="center" width="150">운행일</th>
			</tr>

			<c:if test="${map.count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach var="vo" items="${map.list }">
				<c:choose>
					<c:when test="${vo.best<0 }">
						<tr height="30">
							<td align="center" width="50">${vo.seq }</td>
							<td width="550">관리자에 의해 삭제된 게시글입니다. &nbsp;
							<td align="center" width="100">관리자</td>
							<td align="center" width="150">${vo.realstartdate }</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr height="30">
							<td align="center" width="50">${vo.seq }</td>
							<td width="250"><a
								href="getBookBoard.do?seq=${vo.seq}&&id=${member.id}&&curPage=${map.pagination.curPage }&searchOption=${map.searchOption}&keyword=${map.keyword}">
									${vo.title }</a></td>
							<td align="center" width="100">${vo.name }</td>
							<td align="center" width="150">${vo.realstartdate }</td>
						</tr>
					</c:otherwise>
				</c:choose>
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
	</div>
	<script>
		function fn_paging(curPage) {
			$("#result").load("getMyDriveList.do?curPage=" + curPage);

		}
	</script>


</body>
</html>