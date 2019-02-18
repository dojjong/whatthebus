<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../admin/admin_main_header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	변경하실 추천수 입력 :
	<form id="bestForm" name="bestForm" method="post" action="setBestCount.do">
		<input type="text" id="bestcount" name="bestcount"> <input
			id="bestbt" type="button" value="확인">
	</form>
	<script>
		$("#bestbt").click(function() {
			if (document.bestForm.bestcount.value == "") {
				alert("추천설정숫자를 입력해주세요.");
				return;
			}
			alert("추천 요구치가  " + $("#bestcount").val() + "으로 변경되었습니다.");
			document.bestForm.submit();
		});
	</script>

</body>
</html>