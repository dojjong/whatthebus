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
<style>
/* 빨간선-확인용 삭제 할겁니다!*/
div {
   border: 1px solid red;
}

table {
   border: 1px solid red;
}

tr {
   border: 1px solid red;
}

td {
   border: 1px solid red;
}
/* 구간 확인용 삭제 할겁니다!*/


</style>	
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
			name="end_kyungdo" value="${vo.end_kyungdo }" />
			
<!-- 테이블 시작 -->
<br/>	
<!-- 아웃라인  -->
<table width="1000px" align="center" id="outline">
		<tr><td>
		
		
		
		
		<table width="960" align="center">
		<tr><td><c:choose><c:when test="${member.statecount == 4 }">
				<input type="submit" class="contentbt" value="수정">
				<!-- 관리자가 이 버튼이 보이도록 코드 수정 -->
				<input type="button" id="deleteAdminButton" class="admin_contentbt" value="관리자삭제">
			    </c:when></c:choose></td>
						
		<td align="right" colspan="3"><a href="getBoardList.do?curPage=${curPage }&searchOption=${searchOption}&keyword=${keyword}">
						<input type="button" class="contentbt" value="목록"></a></td></tr>
						
		<tr id="tr01"><td><b>${vo.title }</b></td>
		<td width="90"><b>${vo.name }(${vo.id})</b></td>
		<td align="right" width="100"><font color="grey" size="1">${vo.realregdate }</font></td>
		<td align="right" width="150"><c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<input type="button" id="deleteButton" class="contentbt"
								value="삭제">
						</c:when>
						
					</c:choose>
		</td></tr>
		
		<tr><td colspan="4">${vo.content }</td></tr>
		
		<tr><td colspan="4" align="center"><div id="map" style="width: 950px; height: 500px;"></div></td></tr>
		
		<tr>
				<td colSpan="4"><b>확정 출발지 : <span id="spanStartJuso"></span></b></td>
			</tr>
			<tr>
				<td colSpan="4"><b>확정 도착지 : <span id="spanEndJuso"></span></b></td>
			</tr>
		
		
		</table>
		<table width="960" align="center">
		<tr><td align="left"  width="100"><font size="1">조회수:<b>${vo.cnt }</b></font></td>
		<td align="right"><a href='javascript:void(0);'onclick="best_click();"> <c:choose>
							<c:when test="${best==0 }">
								<img src='../resources/images/bestbt.png' id="bestButton">
							</c:when>
							<c:otherwise>
								<img src='../resources/images/onbestbt.png' id="bestButton">
							</c:otherwise>
						</c:choose> <span id="best_cnt">${vo.best } </span></a></td></tr>
		</table>
		
<!-- 테이블 끝 -->		
		
	
	</form>

	<%@include file="../board/comment.jsp"%>

</td></tr>
</table>
<br/>

	<script>
		$("#deleteButton").click(function() {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				location.href = "deleteBoard.do?seq=${vo.seq }";
			}
		});
		$("#deleteAdminButton").click(function() {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				location.href = "deleteAdminBoard.do?seq=${vo.seq }";
			}
		});
		
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
		src="../resources/js/userViewMapScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>