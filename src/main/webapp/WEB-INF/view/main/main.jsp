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


<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}


/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
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


<div align="center">
<div class="mySlides fade">
  <img src="../resources/images/ad_main_03.png" style="width:80%">
</div>

<div class="mySlides fade">
  <img src="../resources/images/ad_main_04.png" style="width:80%">
</div>

<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
</div>







<!-- 테이블 -->
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
	
	
	
	
<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 2 seconds
}
</script>
	
	
	
</body>
</html>