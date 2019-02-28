<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	변경하실 메인게시글수 입력 :
	<form id="mainForm" name="mainForm" method="post"
		action="setMainCount.do">
		<input type="text" id="mainCount" name="mainCount"> <input
			id="mainbt" type="button" value="확인">
	</form>
	<script>
		$("#mainbt").click(
				function() {
					if (document.mainForm.mainCount.value == "") {
						alert("설정하실 숫자를 입력해주세요.");
						return;
					}
					$.ajax({
						type : "POST",
						url : "setMainCount.do",
						data : {
							"mainCount" : $("#mainCount").val()
						},
						success : function(data) {
							if (data == "success") {
								alert("메인 게시글 수가  " + $("#mainCount").val()
										+ "개로 변경되었습니다.");
								$("#result").load("moveSetMainCount.do");
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