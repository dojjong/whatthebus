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
			<table id="choice">
				<tr>
					<td><input type="radio" name="check"
						value="member">일반 손님 회원가입</td>
				</tr>
				<tr>
					<td><input type="radio"  name="check"
						value="driver">기사님으로 회원가입</td>
				</tr>
					<td align="right">
					<a href="../join/insertMember.jsp" target="iframe">
					<input type="submit" value="다음"
						id="idsearchnextbt"></a></td>
				</tr>
			</table>
			</div>
			
</body>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</html>