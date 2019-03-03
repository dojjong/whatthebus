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
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>


</head>
<body>
	<form action="updateQaForm.do?seq=${vo.seq}" method="post">
		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" />
			
<br/>	

<table width="1000px" align="center" id="outline"><!-- 아웃라인  -->
		<tr><td>		
			
		<table id="content" width="960" align="center">
		
		<tr><td><c:choose><c:when test="${member.statecount == 4 }">
				<input type="submit" class="contentbt" value="수정">
				<!-- 관리자가 이 버튼이 보이도록 코드 수정 -->
				<input type="button" id="deleteAdminButton" class="admin_contentbt" value="관리자삭제">
				 </c:when></c:choose></td>
				 <td align="right" colspan="3">
				<a href="getQaBoardList.do"> <input type="button" class="contentbt" value="목록">
				</a></td>
		</tr>
		
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
		
		
		</table>
		
		<table width="960" align="center">
		<tr><td align="left"  width="100"><font size="1">조회수:<b>${vo.cnt }</b></font></td>
		</tr></table>
		

	</form>
	
	
	<%@include file="../qaBoard/comment.jsp"%>
	
	</table><!-- 아웃라인  -->
	<br/>
	<script>
		$("#deleteButton").click(function() {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				location.href = "deleteQaBoard.do?seq=${vo.seq }";
			}
		});
	
	</script>


	<script type="text/javascript" src="../resources/js/boardScript.js"></script>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>