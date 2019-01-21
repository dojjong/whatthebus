<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/loginStyle.css">
</head>
<body>
	<div align="center">
		<form method="post">

			<table>
				<tr>
					<td>ID 또는 PASSWORD가 올바르지 않습니다.</td>
				</tr>
				<tr>
					<td><a href="login.jsp"> <input type="button"
							id="loginErrorbt" value="로그인 화면으로 이동"></a></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>