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
getReviewListPerDriver
<!-- 레포트선택하기  -->
	<form id="reportform">
		<table>
			<tr>
				<td align="center">검색조건</td>
				<td><input type="date" id="startdate">&nbsp;&nbsp;~&nbsp;&nbsp;<input
					type="date" id="enddate"></td>
			</tr>
			<tr>
				<td align="center">기사님 별 별점 순위 리스트&nbsp;</td>
				<td>
					<input type="button" id="report1viewbt" value="미리보기" />&nbsp;
					<input type="button" id="report1excelbt" value="엑셀로" />&nbsp;
					<input type="button" id="report1pdfbt" value="pdf로" />&nbsp;
				</td>
			</tr>
			<tr>
				<td align="center">상품 리스트&nbsp;</td>
				<td>
					<input type="button" id="report2viewbt" value="미리보기" />&nbsp;
					<input type="button" id="report2excelbt" value="엑셀로" />&nbsp;
					<input type="button" id="report2pdfbt" value="pdf로" />&nbsp;
				</td>
			</tr>
		</table>
	</form>

	
	<!-- 모든 레포트는 여기서 나올 예정 -->
	<div id="reportdiv">
	<c:if test="${map.list != null }">
		<c:choose>
			<c:when  test="${map.reportname eq '1' }">
				<b>글목록</b>
				<table border="1" width="700" cellpadding="0" cellspacing="0">
					<tr height="30" id="boardhead">
						<td align="center" width="55">순위</td>
						<td align="center" width="250">기사명</td>
						<td align="center" width="100">평균별점</td>
						<td align="center" width="150">건수</td>
						<td align="center" width="100">등급</td>
						
					</tr>
					<c:forEach var="vo" items="${list }">
						<tr height="30">
							<td width="50">${vo.rank }</td>
							<td width="250">${vo.drivername }</td>
							<td align="center" width="100">${vo.avg }</td>
							<td align="center" width="150">${vo.count}</td>
							<td align="center" width="50">${vo.grade }</td>
							
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:when test="${map.reportname eq '2' }">
				<b>글목록</b>
				<table border="1" width="700" cellpadding="0" cellspacing="0">
					<tr height="30" id="boardhead">
						<td align="center" width="55">번호</td>
						<td align="center" width="250">상품명</td>
						<td align="center" width="100">등록일</td>
						<td align="center" width="150">차량</td>
						<td align="center" width="100">가격</td>
						<td align="center" width="100">시작일</td>
					</tr>
					<c:forEach var="vo" items="${map.list }">
						<tr height="30">
							<td width="50">${vo.num }</td>
							<td width="250">${vo.title }</td>
							<td align="center" width="100">${vo.regdate }</td>
							<td align="center" width="150">${vo.bus}</td>
							<td align="center" width="50">${vo.pay }</td>
							<td align="center" width="50">${vo.realstartdate }</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
			
			</c:otherwise>
		</c:choose>
	</c:if>
	</div>

	
	<script>
	// 레포트1
	$(document).ready(function(){
		$("#report1viewbt").click(function() {
			location.href="getReviewListPerDriver.do?";
		});
	});
	$(document).ready(function(){
		$("#report1excelbt").click(function() {
			location.href="getReviewListPerDriver.do?view=excel";
		});
	});
	$(document).ready(function(){
		$("#report1pdfbt").click(function() {
			location.href="getReviewListPerDriver.do?view=pdf";
		});
	});
	
	//레포트2
	$(document).ready(function(){
		$("#report2viewbt").click(function() {
			if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
				alert('검색 날짜를 입력해주세요');
				return;
			}
			var url = "getBookBoardListReport.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate");
			alert(url);
			location.href=url;
		});
	});
	$(document).ready(function(){
		$("#report2excelbt").click(function() {
			if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
				alert('검색 날짜를 입력해주세요');
				return;
			}
			var url ="getBookBoardListReport.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate")+"&view=excel";
			alert(url);
			location.href=url;
		});
	});
	$(document).ready(function(){
		$("#report2pdfbt").click(function() {
			if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
				alert('검색 날짜를 입력해주세요');
				return;
			}
			var url ="getBookBoardListReport.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate")+"&view=pdf"; 
			alert(url);
			location.href=url;
		});
	});

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
