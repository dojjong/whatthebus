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

</head>
<body>

	<div align="center" width="500">
		<table id="listtab">
			<tr height="30">
				<td width="70">기사님 성함</td>
				<td width="5">별점</td>
				<td width="30">작성자</td>
				<td width="150">내용</td>
				<td width="50">작성일</td>
			</tr>
			<c:forEach var="vo" items="${reviewList }" varStatus="status">
				<tr height="30">

					<td width="30">${vo.drivername }</td>
					<td width="100"><input type="hidden" id="seq" name="seq"
						value="${vo.seq }" /> <select class="star"
						data-current-rating="${vo.star }">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
					<td width="30">${vo.name }</td>
					<td width="150">${vo.content }</td>
					<td width="50">${vo.regdate }</td>
				</tr>
			</c:forEach>
		</table>
		<div align="center">후기는 [마이페이지]-[결제내역]에서 작성하실수 있습니다.</div>
	</div>

	<%-- <input type="button" class="contentbt" value="후기작성">--%>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
	<script type="text/javascript">
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