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
<style>
#writebt {
	width: 65px;
	height: 30px;
	background-color: white;
	background-image: url("../resources/images/writebutton.png");
	background-repeat: no-repeat;
	background-size: 65px 30px;
	border: 1px solid lightgrey;
}
</style>

</head>
<body>
	<div align="center">



		<!-- <b>글목록(전체 글 : ${map.count } )</b> -->
		<table id="mylisttab" class="list">
			<tr id="boardhead">
				<th width="55">결제번호</th>
				<th width="450">제목</th>
				<th width="150">결제일</th>
				<th width="100">결제금액</th>
				<th width="70">포인트사용</th>
				<th width="100">실결제금액</th>
			</tr>
			<c:if test="${map.count==0 }">
				<tr>
					<td colspan="6" align="center">포인트 사용내역이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="vo" items="${map.list }" varStatus="status">
				<tr height="30">
					<td align="center" width="50">${vo.seq }</td>
					<td width="450">${map.titleList[status.index]}</td>
					<td align="center" width="150">${vo.regdate }</td>
					<td align="center" width="50">${vo.pay }원</td>
					<td align="center" width="50">${vo.point }P</td>
					<td align="center" width="100"><c:out
							value="${vo.pay-vo.point}" />원</td>
				</tr>
			</c:forEach>

		</table>
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
	</div>
	<script>
		function fn_paging(curPage) {
			$("#result").load("getDriverPointList.do?curPage=" + curPage);

		}
	</script>
</body>
</html>