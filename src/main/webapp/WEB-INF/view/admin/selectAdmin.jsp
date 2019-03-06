<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
	
<title>관리자 선택</title>
<style>
#tb01{
font-size: 12px;
}
</style>
</head>
<body>
<br/>
<h4><i class='fas fa-angle-right'></i>&nbsp;관리자 설정</h4>
	<form id="searchMemberForm" name="searchMemberForm">
	<table id="tb01"><tr><td>
		<select id="searchOption" name="searchOption">
			<option value="all">전체검색</option>
			<option value="id">ID로 검색</option>
			<option value="name">이름으로 검색</option>
			<option value="tel">전화번호로 검색</option>
			<option value="email">이메일로 검색</option>
		</select> <input name="keyword" id="keyword" value=""> <input
			type="button" id="searchButton" name="searchButton"
			class="btn btn-default" value="검색" />
		</td></tr></table>
	</form>
	<br/>
	<table border="1" width="700px" id="tb01">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일자</th>
			<th>License</th>
			<th>회원상태</th>
			<th>관리자 지정</th>
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
				<td><c:if test="${row.statecount==1}">
				정상
				</c:if> <c:if test="${row.statecount==2 }">
				제명,탈퇴
				</c:if> <c:if test="${row.statecount==3 }">
				승인대기
				</c:if> <c:if test="${row.statecount==4 }">
				관리자
				</c:if></td>
				<td><input type="button" id="selectAdmin" name="selectadmin"
					value="관리자로 지정" onclick="selectAdmin('${row.id}');"></td>
			</tr>
		</c:forEach>
	</table>

	<script>
		$("#searchButton").click(function() {
			var keyword = $("#keyword").val();
			var searchOption = $("#searchOption").val();
			$.ajax({
				type : "POST",
				url : "searchAdminMember.do",
				data : {
					"keyword" : keyword,
					"searchOption" : searchOption
				},
				success : function(data) {
					if (data == "success") {
						$("#result").load("returnSearchAdminMember.do");
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		});
		function selectAdmin(id) {
			$.ajax({
				type : "POST",
				url : "selectAdminSpecify.do",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "success") {
						alert(id + "님이 관리자로 지정되었습니다.");
						$("#result").load("selectAdmin.do");
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