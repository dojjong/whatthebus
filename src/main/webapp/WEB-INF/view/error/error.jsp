<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Insert title here</title>
<style>
#writebt {
 height: 30px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
}
</style>
</head>
<body>
	<div align="center">
		<form method="post" action="main.do">
			<table>
				<tr><td align="center"><i class="material-icons" style="font-size:400px;color:red">error_outline</i></td></tr>
				<tr>
					<td align="center"><h3><b>잘못된 접근입니다.<br /> 관리자에게 문의하세요.</b></h3>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" id="writebt"
						value="확인"></td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>

</body>
</html>