<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
<title>Insert title here</title>
</head>
<body>
<h4><i class='fas fa-angle-right'></i>&nbsp;추천수 변경</h4>
	변경하실 추천수 입력 :
	<form id="bestForm" name="bestForm" method="post"
		action="setBestCount.do">
		<input type="text" id="bestcount" name="bestcount"> <input
			id="bestbt" type="button" value="확인">
	</form>
	<script>
		$("#bestbt").click(
				function() {
					if (document.bestForm.bestcount.value == "") {
						alert("추천설정숫자를 입력해주세요.");
						return;
					}
					$.ajax({
						type : "POST",
						url : "setBestCount.do",
						data : {
							"bestcount" : $("#bestcount").val()
						},
						success : function(data) {
							if (data == "success") {
								alert("추천 요구치가  " + $("#bestcount").val()
										+ "으로 변경되었습니다.");
								$("#result").load("moveSetBestCount.do");
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