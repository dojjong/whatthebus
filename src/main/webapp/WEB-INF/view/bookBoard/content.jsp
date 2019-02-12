<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
</head>
<body>
	<form action="updateBookForm.do?seq=${vo.seq}" method="post">
		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" />
		<table id="content" border="1" align="center">
			<tr>
				<td class="contenttd">글번호</td>
				<td>${vo.seq}</td>
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
				<td colSpan="2" width="500">
					<table>
						<tr>
				<td colSpan="4"><div id="map"
						style="width: 800px; height: 300px;"></div></td>
			</tr>
			<tr>
				<td colSpan="4">출발지 : <span id="spanStartJuso"></span></td>
			</tr>
			<tr>
				<td colSpan="4">도착지 : <span id="spanEndJuso"></span></td>
			</tr>

		</table>
					</table>
				</td>
			</tr>
		</table>
		<script type="text/javascript"
			src="../resources/js/driverRegistMap.js"></script>
		<table width="500" align="center">
			<tr>
				<td align="center"><input type="button" id="likebutton"
					value="1"> <!-- 벨류에 추천1 늘때마다 숫자 늘어나는 코드 넣어주기 --> <c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<a href="deleteBookBoard.do?seq=${vo.seq }"> <input type="button"
								class="contentbt" value="삭제"></a>
						</c:when>
					</c:choose> <a href="getBookBoardList.do"> <input type="button"
						class="contentbt" value="목록">
				</a></td>
			</tr>
		</table>

	</form>


	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<script type="text/javascript" src="../resources/js/driverRegistMapScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>