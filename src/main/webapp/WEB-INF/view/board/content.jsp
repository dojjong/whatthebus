<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/boardStyle.css" />
</head>
<body>
	<form id="form" action="updateForm.do?seq=${vo.seq }" method="post">
		<input type="hidden" id="seq" value="${vo.seq }" /> <input
			type="hidden" id="id" value="${member.id }" />
		<table id="content" border="1" align="center">

			<tr>
				<td class="contenttd">글번호</td>
				<td>${vo.seq}</td>
				<td class="contenttd">조회수</td>
				<td>${vo.cnt }</td>
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
		</table>
		<table width="500" align="center">
			<tr>
				<td align="center"><a href='javascript:void(0);'
					onclick="best_click();"> <c:choose>
							<c:when test="${best==0 }">
								<img src='../images/bestbt.png' id="bestButton">
							</c:when>
							<c:otherwise>
								<img src='../images/onbestbt.png' id="bestButton">
							</c:otherwise>
						</c:choose> <span id="best_cnt">${vo.best } </span></a> <!-- 벨류에 추천1 늘때마다 숫자 늘어나는 코드 넣어주기 -->
					<c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<a href="deleteBoard.do?seq=${vo.seq }"> <input type="button"
								class="contentbt" value="삭제"></a>
						</c:when>
					</c:choose> <a href="getBoardList.do"> <input type="button"
						class="contentbt" value="목록">
				</a></td>
			</tr>
		</table>

	</form>
	<script>
		function best_click() {
			var frm_read = $('#form');
			var seq = $('#seq', form).val();
			var id = $('#id', form).val();
			var allData ={"seq":seq,"id":id}
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
						best_img = "../images/bestbt.png";
					} else {
						best_img = "../images/onbestbt.png";
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

	<script type="text/javascript" src="../js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>