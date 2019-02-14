<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link type="text/css" rel="stylesheet" href="../resources/css/mainStyle.css">
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<!-- 화면 센터 -->
	<div align="center">
		<form method="post" action="deleteMember.do">
			<input type="hidden" name="check" value="" />
			<table>
				<tr>
					<td id="welcome" colspan="2" align="center">회원탈퇴</td>
				</tr>
				<tr>
					<td align="right">아이디 :</td>
					<td align="left">${member.id}</td>
				</tr>
		
				<tr>
					<td align="right">비밀번호 확인 :&nbsp;</td>
					<td align="left"><input type="password" id="insertPasswordCheck" name="password"
						value="" /> <br /> <font color="red"><span id="passwordCheckMessage"></span></font></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						class="insertbt" value="탈퇴" /> <input type="button"
						class="insertbt" value="취소" onclick="" /></td>
				</tr>
			</table>
		</form>
	</div>



</body>
</html>