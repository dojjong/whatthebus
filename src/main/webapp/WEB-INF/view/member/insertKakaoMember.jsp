<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<style>

#div01{
width: 1024px;
align: center;
border: 2px solid rgb(49, 100, 176);

padding: 10px;
border-radius: 25px;

}
#welcome {
background-color: rgb(250, 225, 0);
border: 2px solid rgb(250, 225, 0);
padding: 10px;
border-radius: 25px;

}

.td_font01{
color: rgb(59, 30, 30);
	font-size: 60pt;
	font-family: "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;

}

.td_font02{
color: white;
	font-size: 20pt;
	font-family: "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;

}

.contentbt {
 width: 65px;
 height: 30px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
}


#td01{
	align: center;
	font-size: 20pt;
	font-family: "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;
}

#td02{
align: center;
	font-size: 15pt;
	font-family: "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;

}


</style>

</head>
<body>

	<div align="center">
		<form name="form" method="post" action="insertKakaoMember.do">
		<input type="hidden" name="id" value="${member.id }">
		<div>
			<br/>
			<table>
				
				<tr>
				<td id="welcome" colspan="3" align="center" class="td_font01"><br/>
				<i class='fas fa-bus' style='font-size:300px;color:rgb(59, 30, 30);'></i><br/>
				&nbsp;WHAT THE BUS&nbsp;
				</td>
				</tr>
			</table>
			
			<table>	
				
				<tr>
					<td colspan="3" align="center" id="td01"><b>What the bus에 오신 것을 환영합니다.</b></td></tr>
				<tr><td colspan="3" align="center" id="td02">원활한 서비스 이용을 위해 추가정보를 입력해주세요.
					</td>
				</tr>
			</table>
			
			<table id="tb03">
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;이름</td>
					<td align="left"><input type="text" id="insertName"
						name="name" value="${member.name }" /> &nbsp; <font color="red">
							<span id="nameMessage"> </span>
					</font></td>
				</tr>
				
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;성별 </td>
					<td align="left"><input type="radio" id="insertGender1"
						name="gender" value="M">남성 <input type="radio"
						id="insertGender2" name="gender" value="F">여성&nbsp;&nbsp;
						<font color="red"> <span id="genderMessage"> </span></font></td>
				</tr>

				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;전화번호</td>
					<td align="left"><select id="insertTel1" name="tel1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" id="insertTel2" name="tel2" size="2" value="" />
						- <input type="text" id="insertTel3" name="tel3" size="2" value="" />
						&nbsp; <font color="red"><span id="telMessage"> </span></font></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center"><input type="reset"
						class="contentbt" value="다시입력" />&nbsp;&nbsp; <input type="submit"
						id="insertCheckbt" class="contentbt" value="수정완료" />&nbsp;&nbsp;</td>
				</tr>
				
			</table>
			</div>
		</form>
	</div>
	<br/>
</body>
</html>