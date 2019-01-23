<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>

<link type="text/css" rel="stylesheet" href="../css/mainStyle.css">
</head>
<body>
	<!-- 화면 센터 -->
	<div align="center">
		<form name="form" method="post" action="insertMember.do">
			<table>
				<tr>
					<td id="welcome" colspan="2" align="center">What The Bus에 오신것을
						환영합니다 !</td>
				</tr>
				<tr>
					<td align="right">아이디 :&nbsp;</td>
					<td align="left"><input type="text" id="id" name="id" value="">
						<font color="red"><span id="idMessage"></span></font></td>
				</tr>
				<tr>
					<td align="right">비밀번호 :&nbsp;</td>
					<td align="left"><input type="password" name="password"
						value="" />&nbsp; <font color="red"><span
							id="passwordMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">비밀번호 확인 :&nbsp;</td>
					<td align="left"><input type="password" name="passwordcheck"
						value="" />&nbsp; <font color="red"><span
							id="passwordCheckMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">이름 :&nbsp;</td>
					<td align="left"><input type="text" name="name" value="" />
						&nbsp; <font color="red"> <span id="nameMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">성별 : &nbsp;</td>
					<td align="left"><input type="radio" name="gender" value="M">남성
						<input type="radio" name="gender" value="F">여성&nbsp;&nbsp;
						<font color="red"> <span id="genderMessage"> </span></font></td>
				</tr>


				<tr>
					<td align="right">전화번호 :&nbsp;</td>
					<td align="left"><select name="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" name="tel2" size="2" value="" /> - <input
						type="text" name="tel3" size="2" value="" /> &nbsp; <font
						color="red"><span id="telMessage"> </span></font></td>
				</tr>
				<tr>
					<td align="right">이메일 :&nbsp;</td>
					<td align="left"><input type="text" name="email" value="" />&nbsp;
						<input type="button" id="emailcheckbt" value="인증번호 발송" onclick="" /><br /></td>
				</tr>
				<tr>
					<td align="right">인증번호 입력 : &nbsp;</td>
					<td align="left"><input type="text" name="emailcheck" value="">
						<font color="red"><span id="emailCheckMessage"> </span></font></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="reset"
						class="insertbt" value="다시입력" />&nbsp;&nbsp; <input type="submit"
						class="insertbt" value="회원가입" onclick="" />&nbsp;&nbsp; <input
						type="button" class="insertbt" value="취소" onclick="" /></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="../js/memberScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>




</body>
</html>