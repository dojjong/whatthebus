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

<script>
	$(document).ready(function(){
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠습니까?")){
				document.contentForm.action = "deleteAfterBoard.do";
				document.contentForm.submit();
				return;
			}else{
				return;
			}
		});
	});
	
</script>

</head>
<body>
	<form method="post" name="contentForm">
			<input type="hidden" name="id" value="${member.id }"> 
			<input type="hidden" name="name" value="${member.name }" /> 
			<input type="hidden" name="seq" id="seq" value="${vo.seq }" /> 
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
		
		<table width="500" align="center">
			<tr>
				<td align="center"><input type="button" id="likebutton"
					value="1"> <!-- 벨류에 추천1 늘때마다 숫자 늘어나는 코드 넣어주기 --> <c:choose>
						<c:when test="${member.id == vo.id }">
							<a href="updateAfterForm.do?seq=${vo.seq }"> <input type="button" class="contentbt" id="btnUpdate" value="수정"></a>
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							 <input type="button"
								class="contentbt" id="btnDelete" value="삭제" >
						</c:when>
					</c:choose> <a href="getAfterBoardList.do"> <input type="button"
						class="contentbt" value="목록">
				</a></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>