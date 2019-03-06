<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
	
<title>기사목록</title>
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
</head>
<body>
	<h4><i class='fas fa-angle-right'></i>&nbsp;기사목록</h4>
	
	<table id="table001">
	<tr>
	<td>포인트 입력</td>
	<td>
	<input type="text" id="point" name="point">P
	<input type="button" value="지급" onclick="insertPoint();">&nbsp;
	<input type="button" value="회수" onclick="recoveryPoint();"></td></tr>	
	</table>
	
	<br/>
	<table id="table002">
	
	
	<tr><td>메일발송&nbsp;&nbsp;</td><td>
	<input type="button" value="선택회원 메일발송" onclick="checkSendMail();"></td></tr>
	
	</table> 
	
	
	<!-- 
	
	<h2>기사목록</h2>
	<input type="button" value="선택회원 메일발송" onclick="checkSendMail();">
	포인트 입력 :
	<input type="text" id="point" name="point">P
	<input type="button" value="지급" onclick="insertPoint();">&nbsp;
	<input type="button" value="회수" onclick="recoveryPoint();">
	 -->
	
	<table border="1" id="tb01" width="1000">
		<tr>
			<td align="center">전체선택&nbsp;<input type="checkbox" name="checkAll" id="th_checkAll"
				onclick="checkAll();" /></td>
			<td align="center">아이디</td>
			<td align="center">이름</td>
			<td align="center">성별</td>
			<td align="center">전화번호</td>
			<td align="center">이메일</td>
			<td align="center">가입일자</td>
			<td align="center">License</td>
			<td align="center">회원상태</td>
			<td align="center">보유포인트</td>
			<td align="center">제명처리</td>
		</tr>

		<c:forEach var="row" items="${list }">
			<tr>
				<td><input type="checkbox" name="check" value="${row.id }" /></td>
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
				<td>${row.point }</td>
				<td><c:if test="${row.statecount!=2 }">
						<input type="button" id="expulsionbt" value="제명"
							onclick="expulsionMember('${row.id}')">
					</c:if> <c:if test="${row.statecount==2 }">
						<input type="button" id="expulsionbt" value="ID복구"
							onclick="returnMember('${row.id}')">
					</c:if></td>
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
					url : "expulsionDriver.do",
					data : {
						"id" : id
					},
					success : function(data) {
						if (data == "success") {
							alert("제명되었습니다.");
							//document.updateDriverForm.action = "refreshApprovalDriverList.do";
							//document.updateDriverForm.submit();
							$("#result").load("getDriverList.do");
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
					url : "returnDriver.do",
					data : {
						"id" : id
					},
					success : function(data) {
						if (data == "success") {
							alert("복구되었습니다.");
							//document.updateDriverForm.action = "refreshApprovalDriverList.do";
							//document.updateDriverForm.submit();
							$("#result").load("getDriverList.do");
							return;
						}
					},
					error : function(request, status, error) {
						alert("잘못된 접근입니다.");
					}
				});
			}
		}
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
						alert(checkBoxArr + "기사에게" + point + "포인트 지급하였습니다.");
						$("#result").load("getDriverList.do");
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
						alert(checkBoxArr + "기사의" + point + "포인트를 회수하였습니다.");
						$("#result").load("getDriverList.do");
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