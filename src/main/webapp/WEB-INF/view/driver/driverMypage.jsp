<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<style>
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
<meta charset="EUC-KR">
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
				<li><a href="moveUpdateCheckDriver.do">회원정보수정</a></li>
				<li><a href="movePwCheckDriver.do">비밀번호변경</a></li>
				<li><a href="moveDeleteDriver.do">회원탈퇴</a></li>
			</ul>
		</nav>
	</aside>
	</td>
	<td>
	
	</td>
	
	</tr>
	
</table>
</div>
</div>
	
	<footer>
		<jsp:include page="../main/mainFooter.jsp"></jsp:include>
	</footer>
</body>
</html>