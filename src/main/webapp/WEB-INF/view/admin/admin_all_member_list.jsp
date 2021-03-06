<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>


<style>
#tb01{
font-size: 12px;
}
#table001{
font-size: 15px;
}
#table002{
font-size: 15px;
}
</style>

<title>회원목록</title>
</head>
<body>
	<h4><i class='fas fa-angle-right'></i>&nbsp;전체회원목록</h4>
	
	<form id="searchMemberForm" name="searchMemberForm">
	<table id="table001">
	<tr><td>
		<select id="searchOption" name="searchOption">
			<option value="all">전체검색</option>
			<option value="id">ID로 검색</option>
			<option value="name">이름으로 검색</option>
			<option value="tel">전화번호로 검색</option>
			<option value="email">이메일로 검색</option>
		</select></td> 
		
		<td><input name="keyword" id="keyword" value="" autocomplete="off"> <input
			type="button" id="searchButton" name="searchButton"
			class="btn btn-default" value="검색" /></td>
			<td width="70"></td>
<td>포인트 입력</td>
	<td>
	<input type="text" id="point" name="point">P
	<input type="button" value="지급" onclick="insertPoint();">&nbsp;
	<input type="button" value="회수" onclick="recoveryPoint();"></td></tr>	
	</table>
	</form>
	<br/>
	<table id="table002">
	
	
	<tr><td>메일발송&nbsp;&nbsp;</td><td>
	<input type="button" value="선택회원 메일발송" onclick="checkSendMail();"></td></tr>
	
	</table>

	<table border="1" id="tb01" width="1000" border="1">
		<tr>
		<td align="center"><input type="checkbox" name="checkAll" id="th_checkAll"
				onclick="checkAll();" />전체선택</td>
			
			<td align="center" width="40">아이디</td>
			<td align="center">이름</td>
			<td align="center">성별</td>
			<td align="center" width="70">전화번호</td>
			<td align="center" width="90">이메일</td>
			<td align="center">가입일자</td>
			<td align="center" width="120">License</td>
			<td align="center" width="40" align="center">회원<br/>상태</td>
			<td align="center" width="40">보유<br/>포인트</td>
			<td align="center" width="20">제명<br/>처리</td>
			<td align="center" width="70">메일발송</td>
		</tr>

		<c:forEach var="row" items="${list }">
			<tr>
				<td width="65" align="center"><input type="checkbox" name="check" value="${row.id }" /></td>
				<td>${row.id }</td>
				<td width="45">${row.name }</td>
				<td width="30" align="center">${row.gender }</td>
				<td>${row.tel }</td>
				<td>${row.email }</td>
				<td width="70" align="center">${row.regdate }</td>
				<td>${row.license }</td>
				<td align="center"><c:if test="${row.statecount==1}">
				정상
				</c:if> <c:if test="${row.statecount==2 }">
				제명,탈퇴
				</c:if> <c:if test="${row.statecount==3 }">
				승인대기
				</c:if> <c:if test="${row.statecount==4 }">
				관리자
				</c:if></td>
				<td align="center">${row.point }</td>
				<td align="center"><c:if test="${row.statecount!=2 }">
						<input type="button" id="expulsionbt" value="제명"
							onclick="expulsionMember('${row.id}')">
					</c:if> <c:if test="${row.statecount==2 }">
						<input type="button" id="expulsionbt" value="ID복구"
							onclick="returnMember('${row.id}')">
					</c:if></td>
				<td align="center"><input type="button" id="sendMailMember" value="메일전송"
					onclick="sendMailMember('${row.id}')"></td>
			</tr>
		</c:forEach>

	</table>
	<br/>
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

		function sendMailMember(mid) {
			var id = String(mid);
			$.ajax({
				type : "POST",
				url : "sendMailMember.do",
				data : {
					"id" : id
				},
				success : function(data) {
					if (data == "success") {
						$("#result").load("sendMailForm.do?id=" + id);
						return;
					}
				},
				error : function(request, status, error) {
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

		function checkAll() {
			if ($("#th_checkAll").is(':checked')) {
				$("input[name=check]").prop("checked", true);
			} else {
				$("input[name=check]").prop("checked", false);
			}
		}
		function checkSendMail() {

			var checkBoxArr = [];

			$("input[name=check]:checked").each(function(i) {
				checkBoxArr.push($(this).val());
			});

			$.ajax({
				type : "POST",
				url : "moveChecksendMailMember.do",
				traditional : true,
				data : {
					"checkBox" : checkBoxArr
				},
				success : function(data) {
					if (data == "success") {

						$("#result").load(
								"moveCheckSendMailMemberForm.do?checkBox="
										+ checkBoxArr);
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		}
		function insertPoint() {
			var checkBoxArr = [];
			var point = $("#point").val();
			$("input[name=check]:checked").each(function(i) {
				checkBoxArr.push($(this).val());
			});

			$.ajax({
				type : "POST",
				url : "insertAdminMemberPoint.do",
				traditional : true,
				data : {
					"checkBox" : checkBoxArr,
					"point" : point
				},
				success : function(data) {
					if (data == "success") {
						alert(checkBoxArr + "회원에게" + point + "포인트 지급하였습니다.");
						$("#result").load("getAllMemberList.do");
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		}
		function recoveryPoint() {
			var checkBoxArr = [];
			var point = $("#point").val();
			$("input[name=check]:checked").each(function(i) {
				checkBoxArr.push($(this).val());
			});

			$.ajax({
				type : "POST",
				url : "recoveryAdminMemberPoint.do",
				traditional : true,
				data : {
					"checkBox" : checkBoxArr,
					"point" : point
				},
				success : function(data) {
					if (data == "success") {
						alert(checkBoxArr + "회원의" + point + "포인트를 회수하였습니다.");
						$("#result").load("getAllMemberList.do");
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