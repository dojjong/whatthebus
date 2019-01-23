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
		<form method="post" action="updateCheck.do">
			<table>
				<tr>
					<td align="center">성공적으로 변경되었습니다.</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" class="insertbt"
						value="메인페이지로 이동"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>