<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form method="post" action="../member/updateCheckDriver.jsp">
			<table>
				<tr>
					<td align="center">비밀번호가 틀렸습니다.</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" class="insertbt"
						value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>

</body>
</html>