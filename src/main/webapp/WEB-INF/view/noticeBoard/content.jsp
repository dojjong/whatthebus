<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<style>

#tr01{
	border-bottom: 1px dashed lightgrey;
}

#outline{
	border: 1px solid lightgrey;
}

#listbt{
 width: 65px;
 height: 30px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
 
}



</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../resources/css/testBoardStyle.css" />


</head>
<body>
<br/><br/>

	<form action="updateNoticeForm.do?seq=${vo.seq}" method="post">

		<input type="hidden" name="id" value="${member.id }"> 
		<input type="hidden" name="name" value="${member.name }" />
		
		<table width="840px" align="center" id="outline">
		<tr><td>
		
		<table width="800px" align="center">
		<tr><td align="right"><p><a href="getNoticeBoardList.do"> <input type="button" class="contentbt" id="listbt" value="목록"></a></p></td>
		</tr>
		</table>
		

		
		<div align="center">
		<table width="800px">
		<tr id="tr01">
		<td><b>${vo.title }</b> </td>
		<td align="right"><b>${vo.name }(${vo.id })</b>&nbsp;<font color="lightgrey" size="1">${vo.realregdate }</font><c:choose><c:when test="${member.id == vo.id }">
			<input type="submit" class="btn btn-link" value="수정"><font color="lightgrey">ㅣ</font>
			<a href="deleteNoticeBoard.do?seq=${vo.seq }"> 
			<input type="button" class="btn btn-link" id="deleteButton" value="삭제"></a>
			</c:when></c:choose> </td></tr>	
	
		<tr><td></br></br></br></td></tr>
		<tr><td colspan="4">${vo.content }</td></tr>
		
		<tr><td colspan="4"><b><font size="1">조회수 ${vo.cnt }</font></b></td></tr>
		
		</table>
		</div>
		
		
		
		<!-- 
		<table id="content" border="1" align="center" width="800">
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
				<td>${vo.realregdate }</td>
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
		 -->
		
		</form>

	
	<%@include file="../noticeBoard/comment.jsp"%>
	</td></tr>
		</table>
	<!-- 
	<table width="500" align="center">
			<tr>
				<td align="center"><c:choose>
						<c:when test="${member.id == vo.id }">
							<input type="submit" class="contentbt" value="수정">
							
							<a href="deleteNoticeBoard.do?seq=${vo.seq }"> <input type="button"
								class="contentbt" id="deleteButton" value="삭제"></a>
						</c:when>
					</c:choose> <a href="getNoticeBoardList.do"> <input type="button"
						class="contentbt" value="목록">
				</a></td>
			</tr>
		</table>
	 -->	
	<script>
		$("#deleteButton").click(function() {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				location.href = "deleteNoticeBoard.do?seq=${vo.seq }";
			}
		});
	
	</script>
	


	<script type="text/javascript" src="../resources/js/boardScript.js"></script>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>