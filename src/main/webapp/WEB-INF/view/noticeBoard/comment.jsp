<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<style>



textarea#content{
	resize: none;
}

#comment{
   border-bottom: 1px dotted grey;
}

#cmt{
background-color: rgb(249, 249, 249);
}

#insertNoticeCommentbt{
 width: 88px;
 height: 75px;
 background-color: white;
 border: 1px solid lightgrey;
 color: grey;
}

</style>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<div align="center">
		<form id="noticeCommentListForm" name="noticeCommentListForm" method="post">
			<c:set var="check" value="" />

		<div id="noticeCommentList" align="center"></div>
		</form>
	</div>


	<div align="center">
		<form id="noticeCommentForm" name="noticeCommentForm" action="insertNoticeComment.do" method="POST">
			<input type="hidden" id="id" name="id" value="${member.id }" /> 
			<input type="hidden" id="name" name="name" value="${member.name } " /> 
			<input type="hidden" id="seq" name="seq" value="${vo.seq }" />
			
			<table width="960px" id="cmt">
				<tr>
					<td align="left" colspan="2"><span><strong>댓글</strong></span> <span id="noticeCommentCount"></span></td>
				</tr>
				<tr>
					<td><textarea rows="3" cols="120" id="content" name="content" placeholder="댓글을 입력하세요."></textarea></td>
					<td align="right" width="60">
					<input type="button" id="insertNoticeCommentbt" class="contentbt" value="등록"></td>
				</tr>
				
			</table>
			<input type="hidden" id="seq" name="seq" value="" />
		</form>
	</div>


	<script>
		var updateCheck = 0;
		var updateCheckCno = 0;
		var getNoticeComment = "";
		//댓글 등록하기(ajax)
		$("#insertNoticeCommentbt").click(function() {
			if (document.noticeCommentForm.content.value == "") {
				alert("댓글을 입력해주세요.");
				return;
			}
			$.ajax({
				type : "POST",
				url : "<c:url value='insertNoticeComment.do'/>",
				data : $("#noticeCommentForm").serialize(),
				success : function(data) {
					if (data == "success") {
						getNoticeCommentList();
						document.noticeCommentForm.content.value = "";
					}
				},
				error : function(request, status, error) {
					alert("로그인 후 이용해주세요.");
				}

			});
		});

		//초기 페이지 로딩시 댓글 불러오기
		$(function() {
			getNoticeCommentList();
		});

		//댓글 불러오기(ajax)
		function getNoticeCommentList() {
			$
					.ajax({
						type : "POST",
						url : "<c:url value='noticeCommentList.do'/>",
						dataType : "json",
						data : $("#noticeCommentForm").serialize(),
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(data) {
							var html = "";
							var cCnt = data.length;
							var sid = document.noticeCommentForm.id.value;

							if (data.length > 0) {
								for (i = 0; i < data.length; i++) {

									html += "<table width='960' class='comment_table' id='cmt'><tr><td align='left'colspan='2'><h6><strong>"
											+ data[i].name
											+ "</strong></td><td align='left'>"
											+ data[i].regdate;
									if (sid == data[i].cid) {
										html += "</h6></td><td align='right'>"
												+ "<a href='#' onclick='updateNoticeComment("
												+ data[i].cno
												+ ")'>수정</a>&nbsp;"
												+ "<a href='#' onclick='deleteNoticeComment("
												+ data[i].cno + ")'>삭제</a>"
												+ "</td></tr>";
									} else {
										html += "<td></td>";
									}
									if (data[i].cno == updateCheckCno
											&& updateCheck == 1) {
										html += "<tr><td colspan='3'>";
										html += "<textarea rows='2' cols='80' id='updateContent' name='content'>"
												+ getNoticeComment
												+ "</textarea></td><td align='right'><input type='button' value = '확인'  class='contentbt' onclick='updateNoticeCommentCheck("
												+ data[i].cno
												+ ")'/>"
												+ "</td></tr>";
										html += "</table>";
									} else {
										html += "<tr id='comment'><td colspan='4'>";
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
							$("#noticeCommentCount").html(cCnt);
							$("#noticeCommentList").html(html);

						},
						error : function(request, status, error) {

						}
					});
		}

		function updateNoticeComment(cno) {
			$
					.ajax({
						type : "POST",
						url : "getNoticeComment.do",
						dataType : "json",
						data : {
							"cno" : cno
						},
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						success : function(data) {
							updateCheck = 1;
							updateCheckCno = cno;
							getNoticeComment = data.content;
							getNoticeCommentList();
						}
					});
		}
		function updateNoticeCommentCheck(cno) {
			if (document.noticeCommentListForm.updateContent.value == "") {
				alert("댓글을 입력해주세요.");
				return;
			}
			$.ajax({
				type : "POST",
				url : "updateNoticeCommentCheck.do",
				data : {
					"cno" : cno,
					"content" : $("#updateContent").val()
				},
				success : function(data) {
					if (data == "success") {
						updateCheck = 0;
						getNoticeCommentList();
					}

				}
			});
		}

		function deleteNoticeComment(cno) {
			if (confirm("정말 삭제하시겠습니까 ? ")) {
				$.ajax({
					type : "POST",
					url : "deleteNoticeComment.do",
					data : {
						"cno" : cno
					},
					success : function(data) {
						if (data == "success") {
							getNoticeCommentList();
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