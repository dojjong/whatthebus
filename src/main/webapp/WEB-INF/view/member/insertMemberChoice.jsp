<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="memberChoice.do">
		<div align="center">
			<table id="choice">
				<tr>
					<td><input type="radio" name="check" value="member">일반
						손님 회원가입</td>
				</tr>
				<tr>
					<td><input type="radio" name="check" value="driver">기사님으로
						회원가입</td>
				</tr>
				<tr>
					<td align="right"><input type="submit" value="다음"
						id="idsearchnextbt"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</html>