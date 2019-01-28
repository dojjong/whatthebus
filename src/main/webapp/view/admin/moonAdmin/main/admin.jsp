<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<!DOCTYPE html>
<html>
<title>관리자페이지</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Inconsolata">
<style>
body, html {
	height: 100%;
	font-family: "Inconsolata", sans-serif;
}

.bgimg {
	background-position: center;
	background-size: cover;
	background-image: url("../images/WhatTheBusAdmin.png");
	min-height: 75%;
}

.menu {
	display: none;
}
</style>
<body>

	<!-- Links (sit on top) -->
	<div class="w3-top">
		<div class="w3-row w3-padding w3-black">
			<div class="w3-col s3">
				<a href="#" class="w3-button w3-block w3-black">HOME</a>
			</div>
			<div class="w3-col s3">
				<a href="#memberManager" class="w3-button w3-block w3-black">회원관리</a>
			</div>
			<div class="w3-col s3">
				<a href="#statistics" class="w3-button w3-block w3-black">통계</a>
			</div>
			<div class="w3-col s3">
				<a href="#notice" class="w3-button w3-block w3-black">공지/Q&A</a>
			</div>
		</div>
	</div>

	<!-- Header with image -->
	<header class="bgimg w3-display-container w3-grayscale-min" id="home">
		<div
			class="w3-display-bottomleft w3-center w3-padding-large w3-hide-small">
			<span class="w3-tag">관리자 페이지 담당자 : 문영식</span>
		</div>
		<div class="w3-display-bottomright w3-center w3-padding-large">
			<span class="w3-tag"> <%
 	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy년MM월dd일");
 	String today = formatter.format(new java.util.Date());
 	out.println("오늘은 " + today + " 입니다.");
 %>
			</span>
		</div>
	</header>

	<!-- 배경색 -->
	<div class="w3-sand w3-grayscale w3-large">
		<!-- 회원관리 -->
		<div class="w3-container" id="memberManager">
			<div class="w3-content" style="max-width: 1200px">

				<h5 class="w3-center w3-padding-48">
					<span class="w3-tag w3-wide">회원관리</span>
				</h5>

				<div class="w3-row w3-center w3-card w3-padding">
					<a href="javascript:void(0)"
						onclick="openMenu(event, 'deleteMember');">
						<div class="w3-col s6 tablink">회원삭제</div>
					</a> <a href="javascript:void(0)"
						onclick="openMenu(event, 'insertDriverConfirm ');">
						<div class="w3-col s6 tablink">기사가입 승인</div>
					</a>
				</div>

				<div id="deleteMember"
					class="w3-container menu w3-padding-48 w3-card">

					<div align="center">
						<form method="post" action="deleteMember.do">
							<input type="hidden" name="check" value="" />
							<table>
								<tr>
									<td align="right">탈퇴할 아이디 : &nbsp;</td>
									<td align="left"><input type="text" name="" value="" /></td>
								</tr>

								<tr>
									<td colspan="2" align="center"><input type="submit"
										class="insertbt" value="회원탈퇴" /> <input type="button"
										class="insertbt" value="취소" onclick="" /></td>
								</tr>
								<div align="center">*회원 아이디를 입력하여 회원탈퇴 가능합니다.*</div>
							</table>
						</form>
					</div>
				</div>

				<div id="insertDriverConfirm "
					class="w3-container menu w3-padding-48 w3-card">
					<div align="center">
						<hr width="700">
						<table border="1" cellspacing="0" width="700">
							<tr>
								<th width="50">번호</th>
								<th width="500">신청자</th>
								<th width="150">가입신청일</th>
							</tr>
							<c:forEach items="${waitingForJoinList }" var="waitingForJoin">
								<tr>
									<th>${waitingForJoin.seq }</th>
									<th><a href="waitingForJoin.do?seq=${waitingForJoin.seq }">${waitingForJoin.name }</a></th>
									<th>${waitingForJoin.regDate }</th>
								</tr>
							</c:forEach>
						</table>
						<br>
					</div>
				</div>

			</div>
		</div>

		<hr style="border: solid 1px gray;">

		<!-- 통계 -->
		<div class="w3-container" id="statistics">
			<div class="w3-content" style="max-width: 1200px">

				<h5 class="w3-center w3-padding-48">
					<span class="w3-tag w3-wide">통계</span>
				</h5>

				<div class="w3-row w3-center w3-card w3-padding">
					<a href="javascript:void(0)" onclick="openMenu(event, 'SexRatio');">
						<div class="w3-col s6 tablink">남자/여자</div>
					</a> <a href="javascript:void(0)"
						onclick="openMenu(event, 'MemberTypeRatio');">
						<div class="w3-col s6 tablink">회원유형</div>
					</a>
				</div>

				<div id="SexRatio" class="w3-container menu w3-padding-48 w3-card">
					남녀성비 퍼센트 차트 삽입</div>

				<div id="MemberTypeRatio"
					class="w3-container menu w3-padding-48 w3-card">일반회원 기사회원 퍼센트
					차트 삽입</div>
			</div>
		</div>

		<hr style="border: solid 1px gray;">

		<!-- 관리자 게시물 관리 -->
		<div class="w3-container" id="notice">
			<div class="w3-content" style="max-width: 1200px">

				<h5 class="w3-center w3-padding-48">
					<span class="w3-tag w3-wide">관리자 게시물 관리</span>
				</h5>

				<div class="w3-row w3-center w3-card w3-padding">
					<a href="javascript:void(0)" onclick="openMenu(event, 'Notice');">
						<div class="w3-col s6 tablink">공지사항</div>
					</a> <a href="javascript:void(0)" onclick="openMenu(event, 'QandA');">
						<div class="w3-col s6 tablink">Q&A</div>
					</a>
				</div>

				<div id="Notice" class="w3-container menu w3-padding-48 w3-card">
					<div align="center">
						<hr width="700">
						<table border="1" cellspacing="0" width="700">
							<tr>
								<th width="50">번호</th>
								<th width="500">제목</th>
								<th width="150">등록일</th>
							</tr>
							<c:forEach items="${noticeList }" var="notice">
								<tr>
									<th>${notice.seq }</th>
									<th><a href="getBoard.do?seq=${notice.seq }">${notice.title }</a></th>
									<th>${notice.regDate }</th>
								</tr>
							</c:forEach>
						</table>
						<br>
						<Button type="button" onclick="location='insertBoard.jsp'">공지추가</Button>
					</div>
				</div>

				<div id="QandA" class="w3-container menu w3-padding-48 w3-card">
					<div align="center">
						<hr width="700">
						<table border="1" cellspacing="0" width="700">
							<tr>
								<th width="50">번호</th>
								<th width="500">제목</th>
								<th width="150">등록일</th>
							</tr>
							<c:forEach items="${qnaList }" var="qna">
								<tr>
									<th>${qna.seq }</th>
									<th><a href="getBoard.do?seq=${qna.seq }">${qna.title }</a></th>
									<th>${qna.regDate }</th>
								</tr>
							</c:forEach>
						</table>
						<br>
						<Button type="button" onclick="location='insertQNA.jsp'">Q&A추가</Button>
					</div>
				</div>
			</div>
		</div>
		<hr style="border: solid 1px gray;">

		<!-- End page content -->
	</div>

	<!-- Footer -->
	<footer class="w3-center w3-light-grey w3-padding-48 w3-large">
		<p>
			Powered by <a href="http://localhost:8080/bus/view/main/main.jsp"
				title="W3.CSS" target="_blank" class="w3-hover-text-green">Moon</a>
		</p>
	</footer>

	<script>
		// Tabbed Menu
		function openMenu(evt, menuName) {
			var i, x, tablinks;
			x = document.getElementsByClassName("menu");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < x.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" w3-dark-grey", "");
			}
			document.getElementById(menuName).style.display = "block";
			evt.currentTarget.firstElementChild.className += " w3-dark-grey";
		}
	</script>
</body>
</html>
