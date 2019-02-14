<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../main/mainHeader.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />

<script>
	$(document).ready(
			function() {

				listReply2(); //Json 리턴 방식

				//댓글 쓰기 버튼 클릭 이벤트(ajax로 처리)
				$("#btnReply").click(
						function() {

							var replyText = $("#replyText").val();

							var seq = "${vo.seq}"
							var name = "${vo.name}"
							var id = "${member.id }";
							var param = "replyText=" + replyText + "&seq="
									+ seq + "&name=" + name + "&id=" + id;
							
							$.ajax({
								type : "post",
								url : "insertReply.do",
								data : param,
								success : function() {
									alert("댓글이 등록되었습니다");
									listReply();
								},
								error : function(request, status, error) {
									alert("code=" + request.status
											+ " message="
											+ request.responseText + " error="
											+ error);
								}

							});
						});

				$("#btnDelete").click(function() {
					if (confirm("삭제하시겠습니까?")) {
						document.contentForm.action = "deleteAfterBoard.do";
						document.contentForm.submit();
						return;
					} else {
						return;
					}
				});
			});

	//Controller방식
	//댓글 목록1
	function listReply() {

		$.ajax({
			type : "post",
			url : "getReplyList.do?seq=${vo.seq}",
			success : function(data) {
				//responseText가 result에 저장됨
				$("#listReply").html(result);

			},
			error : function(request, status, error) {
				alert("code=" + request.status + " message="
						+ request.responseText + " error=" + error);
			}

		});
		
	}

	//RestController방식(Json)
	//댓글 목록2(json)
	function listReply2() {
		$.ajax({
			type : "get",
			//contentType:"application/json", ==>생략가능(RestController이기 때문에 가능

			url : "getReplyListJson.do?seq=${vo.seq}",
			success : function(result) {

				var output = "<table>";

				for ( var i in result) {
					alert(result.length);
					output += "<tr>";

					output += "<td style='width: 500px; text-align: center;'>";

					output += "(" + result[i].condition + ")<br>";

					output += result[i].count + "</td>";
					output += "</tr>";
				}
				output += "</table>";
				$("#chart1div").html(output);
			}
		});
	}

	//날짜 변환 함수 작성
	function changeDate(date) {

		ddate = new Date(parseInt(date));
		year = ddate.getFullYear();
		month = ddate.getMonth();
		day = ddate.getDate();
		hour = ddate.getHours();
		minute = ddate.getMinutes();
		second = ddate.getSeconds();
		strDate = year + "-" + month + "-" + day + " " + hour + " : " + minute
				+ " : " + second;
		return strDate;
	}
</script>

</head>
<body>
	<form method="post" name="contentForm">
		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" /> <input
			type="hidden" name="seq" id="seq" value="${vo.seq }" />
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
							<a href="updateAfterForm.do?seq=${vo.seq }"> <input
								type="button" class="contentbt" id="btnUpdate" value="수정"></a>
							<!-- 글쓴이만 이 버튼이 보이도록 코드 수정 -->
							<input type="button" class="contentbt" id="btnDelete" value="삭제">
						</c:when>
					</c:choose> <a href="getAfterBoardList.do"> <input type="button"
						class="contentbt" value="목록"></td>
			</tr>
		</table>
	</form>
	<table width="500px" align="center">
		<tr>
			<td width="500px">
				<div style="width: 500px; text-align: center;">
					<!-- 로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
					<!--<c:if test="${member.id!=null}">-->
					<textarea witdh="500px" rows="5" cols="66" id="replyText"
						placeholder="댓글을 작성해주세요"></textarea>
					<br>
					<button type="button" id="btnReply">댓글작성</button>
					<!--</c:if>-->
				</div style="width: 500px; text-align: center;"> <!-- 댓글을 출력할 위치 -->
				<div id="listReply" style="width: 500px; text-align: center;"></div>
			</td>
		</tr>
	</table>
	<div id="chart1div"></div>

	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>