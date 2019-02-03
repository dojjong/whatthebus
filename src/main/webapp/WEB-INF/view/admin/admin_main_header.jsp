<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>What The Bus 관리자화면</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
</head>




<style type="text/css">

.menubar {
	
	font: 67.5% "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;
	font-size: 14px;
	font-weight: bold;
	
}

.menubar ul {
	background: rgb(22, 72, 151);
	height: 50px;
	list-style: none;
	margin: 0px;
	padding: 0;
}

.menubar li {
	float: left;
	margin-left: 10px;
	padding: 0px;
}

.menubar li a {
	background: rgb(22, 72, 151);
	color: #cccccc;
	display: block;
	font-weight: normal;
	line-height: 50px;
	margin: 0px 20px;
	padding: 0px 20px;
	text-align: center;
	text-decoration: none;
}

.menubar li a:hover, .menubar ul li:hover a {
	background: rgb(49, 100, 176);
	color: #FFFFFF;
	text-decoration: none;
}

.menubar li ul {
	background: rgb(49, 100, 176);
	display: none; /* 평상시에는 드랍메뉴가 안보이게 하기 */
	height: auto;
	padding: 0px;
	margin: 0px 20px; /*내려오는 메뉴 마진*/
	border: 0px;
	position: absolute;
	width: 200px;
	z-index: 200;
	/*top:1em;
/*left:0;*/
}

.menubar li:hover ul {
	display: block; /* 마우스 커서 올리면 드랍메뉴 보이게 하기 */
}

.menubar li li {
	background: rgb(49, 100, 176);
	display: block;
	float: none;
	margin: 0px;
	padding: 0px;
	width: 200px;
}

.menubar li:hover li a {
	background: none;
}

.menubar li ul a {
	display: block;
	height: 50px;
	font-size: 12px;
	font-style: normal;
	margin: 0px;
	padding: 0px 10px 0px 15px;
	text-align: left;
}

.menubar li ul a:hover, .menubar li ul li:hover a {
	background: rgb(22, 72, 151);
	border: 0px;
	color: #ffffff;
	text-decoration: none;
}

.menubar p {
	clear: left;
}

/* 여기까지 메뉴 */

</style>
</head>
<body>




	<div class="container" align="center">
		<header id="header">
		
		
		<table>
			
					<%-- 세션에 저장된 값이 있으면 보여지는 화면 --%>
			<%-- 라이센스가 null이냐 아니냐로 보여지는 화면 구분 --%>
			<c:choose>
				<c:when test="${member ne null }">
					<c:if test="${member.license==null }">


						<div align="right">
							<table>
								<tr>
									<td>${member.name }회원님환영합니다.&nbsp;</td>
									<!-- 
									<td><form method="post"
											action="../member/pwCheckMember.jsp">
											<input type="submit" value="비밀번호 변경" class="mainbt">
										</form></td>
									<td><form method="post"
											action="../member/updateCheckMember.jsp">
											<input type="submit" value="회원정보 수정" class="mainbt">
										</form></td>
									<td><form method="post" action="logoutMember.do">
											<input type="submit" value="로그아웃" class="mainbt">
										</form></td>
										 -->
							</table>
						</div>
					</c:if>

					<c:if test="${member.license!=null }">
						<div align="right">
							<table>
								<tr>
									<td width="90px" align="center"><a href="../driver/driverMypage.jsp">마이페이지</a></td>
									<td width="150px" align="center">${member.name }기사님<br>환영합니다.</td>
									<td><form method="post" action="logoutDriver.do"><input type="submit" value="로그아웃" class="btn btn-link"></form></td>
									
									<!-- 
									<td><form method="post"
											action="../driver/pwCheckDriver.jsp">
											<input type="submit" value="비밀번호 변경" class="mainbt">
										</form></td>
									<td><form method="post"
											action="../driver/updateCheckDriver.jsp">
											<input type="submit" value="회원정보 수정" class="mainbt">
										</form></td>
									<td><form method="post" action="logoutDriver.do">
											<input type="submit" value="로그아웃" class="mainbt">
										</form></td>
									 -->	
							</table>
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
	
				</c:otherwise>
			</c:choose>
			
			
	
			
</table>
			

	


			<div class="menubar">
				<ul>
					<li><a href="#">통계(임시)</a>
						<ul>
							<li><a href="../admin/admin_chart.jsp" >차트(임시)</a></li>
							<li><a href="#" >보고서(임시)</a></li>
							<li><a href="../admin/admin_map.jsp" >지도(임시)</a></li>
						</ul></li>
					<li><a href="#">기사님인증(임시)</a>
						<ul>
							<li><a href="#">기사님인증용게시판(임시)</a></li>
						</ul></li>
					<li><a href="#">결제용(임시)</a>
						<ul>
							<li><a href="#" >(임시:결제화면)</a></li>
						</ul></li>
				</ul>
			</div>
		</header>
	</div>
	<!-- container -->

	

</body>
</html>