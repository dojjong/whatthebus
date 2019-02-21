<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

<!-- 레포트선택하기  -->
	<table>
		<tr>
			<td><input type="button" id="afterBoardListReport_xlsx" value="afterList_xlsx" />&nbsp;</td>
			<td><input type="button" id="afterBoardListReport_xls" value="afterList_xls" />&nbsp;</td>
			<td><input type="button" id="afterBoardListReport_pdf" value="afterList_pdf" />&nbsp;</td>
		</tr>
	</table>
	<br><br>
	
	<!-- 모든 레포트는 여기서 나올 예정 -->
	<div id="reportdiv">
	<c:if test="${list != null }">
		<b>글목록</b>
		<table border="1" width="700" cellpadding="0" cellspacing="0"
			>
			<tr height="30" id="boardhead">
				<td align="center" width="55">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">작성자</td>
				<td align="center" width="150">작성일</td>
				<td align="center" width="100">조회/추천</td>
				
			</tr>


			<c:forEach var="vo" items="${list }">
				<tr height="30">
					<td width="50">${vo.seq }</td>
					<td width="250">${vo.title }</td>
					<td align="center" width="100">${vo.name }</td>
					<td align="center" width="150">${vo.regDate }</td>
					<td align="center" width="50">${vo.cnt }/${vo.best }</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>

	
	<script>
	$(document).ready(function(){
		$("#afterBoardListReport_xlsx").click(function() {
			
			location.href="afterBoardListReport_xlsx.do";
			
		});
	});
	$(document).ready(function(){
		$("#afterBoardListReport_xls").click(function() {
			
			location.href="afterBoardListReport_xls.do";
			
		});
	});
	$(document).ready(function(){
		$("#afterBoardListReport_pdf").click(function() {
			
			location.href="afterBoardListReport_pdf.do";
			
		});
	});
	</script>
</body>
</html>
