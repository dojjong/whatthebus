<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bar-rating -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/fontawesome-stars.css">
<script type="text/javascript"
	src="../resources/js/jquery.barrating.min.js"></script>

</head>
<body>
	<form id="reviewForm" name="reviewForm" method="post">
		<input type="hidden" name="id" value="${member.id}"> <input
			type="hidden" name="name" value="${member.name }"> <input
			type="hidden" name="busseq" value="${vo.seq }"> <input
			type="hidden" name="driverid" value="${vo.id }"> <input
			type="hidden" name="drivername" value="${vo.name }"> <input
			type="hidden" id="star" name="star" value="">

		<table>
			<tr>
				<td><select id="example">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
				</select></td>
				<td>작성자 : ${member.name }</td>
				<td>기사님 이름 : ${vo.name } &nbsp;&nbsp;&nbsp; 코스명 : ${vo.title }</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="4"><textarea id="content" name="content" rows="5"
						cols="50" placeholder="내용을 입력해주세요."></textarea> <input
					type="button" value="작성" onclick="insertReview();"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var star;
		$(function() {
			$('#example').barrating({
				theme : 'fontawesome-stars',
				initialRating : 3,
				//읽기전용 : readonly: true
				onSelect : function(value, text, event) {
					// 별점 클릭 후 처리는 여기서 코드 
					// 선택한 별점 값을 value로 받음
					star = value;
				}

			});
		});
		function insertReview() {
			document.reviewForm.star.value = star;
			$.ajax({
				type : "POST",
				url : "insertReview.do",
				data : $("#reviewForm").serialize(),

				success : function(data) {
					if (data == "success") {
						$("#result").load("getBookingPayList.do");
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