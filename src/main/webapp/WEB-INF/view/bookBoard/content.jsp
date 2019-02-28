<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">	
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>



</head>
<body>
	<form id="form" action="updateForm.do?seq=${vo.seq }" method="post">
		<input type="hidden" id="seq" value="${vo.seq }" /> <input
			type="hidden" id="id" value="${member.id }" /> <input type="hidden"
			id="best_check"> <input type="hidden" name="id"
			value="${member.id }"> <input type="hidden" name="name"
			value="${member.name }" /> <input type="hidden" id="start_wido"
			name="start_wido" value="${vo.start_wido }" /> <input type="hidden"
			id="start_kyungdo" name="start_kyungdo" value="${vo.start_kyungdo }" />
		<input type="hidden" id="end_wido" name="end_wido"
			value="${vo.end_wido }" /> <input type="hidden" id="end_kyungdo"
			name="end_kyungdo" value="${vo.end_kyungdo }" /> <input
			type="hidden" id="mid_wido" name="mid_wido" value="${vo.mid_wido }" />
		<input type="hidden" id="mid_kyungdo" name="mid_kyungdo"
			value="${vo.mid_kyungdo }" />
<br/>
<table width="1000px" align="center" id="outline">
		<tr><td>	
		
		<table align="center" width="960">
		
		<tr>
		<td align="left" ><c:if
						test="${member.statecount == 4 }">
						<!-- 관리자가 이 버튼이 보이도록 코드 수정 -->
						<input type="button" id="deleteButton" class="contentbt"
							value="삭제">
					</c:if></td>
		
		<td align="right" colspan="3"><a
					href="getBookBoardList.do?curPage=${curPage }&searchOption=${searchOption}&keyword=${keyword}">
						<input type="button" class="contentbt" value="목록">
				</a></td></tr>
				
			<tr id="tr01"><td><b>${vo.title }</b></td>
		<td width="90"><b>${vo.name }(${vo.id})</b></td>
		<td align="right" width="100"><font color="grey" size="1">${vo.regDate }</font></td>
	</tr>		
		
	<tr><td colspan="4">${vo.content }</td></tr>			
	<tr><td colspan="4" align="center"><div id="map" style="width: 950px; height: 500px;"></div></td></tr>	
	
	<tr>
		<td colSpan="4">&nbsp;<b><i class='far fa-hand-point-right' style='font-size:20px;color:rgb(49, 100, 176)'></i>&nbsp;출발지 : <span id="spanStartJuso"></b></span>
	</td>
			</tr>
			<tr>
				<td colSpan="4">
					<div id="divMidJuso"></div>
				</td>
			</tr>
			<tr>
				<td colSpan="4">&nbsp;<b><i class='fas fa-hand-point-right' style='font-size:20px;color:rgb(49, 100, 176)'></i>&nbsp;도착지 : <span id="spanEndJuso"></b></span>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					&nbsp;<i class="fa fa-bus" style="font-size:20px;color:rgb(49, 100, 176)"></i>&nbsp;<b>차종 : </b> <b><c:if test="${vo.bus == 45}">
								45인승 대형버스</c:if> <c:if test="${vo.bus == 28}">
								28인승 리무진 대형버스</c:if> <c:if test="${vo.bus == 25}">
								25인승 중형버스</c:if></b>
				</td>
			</tr>
			<tr>
				<td colSpan="4">&nbsp;<b><i class='fas fa-calendar-alt' style='font-size:20px;color:rgb(49, 100, 176)'></i></b>
					<b>출발일시 : ${vo.startdate }</b>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<div id="midTimeDiv">&nbsp;<b><i class='far fa-plus-square' style='font-size:20px;color:rgb(49, 100, 176)'></i>&nbsp;경유 : ${vo.middate }</b></div>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					&nbsp;<b><i class='far fa-clock' style='font-size:20px;color:rgb(49, 100, 176)'></i>&nbsp;총 예상 소요시간 : ${vo.finishtime }분</b>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					&nbsp;<b><i class="fa fa-krw" style="font-size:20px;color:rgb(49, 100, 176)"></i>&nbsp;승차금액 : ${vo.pay }원</b>
				</td>
			</tr>
			
			<!-- 
			<tr>
				<td class="contenttd">글번호</td>
				<td colspan="3">${vo.seq}</td>

			</tr>
			<tr>
				<td class="contenttd">글쓴이</td>
				<td>${vo.name }</td>
				<td class="contenttd">작성일</td>
				<td>${vo.regDate }</td>
			</tr>
			<tr>
				<td class="contenttd" width="60">글 제목</td>
				<td colspan="3">${vo.title }</td>
			</tr>
			<tr>
				<td width="500" height="70" colspan="4">글내용</td>
			</tr>
			<tr>
				<td width="500" height="200" colspan="4">${vo.content }</td>
			</tr>
			<tr>
				<td colSpan="4">
					<div id="map" style="width: 800px; height: 300px;"></div>
				</td>
			</tr>
			<tr>
				<td colSpan="4">출발지 : <span id="spanStartJuso"></span>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<div id="divMidJuso"></div>
				</td>
			</tr>
			<tr>
				<td colSpan="4">도착지 : <span id="spanEndJuso"></span>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<h4>차종</h4> <c:if test="${vo.bus == 45}">
								45인승 대형버스</c:if> <c:if test="${vo.bus == 28}">
								28인승 리무진 대형버스</c:if> <c:if test="${vo.bus == 25}">
								25인승 중형버스</c:if>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<h4>출발일시</h4> ${vo.startdate }
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<div id="midTimeDiv">경유 : ${vo.middate }</div>
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<h4>총 예상 소요시간</h4> ${vo.finishtime }분
				</td>
			</tr>
			<tr>
				<td colSpan="4">
					<h4>승차금액</h4>${vo.pay }원
				</td>
			</tr>

		</table>
		<table width="500" align="center">
			<tr>
				<td> <a href="bookingTicket.do?seq=${vo.seq }"><input type="button"
						class="contentbt" value="예약"></a>&nbsp;</td>
			</tr>
		</table>
		 -->
	</form>

	<%@include file="../bookBoard/comment.jsp"%>
		
	</td></tr>
</table>	



	<script>
		$("#deleteButton").click(function() {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				location.href = "deleteBookBoard.do?seq=${vo.seq }";
			}
		})

		function best_click() {
			var frm_read = $('#form');
			var seq = $('#seq', form).val();
			var id = $('#id', form).val();
			var allData = {
				"seq" : seq,
				"id" : id
			}
			$.ajax({
				url : "bestClick.do",
				type : "POST",
				cache : false,
				dataType : "json",
				data : allData,
				success : function(data) {

					var msg = '';
					var best_img = '';
					msg += data.msg;
					alert(msg);

					if (data.best_check == 0) {
						best_img = "../resources/images/bestbt.png";
					} else {
						best_img = "../resources/images/onbestbt.png";
					}

					$('#bestButton', frm_read).attr('src', best_img);
					$('#best_cnt').html(data.best_cnt);
					$('#best_check').html(data.best_check);

				},
				error : function(request, status, error) {
					alert("로그인 후 이용해주세요.");
				}
			});
		}
	</script>

	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<script type="text/javascript"
		src="../resources/js/userContentMapScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>