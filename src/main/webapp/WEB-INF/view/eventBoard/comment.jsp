<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form id="eventCommentForm" name="eventCommentForm" action="insertEventComment.do" method="POST">
			<input type="hidden" id="id" name="id" value="${member.id }" /> 
			<input type="hidden" id="name" name="name" value="${member.name } " /> 
			<input type="hidden" id="seq" name="seq" value="${vo.seq }" />
			<table>
				<tr>
					<td align="left"><span><strong>댓글</strong></span> <span id="eventCommentCount"></span></td>
				</tr>
				<tr>
					<td><textarea rows="3" cols="60" id="content" name="content" placeholder="댓글을 입력하세요."></textarea></td>
				</tr>
				<tr>
					<td align="right" width="60">
					<input type="button" id="insertEventCommentbt" class="contentbt" value="등록"></td>
				</tr>
			</table>
			<input type="hidden" id="seq" name="seq" value="" />
		</form>
	</div>
	<div align="center">
		<form id="eventCommentListForm" name="eventCommentListForm" method="post">
			<c:set var="check" value="" />

			<div id="eventCommentList" align="center"></div>
		</form>
	</div>

	<script>
		var updateCheck = 0;
		var updateCheckCno = 0;
		var getEventComment = "";
		//댓글 등록하기(ajax)
		$("#insertEventCommentbt").click(function() {
			if (document.eventCommentForm.content.value == "") {
				alert("댓글을 입력해주세요.");
				return;
			}
			$.ajax({
				type : "POST",
				url : "<c:url value='insertEventComment.do'/>",
				data : $("#eventCommentForm").serialize(),
				success : function(data) {
					if (data == "success") {
						getEventCommentList();
						document.eventCommentForm.content.value = "";
					}
				},
				error : function(request, status, error) {
					alert("로그인 후 이용해주세요.");
				}

			});
		});

		//초기 페이지 로딩시 댓글 불러오기
		$(function() {
			getEventCommentList();
		});

		//댓글 불러오기(ajax)
		function getEventCommentList() {
			$
					.ajax({
						type : "POST",
						url : "<c:url value='eventCommentList.do'/>",
						dataType : "json",
						data : $("#eventCommentForm").serialize(),
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(data) {
							var html = "";
							var cCnt = data.length;
							var sid = document.eventCommentForm.id.value;

							if (data.length > 0) {
								for (i = 0; i < data.length; i++) {

									html += "<table width='500'><tr><td align='left'colspan='2'><h6><strong>"
											+ data[i].name
											+ "</strong></td><td align='left'>"
											+ data[i].regdate;
									if (sid == data[i].cid) {
										html += "</h6></td><td align='right'>"
												+ "<a href='#' onclick='updateEventComment("
												+ data[i].cno
												+ ")'>수정</a>&nbsp;"
												+ "<a href='#' onclick='deleteEventComment("
												+ data[i].cno + ")'>삭제</a>"
												+ "</td></tr>";
									} else {
										html += "<td></td>";
									}
									if (data[i].cno == updateCheckCno
											&& updateCheck == 1) {
										html += "<tr><td colspan='3'>";
										html += "<textarea rows='2' cols='50' id='updateContent' name='content'>"
												+ getEventComment
												+ "</textarea></td><td align='right'><input type='button' value = '확인'  class='contentbt' onclick='updateEventCommentCheck("
												+ data[i].cno
												+ ")'/>"
												+ "</td></tr>";
										html += "</table>";
									} else {
										html += "<tr><td colspan='4'>";
										html += data[i].content + "</td></tr>";
										html += "</table>";
									}
								}

							} else {
								html += "<div>";
								html += "<div><table><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
								html += "</table></div>";
								html += "</div>";
							}
							$("#eventCommentCount").html(cCnt);
							$("#eventCommentList").html(html);

						},
						error : function(request, status, error) {

						}
					});
		}

		function updateEventComment(cno) {
			$
					.ajax({
						type : "POST",
						url : "getEventComment.do",
						dataType : "json",
						data : {
							"cno" : cno
						},
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(data) {
							updateCheck = 1;
							updateCheckCno = cno;
							getEventComment = data.content;
							getEventCommentList();
						}
					});
		}
		function updateEventCommentCheck(cno) {
			if (document.eventCommentListForm.updateContent.value == "") {
				alert("댓글을 입력해주세요.");
				return;
			}
			$.ajax({
				type : "POST",
				url : "updateEventCommentCheck.do",
				data : {
					"cno" : cno,
					"content" : $("#updateContent").val()
				},
				success : function(data) {
					if (data == "success") {
						updateCheck = 0;
						getEventCommentList();
					}

				}
			});
		}

		function deleteEventComment(cno) {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				$.ajax({
					type : "POST",
					url : "deleteEventComment.do",
					data : {
						"cno" : cno
					},
					success : function(data) {
						if (data == "success") {
							getEventCommentList();
						}
					},
					error : function(request, status, error) {
						alert("비정상적인 요청입니다.");
					}

				});
			}
		}
	</script>


</body>
</html>