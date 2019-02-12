<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="PWUpdateForm" action="findUpdatePassword.do" method="POST">
		변경하실 비밀번호 : <input type="password" id="password" name="password">
		<br /> 비밀번호 확인 : <input type="password" id="passwordCheck"
			name="passwordCheck"> <br /> <input type="submit" id="check"
			value="확인">
	</form>
	

</body>
</html>