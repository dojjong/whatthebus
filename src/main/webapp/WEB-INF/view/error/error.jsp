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
		<form method="post" action="main.do">
			<table>
				<tr>
					<td align="center">잘못된 접근입니다.<br /> 관리자에게 문의하세요.
					</td>
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