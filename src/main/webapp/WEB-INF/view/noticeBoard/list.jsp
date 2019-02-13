<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="../resources/css/testBoard.css" />
<!-- 글쓰기 버튼  -->
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>


</head>
<body>
	<br>
	<br>
	<!-- 화면 센터 -->
	<div align="center">
		
	<!-- <b>글목록(전체 글 : ${map.count } )</b> -->
	
		<table class="list">
			<tr>
				<th width="50">번호</th>
				<th>제목</th>
				<th width="100">작성자</th>
				<th width="100">작성일</th>
				<th width="60">조회수</th>
			</tr>
			<%---- 글이 없을 경우 -->
			<c:if test="${count==0 }">
				<tr>
					<td colspan="6" align="center">게시판에 저장된 글이 없습니다.</td>
				</tr>
			</c:if> --%>

			<c:forEach var="vo" items="${list }" >
				<tr>
					<td align="center">${vo.seq }</td>
					<td align="left"><a href="getNoticeBoard.do?seq=${vo.seq}">${vo.title }</a></td>
					<td align="center">${vo.name }</td>
					<td align="center">${vo.regdate }</td>
					<td align="center">${vo.cnt }</td>
				</tr>
			</c:forEach>

		</table>
		<table>
			<tr>
				<td>
					<form name="form" action="writeNoticeBoard.do" method="POST">
						<input type="hidden" id="member" value="${member }">
						<button style='font-size:14px' class="btn btn-primary" id="writeBT"><i class='far fa-edit'style='color:white'></i><strong>글쓰기</strong></button>
					</form>
				</td>
			</tr>
		</table>

			<table>
				<tr>
					<td align="left"><select name="searchOption">
						<option value="제목+내용">제목+내용</option>
						<option value="제목만">제목만</option>
						<option value="글작성자">글작성자</option>
						<option value="댓글내용">댓글내용</option>
						<option value="댓글작성자">댓글작성자</option>
					</select></td>
					<td align="left"><input name="keyword"></td>
					<td align="right"><a href="#">
							<button style='font-size:14px' type="submit" class="btn btn-primary"><i class='fas fa-search'style='color:white'> 검색</i></button>
							
					</a></td>
			</table>
	
	</div>
	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>