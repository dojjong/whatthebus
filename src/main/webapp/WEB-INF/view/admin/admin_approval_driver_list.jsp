<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>승인대기 기사목록</title>
</head>
<body>
<div>
	<h2>가입 승인대기 기사목록</h2>
<form method="post" id="updateDriverForm" name="updateDriverForm"> 
	<table border="1" width="700px">
		<tr>
			<th width="50">아이디</th>
			<th width="50">이름</th>
			<th width="50">성별</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일자</th>
			<th>License</th>
			<th>승인</th>
		</tr>

		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.id }</td>
				<td>${row.name }</td>
				<td>${row.gender }</td>
				<td>${row.tel }</td>
				<td>${row.email }</td>
				<td>${row.regdate }</td>
				<td>${row.license }</td>
				<td><input type="button" id="approvalbt" value="승인" onclick="setStateCount(${row.id})">
			</tr>
		</c:forEach>

	</table>
	</form>
	</div>
	
<script>
function setStateCount(id){
	alert("승인되었습니다.");
	document.updateDriverForm.id.value=id;
	document.updateDriverForm.action = "setStateCount.do?id="+id;
	document.updateDriverForm.submit();
}
	

</script>
</body>
</html>