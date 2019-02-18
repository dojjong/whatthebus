<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>메인화면</title>
<link href="../resources/css/mainStyle.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link type="text/css" rel="stylesheet" href="../resources/css/loginStyle.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>





  <style>




 .carousel-inner img {
    width: 50%; /* Set width to 100% */
    margin: auto;
  }
  .carousel-caption h3 {
    color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }
  

  </style>


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


	<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="../resources/images/ad_main_01.png">
        <div class="carousel-caption">
          <h3>전세버스가 필요할 땐? What the bus!!</h3>
          <p>왓더버스는 편리한 절차로 인등된 기사님과 연결하여<br>
          	실시간 비교견적으로 전세버스 대절이 가능합니다.</p>
        </div>      
      </div>

      <div class="item">
        <img src="../resources/images/ad_main_02.png">
        <div class="carousel-caption">
          <h3>왓더버스!</h3>
          <p>기사회원 모집중.</p>
        </div>      
      </div>
    
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>






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