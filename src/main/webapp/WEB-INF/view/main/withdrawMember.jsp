<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
</head>
<body>
<div align="center">
		<form action="main.do" method="post">
			탈퇴한 회원입니다.<br/><input type="submit" class="contentbt" value="메인화면으로 가기">
		</form>
	</div>

<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>