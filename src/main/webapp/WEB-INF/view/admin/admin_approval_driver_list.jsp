<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'
	integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ'
	crossorigin='anonymous'>

<title>승인대기 기사목록</title>
<style>
#tb01 {
	font-size: 12px;
}
</style>
</head>
<body>
	<div>
		<h4>
			<i class='fas fa-angle-right'></i>&nbsp;가입 승인대기 기사목록
		</h4>

		<form method="post" id="updateDriverForm" name="updateDriverForm">
			<table border="1" id="tb01" width="1000">
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
				<c:if test="${empty list}">
					<tr>
						<td colspan="8">가입승인 대기중인 기사님이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach var="row" items="${list }">
					<tr>
						<td>${row.id }</td>

						<td>${row.name }</td>
						<td>${row.gender }</td>
						<td>${row.tel }</td>
						<td>${row.email }</td>
						<td>${row.regdate }</td>
						<td>${row.license }</td>
						<td><input type="button" id="approvalbt" value="승인"
							onclick="setStateCount('${row.id}')">
					</tr>
				</c:forEach>

			</table>
		</form>
	</div>

	<script>
		function setStateCount(id) {

			document.updateDriverForm.id.value = id;
			//document.updateDriverForm.action = "setStateCount.do?id="+id;
			//document.updateDriverForm.submit();

			//document.updateDriverForm.action = "moveApprovalDriverList.do";
			//document.updateDriverForm.submit();
			$.ajax({
				type : "POST",
				url : "setStateCount.do",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "success") {
						alert("승인되었습니다.");
						//document.updateDriverForm.action = "refreshApprovalDriverList.do";
						//document.updateDriverForm.submit();
						$("#result").load("moveApprovalDriverList.do");
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}

			});
		}
	</script>
</body>
</html>