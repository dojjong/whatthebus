<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 위</title>
<link type="text/css" rel="stylesheet" href="../css/mainStyle.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="page">
		<header id="header">
			<div align="right">
				<a href="../login/login.jsp"> <input type="button" value="로그인"
					class="mainbt">
				</a> <a href="../join/insertMember.jsp"> <input type="button"
					value="회원가입" class="mainbt">
				</a>
			</div>
			<a><img src="../images/main_logo.jpg" id="gogo"></a>

			<div class="menubar">
				<ul>
					<li><a href="#">소개</a>
						<ul>
							<li><a href="idSearch.html" target="iframe">사이트소개(임시:id찾기
									화면)</a></li>
							<li><a href="idCheck.html" target="iframe">이용가이드(임시:id찾기
									완료창)</a></li>
						</ul></li>
					<li><a href="#">커뮤니티</a>
						<ul>
							<li><a href="../join/insertDriver.html" target="iframe">기사님
									회원가입 화면</a></li>
							<li><a href="../join/insertMember.html" target="iframe">손님
									회원가입 화면</a></li>
							<li><a href="../join/insertMemberCheck.html" target="iframe">회원가입
									완료화면</a></li>
						</ul></li>
					<li><a href="#">제안</a>
						<ul>
							<li><a href="../pay/payForm.html" target="iframe">정기권제안(임시:결제화면)</a></li>
							<li><a href="#">단기권제안()</a></li>
						</ul></li>
					<li><a href="#">예약</a>
						<ul>
							<li><a href="../border/list.html" target="iframe">자유게시판(임시:게시판글)</a></li>
							<li><a href="../border/writeForm.html" target="iframe">수요조사(임시:글쓰기화면)</a></li>
							<li><a href="../border/content.html" target="iframe">후기(임시:게시글보기화면)</a></li>
						</ul></li>
					<li><a href="#">고객센터</a>
						<ul>
							<li><a href="#">Q&A</a></li>
							<li><a href="#">분실물서비스</a></li>
							<li><a href="#">ContactUs</a></li>
						</ul></li>
					<li><a href="#">공지사항</a>
						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">이벤트</a></li>
						</ul></li>
				</ul>
		</header>
	</div>

</body>
</html>