<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../resources/css/boardStyle.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
</head>
<body>
	<form action="updateSuggestForm.do?seq=${vo.seq }" method="post" id="contentForm">
			<input type="hidden" name="id" value="${member.id }"> 
			<input type="hidden" name="name" value="${member.name }" /> 
			
			<input type="hidden" id="start_wido" name="start_wido" value="${vo.start_wido }" />
			 <input type="hidden" id="start_kyungdo" name="start_kyungdo" value="${vo.start_kyungdo }" />
			 <input type="hidden" id="end_wido" name="end_wido" value="${vo.end_wido }" />
			 <input type="hidden" id="end_kyungdo" name="end_kyungdo" value="${vo.end_kyungdo }" />
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
			<tr>
					<td colSpan="2"><div id="map" style="width: 800px; height: 300px;"></div></td>	
			</tr>
			<tr>
				<td colSpan="2">확정 출발지 : <span id="spanStartJuso" ></span></td>
			</tr>
			<tr>
				<td colSpan="2">확정 도착지 : <span id="spanEndJuso" ></span></td>
			</tr>

			
		</table>
		
		<table width="500" align="center">
			<tr>
				<td align="center"><input type="button" id="likebutton"
					value="1"> <!-- 벨류에 추천1 늘때마다 숫자 늘어나는 코드 넣어주기 --> <c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<a href="deleteSuggestBoard.do?seq=${vo.seq }"> <input type="button"
								class="contentbt" value="삭제"></a>
						</c:when>
					</c:choose> <a href="getSuggestBoardList.do"> <input type="button"
						class="contentbt" value="목록">
				</a></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<script type="text/javascript" src="../resources/js/userViewMapScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>