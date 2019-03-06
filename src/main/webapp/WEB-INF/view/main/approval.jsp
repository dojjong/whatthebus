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
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>	
<style>
#writebt {
 width: 160px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
}
</style>
</head>
<body>
	<br/>

		<form action="main.do" method="post">
		<table align="center">
		<tr><td><i class='fas fa-user-clock' style='font-size:400px;color:rgb(49, 100, 176)'></i></td></tr>
		<tr><td align="center"><h4><b>가입 승인 대기중인 기사님입니다.</b></h4></td></tr>
		<tr><td align="center">
		<input type="submit" id="writebt" value="메인화면으로 가기">
		</td></tr>
		</table>
			
		</form>

	<br/>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>