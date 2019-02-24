<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일전송 화면</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>수신 회원</td>
			<td>${id }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" size="50" id="title" name="title"
				value="안녕하세요. WhatTheBus 입니다."></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea id="content" name="content" rows="15" cols="100"
					placeholder="내용을 입력해주세요.">안녕하세요 고객의, 고객에 의한, 고객을 위한, 버스대절업체 WhatTheBus입니다.
이 메일은 기본 양식이며 개발테스트용으로 사용중이고, 수정해서 사용할수 있습니다.</textarea></td>
		</tr>
		<tr>
			<td><input type="button" value="메일전송"
				onclick="sendMail('${id}')"></td>
		</tr>
	</table>
	<script>
		function sendMail(mid) {
			var id = String(mid);
			var title = $("#title").val();
			var content = $("#content").val();

			$.ajax({
				type : "POST",
				url : "adminSendMail.do",
				data : {
					"id" : id,
					"title" : title,
					"content" : content
				},
				success : function(data) {
					if (data == "success") {
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