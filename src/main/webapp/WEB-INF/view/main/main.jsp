<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link href="../resources/css/mainStyle.css" rel="stylesheet"
	type="text/css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="../resources/css/loginStyle.css">

</head>

<body>


	<!-- 여기까지 메뉴 -->


	<!-- 여기부터 광고
<aside id="right">
<table class="right_tab">
<tr>
<td>
관심리스트(찜)
<ul>
<li>1.일찜</li>
<li>2.이찜</li>
<li>3.삼찜</li>
</ul>
</td>
</tr>

<tr>
<td>
<a href="#"><img src="images/ad.jpg"/></a>
</td>
</tr>
<tr>
<td>
<a href="#"><img src="images/ad.jpg"/></a>
</td>
</tr>

</table>
</aside>
-->
	<div align="center">
		<table>
			<tr>
				<td class="mainSubTitle">HOT 설문</td>
				<td class="mainSubTitle">마감임박!!</td>
				<td class="mainSubTitle">최근 제의</td>
			</tr>
			<tr>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값  : HOT설문-->
				</td>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 마감임박!! -->
				</td>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 최근 제의 -->
				</td>
			</tr>
			<tr>
				<td class="mainSubTitle">예비1</td>
				<td class="mainSubTitle">예비2</td>
				<td class="mainSubTitle">예비3</td>
			</tr>
			<tr>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 예비 1 -->
				</td>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 예비 2 -->
				</td>
				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 예비3-->
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>