<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

<style>

#tb01{
font-size: 10.5pt;
font-family: "Lucida Sans Unicode", "Bitstream Vera Sans",
		"Trebuchet Unicode MS", "Lucida Grande", Verdana, Helvetica,
		sans-serif;
background-color: rgb(249, 249, 249);		
}

.buttonst{
 align: center;
 width: 70px;
 height: 30px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
 
}

.buttonst01{
 width: 110px;
 height: 30px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
 
}


</style>

</head>
<body>
<br/>
	<!-- 화면 센터 -->
	<div align="center">
	
	<table>
		<tr>
					<td id="welcome" colspan="3" align="center" width="610"><b>Welcome to What the Bus! Please, join us!</b></td>
				</tr>
				<tr>
					<td colspan="3"><h3><b>&nbsp;회원가입</b></h3></td>
				</tr>
		</table>
		
		<form name="form" method="post" action="insertDriver.do" enctype="multipart/form-data">
		
		
		<table id="tb01">
				
				<tr>
					<td align="left"width="110">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>아이디</b></td>
					<td align="left" width="500">&nbsp;<input type="text" id="insertId" name="id" autocomplete="off"/>&nbsp;
					<font color="red"><span id="idMessage"></span></font></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>비밀번호</b></td>
					<td align="left">&nbsp;<input type="password" id="insertPassword"
						name="password" value="" />&nbsp; <font color="red"><span
							id="passwordMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>비밀번호 확인</b></td>
					<td align="left">&nbsp;<input type="password"
						id="insertPasswordCheck" name="passwordcheck" value="" />&nbsp; <font
						color="red"><span id="passwordCheckMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>이름</b></td>
					<td align="left">&nbsp;<input type="text" id="insertName"
						name="name" value="" autocomplete="off"/> &nbsp; <font color="red"> <span
							id="nameMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>성별</b></td>
					<td align="left">&nbsp;<input type="radio" id="insertGender1"
						name="gender" value="M">남성 <input type="radio"
						id="insertGender2" name="gender" value="F">여성&nbsp;&nbsp;
						<font color="red"> <span id="genderMessage"> </span></font></td>
				</tr>


				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>전화번호</b></td>
					<td align="left">&nbsp;<select id="insertTel1" name="tel1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" id="insertTel2" name="tel2" size="2" value="" autocomplete="off"/>
						- <input type="text" id="insertTel3" name="tel3" size="2" value="" autocomplete="off"/>
						&nbsp; <font color="red"><span id="telMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>이메일</b></td>
					<td align="left">&nbsp;<input type="text" id="insertEmail"
						name="email" value="" autocomplete="off"/>&nbsp;<input type="button" id="emailbt" class="buttonst01"
						value="인증번호 발송" /><br /></td>
				</tr>
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>인증번호 입력</b></td>
					<td align="left">&nbsp;<input type="text" id="insertEmailCheck"
						name="EmailCheck" value="" autocomplete="off">&nbsp;<input type="button"
						id="emailCheckbt" class="buttonst01" value="인증번호 확인"><font
						color="red"><span id="emailCheckMessage"> </span></font></td>
				</tr>
				
				<tr>
					<td align="left">&nbsp;<i class='fas fa-angle-right'></i>&nbsp;<b>면허 등록</b></td>
					<td align="left"><input type="file" id="insertFile" name="uploadFile"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">&nbsp;<input type="reset"
						class="buttonst" value="다시입력" />&nbsp;&nbsp; <input type="button"
						id="insertCheckbt" class="buttonst" value="회원가입" />&nbsp;&nbsp; <input
						type="button" class="buttonst" value="취소" onclick="" /></td>
				</tr>
			</table>
			
			<!-- 
			<table>
				<tr>
					<td id="welcome" colspan="3" align="center">What The Bus에 오신것을
						환영합니다 !</td>
				</tr>
				<tr>
					<td align="right" width="200">아이디 :&nbsp;</td>
					<td align="left" width="500"><input type="text" id="insertId"
						name="id" autocomplete="off"/>&nbsp; <font color="red"><span id="idMessage"></span></font></td>
				</tr>
				<tr>
					<td align="right">비밀번호 :&nbsp;</td>
					<td align="left"><input type="password" id="insertPassword"
						name="password" value="" />&nbsp; <font color="red"><span
							id="passwordMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">비밀번호 확인 :&nbsp;</td>
					<td align="left"><input type="password"
						id="insertPasswordCheck" name="passwordcheck" value="" />&nbsp; <font
						color="red"><span id="passwordCheckMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">이름 :&nbsp;</td>
					<td align="left"><input type="text" id="insertName"
						name="name" value="" autocomplete="off"/> &nbsp; <font color="red"> <span
							id="nameMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">성별 : &nbsp;</td>
					<td align="left"><input type="radio" id="insertGender1"
						name="gender" value="M">남성 <input type="radio"
						id="insertGender2" name="gender" value="F">여성&nbsp;&nbsp;
						<font color="red"> <span id="genderMessage"> </span></font></td>
				</tr>


				<tr>
					<td align="right">전화번호 :&nbsp;</td>
					<td align="left"><select id="insertTel1" name="tel1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" id="insertTel2" name="tel2" size="2" value="" autocomplete="off"/>
						- <input type="text" id="insertTel3" name="tel3" size="2" value="" autocomplete="off"/>
						&nbsp; <font color="red"><span id="telMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">이메일 :&nbsp;</td>
					<td align="left"><input type="text" id="insertEmail"
						name="email" value="" autocomplete="off"/>&nbsp;<input type="button" id="emailbt"
						value="인증번호 발송" /><br /></td>
				</tr>
				<tr>
					<td align="right">인증번호 입력 : &nbsp;</td>
					<td align="left"><input type="text" id="insertEmailCheck"
						name="EmailCheck" value="" autocomplete="off">&nbsp;<input type="button"
						id="emailCheckbt" value="인증번호 확인"><font color="red"><span
							id="emailCheckMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">면허 등록 : &nbsp;</td>
					<td align="left"><input type="file" id="insertFile" name="uploadFile"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="reset"
						class="insertbt" value="다시입력" />&nbsp;&nbsp; <input type="button"
						id="insertCheckbt" class="insertbt" value="가입신청" />&nbsp;&nbsp; <input
						type="button" class="insertbt" value="취소" onclick="" /></td>
				</tr>
			</table>
		 -->	
		</form>

	</div>
	<br/>


	<script type="text/javascript" src="../resources/js/driverScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>




</body>
</html>