<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 content</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
</head>
<body>
	<form action="updateLostForm.do?seq=${vo.seq}" method="post">
		<input type="hidden" name="id" value="${member.id }"> <input
			 type="hidden" name="name" value="${member.name }" />
		<table id="content" border="1" align="center">
			<tr>
				<td class="contenttd">글번호</td>
				<td>${vo.seq }</td>
				<td class="contenttd">조회수</td>
				<td>${vo.cnt }</td>
			</tr>

			<tr>
				<td class="contenttd">글쓴이</td>
				<td>${vo.name }</td>
				<td class="contenttd">작성일</td>
				<td>${vo.regdate }</td>
			</tr>

			<tr>
				<td class="contenttd" width="60">글 제목</td>
				<td colspan="3">${vo.title }</td>
			</tr>

			<tr>
				<td width="500" height="70" colspan="4">글 내용</td>
			</tr>

			<tr>
				<td width="500" height="200" colspan="4">${vo.content }</td>
			</tr>

		</table>

		<table width="500" align="center">
			<tr>
				<td align="center"><c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<a href="deleteLostBoard.do?seq=${vo.seq }"><input
								type="button" class="contentbt" value="삭제"></a>
						</c:when>
					</c:choose> <a href="getLostBoardList.do"><input type="button"
						class="contentbt" value="목록"></a></td>
			</tr>

		</table>


	</form>



	<script type="text/javascript" src="../resources/js/boardScript.js"></script>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>