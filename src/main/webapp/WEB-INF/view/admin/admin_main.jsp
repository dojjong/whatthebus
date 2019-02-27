<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../admin/admin_main_header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<style>

/* 빨간선-확인용 삭제 할겁니다!*/
div {
	border: 1px solid red;
}

table {
	border: 1px solid red;
}

tr {
	border: 1px solid red;
}

td {
	border: 1px solid red;
}
/* 구간 확인용 삭제 할겁니다!*/
nav {
	color: black;
	margin-top: 10px;
}

@
mypageul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 100px;
	background-color: #f1f1f1;
}

li a {
	display: block;
	font-color: black;
	padding: 8px 8px;
	text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
	background-color: rgb(49, 100, 176);
	color: white;
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<div>
			<table width="1024px">

				<tr>
					<td width="200px">
						<aside id="left">
							<nav>
								<ul style="list-style-type: none;" id="mypageul">
									<li><a href="#">통계</a></li>
									<li><a id="p3">- 차트(임시)</a></li>
									<li><a id="p5">- 보고서(임시)</a></li>
									<li><a href="#">- 지도(임시)</a></li>
									<li><a href="#">회원관리</a></li>
									<li><a href="#" id="p1">- 전체회원목록</a></li>
									<li><a href="#" id="m1">- 회원목록</a></li>
									<li><a href="#" id="d1">- 기사목록</a></li>
									<li><a href="#" id="p2">- 가입승인대기(드라이버)</a></li>
									<li><a href="#" id="a1">- 관리자 설정</a></li>
									<li><a href="#">결제</a></li>
									<li><a href="#">- 결제화면</a></li>
									<li><a href="#" id="p4">게시판 추천수 변경</a></li>
									<li><a href="report1.do">임시</a></li>
									<li><a href="#">임시</a></li>
									<li><a href="#" id="p6">메인센터배너변경</a></li>
								</ul>
							</nav>
						</aside>
					</td>

					<td id="result"></td>

				</tr>



			</table>
		</div>
	</div>







	<script>
		//전체회원목록 불러오기
		$(document).ready(function() {
			$("#p1").click(function() {
				$("#result").load("getAllMemberList.do");

			});

		});
		//멤버목록 불러오기
		$(document).ready(function() {
			$("#m1").click(function() {
				$("#result").load("getMemberList.do");
			});
		});
		//기사목록 불러오기
		$(document).ready(function() {
			$("#d1").click(function() {
				$("#result").load("getDriverList.do");
			});
		});
		//가입승인 대기중인 기사목록 불러오기
		$(document).ready(function() {
			$("#p2").click(function() {
				$("#result").load("moveApprovalDriverList.do");

			});

		});

		$(document).ready(function() {
			$("#p3").click(function() {
				$("#result").load("getAdminChartMenu.do");

			});

		});
		//추천수 변경
		$(document).ready(function() {
			$("#p4").click(function() {
				$("#result").load("moveSetBestCount.do");

			});

		});

		$(document).ready(function() {
			$("#p5").click(function() {
				$("#result").load("afterBoardListReport_jsp.do");

			});

		});

		$(document).ready(function() {
			$("#p6").click(function() {
				$("#result").load("admin_banner.do");

			});
		});
		$(document).ready(function() {
			$("#a1").click(function() {
				$("#result").load("selectAdmin.do");

			});
		});
		$(document).ready(function(){
			$("#p7").click(function() {
				$("#result").load("getStartMapCluster.do");
				
			});
			
		});
	</script>









</body>
</html>