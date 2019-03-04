<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<style>

/* The container */
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default radio button */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
.container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}

#div01{

width: 300px;
height: 400px;
border: 2px solid rgb(49, 100, 176);
padding: 10px;
border-radius: 25px;

}

#td01{
color: rgb(49, 100, 176);
}

#div02{

width: 300px;
height: 400px;
border: 2px solid rgb(49, 100, 176);
padding: 10px;
border-radius: 25px;
}

</style>

</head>
<body>
<div>
<br/>
	<form method="post" action="memberChoice.do">
		<div align="center">
			
			<table width="1024">
			<tr><td align="center" colspan="2">
			<h3><b>해당하시는 회원 유형을 선택하신 후 다음 버튼을 눌러주시길 바랍니다.</b></h3></td></tr>
			
			<tr>
			
			<tr>
			<!-- 일반회원 --><td align="center">
			<div id="div01">
			
			<table>
			<tr><td id="td01" align="center"><h1><b>일반회원</b></h1></td></tr>
			<tr><td align="center"><i class='far fa-address-card' style='font-size:140px;color:rgb(49, 100, 176)'></i></td></tr>
			<tr><td align="center"><br/><b>WHAT THE BUS가 제공하는<br/> 서비스를 사용하는 회원</b></td></tr>
			<tr><td><br/>
			<label class="container">&nbsp;&nbsp;일반회원가입
  				<input type="radio" name="check" value="member" checked="checked">
 				 <span class="checkmark"></span>
			</label>
			</td></tr>
			</table>
			
			</div>
			</td>
			
			
			<!-- 기사회원 --><td align="center">
			<div id="div02">
			<table>
			<tr><td id="td01" align="center"><h1><b>기사회원</b></h1></td></tr>
			<tr><td align="center"><i class='fas fa-bus' style='font-size:140px;color:rgb(49, 100, 176)'></i></td></tr>
			<tr><td align="center"><br/><b>WHAT THE BUS가 제공하는<br/> 서비스를 사용하는 회원</b></td></tr>
			<tr><td><br/>
			<label class="container">&nbsp;&nbsp;기사회원가입
  				<input type="radio" name="check" value="driver">
 				 <span class="checkmark"></span>
			</label>
			</td></tr>
			</table>
			
			</div>
			</td>
	
			</tr>
			
			<td align="center" colspan="2"><input type="submit" value="다음"
						id="idsearchnextbt"></td>
			</tr>			
			</table>
			<br/>
		
			<!-- 
			<table id="choice" width="1024">
			
			
				
				<tr>
				<td>
				<h1>Custom Radio Buttons</h1>
			<label class="container">&nbsp;&nbsp;일반회원가입
  				<input type="radio" name="check" value="member">
 				 <span class="checkmark"></span>
			</label>
			<label class="container">&nbsp;&nbsp;기사회원가입
  				<input type="radio" name="check" value="driver">
  				<span class="checkmark"></span>
			</label>
		     </td>
             <tr>
				
				<tr>
					<td align="center"><input type="radio" name="check" value="member">일반
						손님 회원가입</td>
				</tr>
				<tr>
					<td align="center"><input type="radio" name="check" value="driver">기사님으로
						회원가입</td>
				</tr>
				<tr>
					<td align="right"><input type="submit" value="다음"
						id="idsearchnextbt"></td>
				</tr>
			</table>
		 -->	
		</div>
	</form>
</div>	
</body>
<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</html>