<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>회원목록</title>
</head>
<body>
	<h2>전체회원목록</h2>



	<table border="1" width="700px">



		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일자</th>
			<th>License</th>
			<th>추방처리</th>
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
				<td><input type="button" id="expulsionbt" value="추방하기"
					onclick="expulsionMember(${row.id})"></td>
			</tr>
		</c:forEach>

	</table>
	<script>
	function expulsionMember(id){
	var test=confirm("정말 추방하시겠습니까 ? ");
	if(test==true){
	$.ajax({
		type : "POST",
		url : "expulsionMember.do",
		data :{"id" : id},
		success : function(data) {
			if (data == "success") {
				alert("추방되었습니다.");
				//document.updateDriverForm.action = "refreshApprovalDriverList.do";
				//document.updateDriverForm.submit();
				$("#result").load("getAllMemberList.do");
				return;
			}
		},
		error : function(request, status, error) {
			alert("잘못된 접근입니다.");
		}
	});
	}
}
	</script>


</body>
</html>