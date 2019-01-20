

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link type="text/css" rel="stylesheet" href="../css/mainStyle.css">
<link type="text/css" rel="stylesheet" href="../css/JoinStyle.css">
</head>
<body>
	<!-- 화면 센터 -->
	<div align="center">
		<form method="post" action="updateMember.do">
			<input type="hidden" name="check" value="" />
			<table>
				<tr>
					<td id="welcome" colspan="2" align="center">회원정보수정</td>
				</tr>
				<tr>
					<td align="right">아이디 : DB 에서 가져와야함 &nbsp;</td>
					<td align="left"></td>
				</tr>
				<tr>
					<td align="right">비밀번호 :&nbsp;</td>
					<td align="left"><input type="password" name="mpassword"
						value="" /> <br /> <font color="red"></font></td>
				</tr>
				<tr>
					<td align="right">비밀번호 확인 :&nbsp;</td>
					<td align="left"><input type="password" name="reUserPW"
						value="" /> <br /> <font color="red"></font></td>
				</tr>
				<tr>
					<td align="right">이름 :&nbsp;</td>
					<td align="left">
						<br /> <font color="red"></font></td>
				</tr>
				<tr>
					<td align="right">성별 : &nbsp;</td>
					<td align="left"><input type="radio" name="mgender" value="m">남성
						<input type="radio" name="mgender" value="f">여성</td>
				</tr>


				<tr>
					<td align="right">전화번호 :&nbsp;</td>
					<td align="left"><select name="mtel">
							<option value="02">02</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" name="phone2" size="5" value="" /> - <input
						type="text" name="phone3" size="5" value="" /> <br /> <font
						color="red"></font></td>
				</tr>
				<tr>
					<td align="right">이메일 :&nbsp;</td>
					<td align="left"><input type="text" name="memail" value="" />
						<font color="red"></font> 
				<tr>
					<td colspan="2" align="right"><input type="reset"
						class="insertbt" value="다시입력" />&nbsp;&nbsp; <input type="submit"
						class="insertbt" value="수정완료" /> <input type="button"
						class="insertbt" value="취소" onclick="" /></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>


</body>
</html>