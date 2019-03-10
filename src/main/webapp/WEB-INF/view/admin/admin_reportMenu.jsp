<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#chartdiv {
	width: 100%;
	height: 500px;
}
</style>

</head>
<body>


	
	<!-- 모든 레포트는 여기서 나올 예정 -->
	<!-- 모든 차트는 여기서 나올 예정 -->
		<!-- 모든 레포트는 여기서 나올 예정 -->
	<div id="reportdiv">
	
	
<!-- 레포트선택하기  -->
	<form id="report">
		<table>

			<tr>
				<td align="center">기사님 별 별점 순위 리스트&nbsp;</td>
				<td>
					<input type="button" id="report1viewbt" value="미리보기" />&nbsp;
					<input type="button" id="report1excelbt" value="엑셀로" />&nbsp;
					<input type="button" id="report1pdfbt" value="pdf로" />&nbsp;<br>
				</td>
			</tr>
			<tr>
				<td align="center">상품 리스트&nbsp;</td>
				<td>
					<input type="button" id="report2viewbt" value="미리보기" />&nbsp;
					<input type="button" id="report2excelbt" value="엑셀로" />&nbsp;
					<input type="button" id="report2pdfbt" value="pdf로" />&nbsp;
				</td>	
				<td align="center"> * 검색조건</td>
				<td><input type="date" id="startdate">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="date" id="enddate"></td>
			
			<tr>
				<td align="center">추천 임박 리스트&nbsp;</td>
				<td>
					<input type="button" id="report3viewbt" value="미리보기" />&nbsp;
					<input type="button" id="report3excelbt" value="엑셀로" />&nbsp;
					<input type="button" id="report3pdfbt" value="pdf로" />&nbsp;
				</td>
			</tr>
		</table>
	</form>
	
	<c:if test="${list1 != null }">
		<b>글목록</b>
		<table border="1" width="700" cellpadding="0" cellspacing="0">
			<tr height="30" id="boardhead">
				<td align="center" width="55">순위</td>
				<td align="center" width="250">기사명</td>
				<td align="center" width="100">평균별점</td>
				<td align="center" width="150">건수</td>
				<td align="center" width="100">등급</td>
				
			</tr>
			<c:forEach var="vo" items="${list1 }">
				<tr height="30">
					<td width="50">${vo.rank }</td>
					<td width="250">${vo.drivername }</td>
					<td align="center" width="100">${vo.avg }</td>
					<td align="center" width="150">${vo.count}</td>
					<td align="center" width="50">${vo.grade }</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${list2 != null }">
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
			<c:forEach var="vo" items="${list2 }">
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
	</c:if>
	<c:if test="${list3 != null }">
		<b>글목록</b>
		<table border="1" width="700" cellpadding="0" cellspacing="0">
			<tr height="30" id="boardhead">
				<td align="center" width="55">번호</td>
				<td align="center" width="250">제목</td>
				<td align="center" width="100">이름</td>
				<td align="center" width="150">현재추천수</td>
				<td align="center" width="150">목표추천수</td>
				<td align="center" width="150">부족추천수</td>
			</tr>
			<c:forEach var="vo" items="${list3 }">
				<tr height="30">
					<td width="50">${vo.seq }</td>
					<td width="250">${vo.title }</td>
					<td align="center" width="100">${vo.name }</td>
					<td align="center" width="150">${vo.best}</td>
					<td align="center" width="150">${vo.bestgoal }</td>
					<td align="center" width="150">${vo.bestgoal - vo.best}</td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	
	<script>
	// 레포트1
	$(document).ready(function(){
		$("#report1viewbt").click(function() {
			//location.href="getReviewListPerDriver.do?";
			
			$.ajax({
				type : "get",
				//data : param,
				url : "getReviewListPerDriver.do",
				success : function(result) {
					//alert('성');
					$("#reportdiv").load("getReviewListPerDriver1.do");
				},
				error : function(
						request,
						status,
						error) {
					alert("code="
							+ request.status
							+ " message="
							+ request.responseText
							+ " error="
							+ error);
				}

			});
	
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
			var param = "startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate").value;
			var url = "getBookBoardListReport1.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate").value;
			$.ajax({
				type : "get",
				data : param,
				url : "getBookBoardListReport.do",
				success : function(result) {
					//alert('성');
					$("#reportdiv").load(url);
				},
				error : function(
						request,
						status,
						error) {
					alert("code="
							+ request.status
							+ " message="
							+ request.responseText
							+ " error="
							+ error);
				}

			});
	
		});
	});
	$(document).ready(function(){
		$("#report2excelbt").click(function() {
			if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
				alert('검색 날짜를 입력해주세요');
				return;
			}
			var url ="getBookBoardListReport.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate").value+"&view=excel";
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
			var url ="getBookBoardListReport.do?startdate="+document.getElementById("startdate").value+"&enddate="+document.getElementById("enddate").value+"&view=pdf"; 
			//alert(url);
			location.href=url;
		});
	});

	// 레포트3
	$(document).ready(function(){
		$("#report3viewbt").click(function() {
			//location.href="getHotBoardMove.do?";
			
			$.ajax({
				type : "get",
				//data : param,
				url : "getHotBoardMove.do",
				success : function(result) {
				//	alert('성');
					$("#reportdiv").load("getHotBoardMove1.do");
				},
				error : function(
						request,
						status,
						error) {
					alert("code="
							+ request.status
							+ " message="
							+ request.responseText
							+ " error="
							+ error);
				}

			});
		});
	});
	
	$(document).ready(function(){
		$("#report3excelbt").click(function() {
			location.href="getHotBoardMove.do?view=excel";
		});
	});
	$(document).ready(function(){
		$("#report3pdfbt").click(function() {
			location.href="getHotBoardMove.do?view=pdf";
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
