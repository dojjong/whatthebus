<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>


<title>회원목록</title>
</head>
<body>
	<h2>전체회원목록</h2>
	<form id="searchMemberForm" name="searchMemberForm">
		<select id="searchOption" name="searchOption">
			<option value="all">전체검색</option>
			<option value="id">ID로 검색</option>
			<option value="name">이름으로 검색</option>
			<option value="tel">전화번호로 검색</option>
			<option value="email">이메일로 검색</option>
		</select> <input name="keyword" id="keyword" value=""> <input
			type="button" id="searchButton" name="searchButton"
			class="btn btn-default" value="검색" />
	</form>
	<table border="1" width="700px">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입일자</th>
			<th>License</th>
			<th>회원상태</th>
			<th>제명처리</th>
			<th>메일발송</th>
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
				<td><c:if test="${row.statecount!=2 }">
						<input type="button" id="expulsionbt" value="제명"
							onclick="expulsionMember('${row.id}')">
					</c:if> <c:if test="${row.statecount==2 }">
						<input type="button" id="expulsionbt" value="ID복구"
							onclick="returnMember('${row.id}')">
					</c:if></td>
				<td><input type="button" id="sendMailMember" value="메일전송"
				onclick="sendMailMember('${row.id}')"></td>
			</tr>
		</c:forEach>

	</table>
	<script>
		function expulsionMember(mid) {
			var id = String(mid);
			var test = confirm("정말 추방하시겠습니까 ? ");
			if (test == true) {
				$.ajax({
					type : "POST",
					url : "allExpulstionMember.do",
					data : {
						"id" : id
					},
					success : function(data) {
						if (data == "success") {
							alert("제명되었습니다.");
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

		function returnMember(mid) {
			var id = String(mid);
			var test = confirm("정말 복구하시겠습니까 ? ");
			if (test == true) {
				$.ajax({
					type : "POST",
					url : "allReturnMember.do",
					data : {
						"id" : id
					},
					success : function(data) {
						if (data == "success") {
							alert("복구되었습니다.");
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

		function sendMailMember(mid){
			var id = String(mid);
			$.ajax({
				type : "POST",
				url : "sendMailMember.do",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "success") {
						$("#result").load("sendMailForm.do?id="+id);
						return;
					}
				},error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		}
		
		$("#searchButton").click(function() {
			var keyword = $("#keyword").val();
			var searchOption = $("#searchOption").val();
			$.ajax({
				type : "POST",
				url : "searchMember.do",
				data : {
					"keyword" : keyword,
					"searchOption" : searchOption
				},
				success : function(data) {
					if (data == "success") {
						$("#result").load("returnSearchMember.do");
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		});
		
		
	</script>

</body>
</html>