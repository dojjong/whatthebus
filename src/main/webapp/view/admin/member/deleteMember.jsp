

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link type="text/css" rel="stylesheet" href="../css/mainStyle.css">
</head>
<body>
	<!-- 화면 센터 -->
	<div align="center">
		<form method="post" action="updateMember.do">
			<input type="hidden" name="check" value="" />
			<table>
				<tr>
					<td id="welcome" colspan="2" align="center">회원탈퇴</td>
				</tr>
				<tr>
					<td align="right">아이디 : DB 에서 가져와야함 &nbsp;</td>
					<td align="left"></td>
				</tr>
		
				<tr>
					<td align="right">비밀번호 확인 :&nbsp;</td>
					<td align="left"><input type="password" name="reUserPW"
						value="" /> <br /> <font color="red"></font></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						class="insertbt" value="탈퇴" /> <input type="button"
						class="insertbt" value="취소" onclick="" /></td>
				</tr>
			</table>
		</form>
	</div>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>


</body>
</html>