<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인화면</title>

<link href="../resources/css/mainStyle.css" rel="stylesheet"
	type="text/css">


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

		<div id="arrayBanner"></div>

		<br>


	</div>




	<!-- 테이블 -->
	<div align="center">
		<jsp:include page="../main/main_banner_center.jsp"></jsp:include>
		<%-- <div>
			<img
				src="../resources/images/129603e0-a560-4524-b662-e33bfe2e30cb_bus.png"
				style="width: 80%">
		</div>
		--%>




		<table>
			<tr>
				<td class="mainSubTitle">공지사항</td>
				<td class="mainSubTitle">HOT 제의</td>

			</tr>
			<tr>
				<td class="mainSubValue"><c:forEach var="vo"
						items="${noticeList }" varStatus="status">
						${status.count}<a
							href="getNoticeBoard.do?seq=${vo.seq}&&id=${member.id}">
							${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>

				<td class="mainSubValue"><c:forEach var="vo"
						items="${hotList }" varStatus="status">
						${status.count}<a
							href="getBoard.do?seq=${vo.seq}&&id=${member.id}"> ${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>


			</tr>
			<tr>

				<td class="mainSubTitle">최근 제의</td>
				<td class="mainSubTitle">출발마감임박!!</td>

			</tr>
			<tr>
				<td class="mainSubValue"><c:forEach var="vo"
						items="${finishTimeList }" varStatus="status">
						${status.count}<a
							href="getBookBoard.do?seq=${vo.seq}&&id=${member.id}">
							${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>
				<td class="mainSubValue"><c:forEach var="vo"
						items="${recentList }" varStatus="status">
						${status.count}<a
							href="getBoard.do?seq=${vo.seq}&&id=${member.id}"> ${vo.title }</a>
						&nbsp;<br />
					</c:forEach></td>


				<td class="mainSubValue">
					<!-- 디비에서 불러올 값 : 예비3-->
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="../main/mainFooter.jsp"></jsp:include>

	<script>
		window.onload = function() {

			var list = document.getElementsByName("listSpan");
			var value = [];
			for (var i = 0; i < list.length; i++) {
				// alert(list[i].innerHTML);
				var jbSplit = list[i].innerHTML.split('/');
				for ( var k in jbSplit) {
					value[i] = jbSplit[k];
				}

			}
			document.getElementById('arrayBanner').innerHTML = "";
			for (var j = 0; j < value.length; j++) {
				alert(value[j]);
				document.getElementById('arrayBanner').innerHTML += "<div class='mySlides fade'><img src='../resources/images/"
						+ value[j] + "' style='width:80%'></div>";
			}
		}
	</script>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">



</body>
</html>