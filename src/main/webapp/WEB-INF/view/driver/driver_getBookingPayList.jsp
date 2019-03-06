<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid rgb(49, 100, 176);
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: rgb(49, 100, 176);
  color: white;
}
</style>

</head>
<body>


<br/>
	<p align="center"><b>결제내역</b></p>
	<table align="center" id="customers">
		<tr>
			<th>버스번호</th>
			<th>결제수단</th>
			<th>자리번호</th>
			<th>결제금액</th>
			<th>결제일시</th>
			<th>후기등록</th>
			<th>후기등록여부</th>
		</tr>


		<c:forEach var="vo" items="${map.list }" varStatus="status">
			<tr>
				<td align="center">${vo.busseq }</td>
				<td align="center">${vo.selectpay }</td>
				<td align="center">${vo.sitnum }번</td>
				<td align="center">${vo.pay }원</td>
				<td align="center">${vo.realregdate }</td>
				<td align="center"><input type="button" value="후기작성"
					onclick="moveReviewForm('${vo.busseq}','${map.reviewCount[status.index] }');"></td>
				<td align="center"><c:if test="${map.reviewCount[status.index]!=0}">
						<font color="#0000FF">등록</font>
					</c:if> <c:if test="${map.reviewCount[status.index]==0}">
						<font color="#FF0000">미등록</font>
					</c:if></td>
			</tr>
		</c:forEach>

	</table>
	<br/>


<!-- 
	결제내역
	<table>
		<tr>
			<th>버스번호</th>
			<th>결제수단</th>
			<th>자리번호</th>
			<th>결제금액</th>
			<th>결제일시</th>
			<th>후기등록</th>
			<th>후기등록여부</th>
		</tr>


		<c:forEach var="vo" items="${map.list }" varStatus="status">
			<tr>
				<td>${vo.busseq }</td>
				<td>${vo.selectpay }</td>
				<td>${vo.sitnum }</td>
				<td>${vo.pay }</td>
				<td>${vo.realregdate }</td>
				<td><input type="button" value="후기작성"
					onclick="moveReviewForm('${vo.busseq}','${map.reviewCount[status.index] }');"></td>
				<td><c:if test="${map.reviewCount[status.index]!=0}">
						<font color="#0000FF">등록</font>
					</c:if> <c:if test="${map.reviewCount[status.index]==0}">
						<font color="#FF0000">미등록</font>
					</c:if></td>
			</tr>
		</c:forEach>

	</table>
 -->


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

	<script>
		function fn_paging(curPage) {
			$("#result").load("getDriverBookingPayList.do?curPage=" + curPage);

		}
		function moveReviewForm(busseq, check) {
			if (check != 0) {
				alert("이미 후기를 등록하셨습니다.");
				return;
			}
			$
					.ajax({
						type : "POST",
						url : "moveReview.do",
						data : {
							"busseq" : busseq
						},
						success : function(data) {
							if (data == "success") {
								$("#result").load(
										"moveDriverReviewForm.do?busseq=" + busseq);
								return;
							}
						},
						error : function(request, status, error) {
							alert("잘못된 접근입니다.");
						}
					});
		}
	</script>

</body>
</html>