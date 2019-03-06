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
<!-- bar-rating -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/fontawesome-stars.css">
<style>
.td001{
	background-color: rgb(49, 100, 176);
	color: white;
}

#listtab td{
border-right: 2px solid white;
}
</style>
</head>
<body>
	<div align="center" width="500">
		<table width="1000px">
      <tr><td colspan="5"><h3><b>후기게시판</b></h3></td>
      <td><b>후기는 [마이페이지]-[결제내역]에서 작성하실수 있습니다.</b></td>
      
      </tr>
		
      </table>
		<table id="listtab">
			<tr height="30">
				<td width="50" class="td001" align="center"><b>기사님 성함</b></td>
				<td width="50" class="td001" align="center"><b>별점</b></td>
				<td width="30" class="td001" align="center"><b>작성자</b></td>
				<td width="200" class="td001" align="center"><b>내용</b></td>
				<td width="50" class="td001" align="center"><b>작성일</b></td>
			</tr>
			<c:forEach var="vo" items="${map.reviewList }" varStatus="status">
				<tr height="30">

					<td width="30" align="center">${vo.drivername }</td>
					<td width="100" align="center"><input type="hidden" id="seq" name="seq"
						value="${vo.seq }" /> <select class="star"
						data-current-rating="${vo.star }">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
					<td width="30" align="center">${vo.name }</td>
					<td width="150" >&nbsp;&nbsp;${vo.content }</td>
					<td width="50" align="center">${vo.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center">
			<c:if test="${map.pagination.curBlock > 1}">
				<a href="#" onClick="fn_paging('${map.pagination.prevPage }')">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${map.pagination.blockBegin }"
				end="${map.pagination.blockEnd }">
				<c:choose>
					<c:when test="${pageNum ==  map.pagination.curPage}">
						<span style="font-weight: bold;"><a href="#"
							onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
					</c:when>
					<c:otherwise>
						<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${map.pagination.curBlock <= map.pagination.totBlock}">
				<a href="#" onClick="fn_paging('${map.pagination.nextPage }')">[다음]</a>
			</c:if>
			<c:if test="${map.pagination.curPage <= map.pagination.totPage}">
				<a href="#" onClick="fn_paging('${map.pagination.totPage }')">[끝]</a>
			</c:if>
		</div>


	</div>
	<br/>
	<%-- <input type="button" class="contentbt" value="후기작성">--%>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
	<script type="text/javascript">
		function fn_paging(curPage) {
			location.href = "getAllReviewList.do?curPage=" + curPage
		}

		$(function() {
			$('.star').each(function(index, el) {
				var $El = $(el);
				$El.barrating({
					theme : 'fontawesome-stars',
					readonly : true,
					initialRating : $El.attr('data-current-rating')
				});
			});
		});
	</script>
	<script type="text/javascript"
		src="../resources/js/jquery.barrating.min.js"></script>

</body>
</html>