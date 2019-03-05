<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="../resources/css/adminStyle.css" />
</head>


<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=clusterer"></script>
<!-- chart Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>


<!-- 사이드 메뉴 -->

	<div class="sidenav">
		<button class="dropdown-btn">
			통계 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a id="p3">차트</a> <a id="p5">보고서</a> <a href="#"
				id="p7">지도</a>
		</div>
		<button class="dropdown-btn">
			회원관리 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a href="#" id="p1">전체회원목록</a> <a href="#" id="m1">회원목록</a> <a
				href="#" id="d1">기사목록</a> <a href="#" id="p2">가입승인(기사)</a> <a
				href="#" id="a1">관리자설정</a>
		</div>
		<button class="dropdown-btn">
			기타 <i class="fa fa-caret-down"></i>
		</button>
		<div class="dropdown-container">
			<a href="#" id="p8">메인화면 게시글 수 변경</a> <a href="#" id="p6">메인배너이미지
				변경</a> <a href="#" id="p4">추천수 변경</a>
		</div>

	</div>

<!-- 사이드 메뉴 -->


	<div class="main">

		<table width="1000" id="header">
			<tr>
				<td width="200" align="center"><a href="main.do"><img
						src="../resources/images/admin_logo.png" id="gogo"></a></td>
				<td align="center"><h1>
						<b>WHAT THE BUS 관리자 페이지</b>
					</h1></td>

			</tr>
			<tr>
				<td align="right" colspan="2"><b>${member.name }님 환영합니다.&nbsp;</b></td>
			</tr>

		</table>
		<div id="result"></div>

	</div>

	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display === "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";
				}
			});
		}
	</script>



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
				$("#result").load("getAdminReportMenu.do?");

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
		$(document).ready(function() {
			$("#p7").click(function() {
				$("#result").load("getStartMapCluster.do");

			});

		});
		$(document).ready(function() {
			$("#p8").click(function() {
				$("#result").load("moveSetMainCount.do");

			});

		});
	</script>




</body>
</html>