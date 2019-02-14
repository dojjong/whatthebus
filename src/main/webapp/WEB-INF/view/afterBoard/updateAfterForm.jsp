<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />

</head>
<body>
	<div align="center">
		<b>글수정</b>
	</div>
	<br />
	<form method="post" id="updateAfterForm" name="updateAfterForm">

			<input type="hidden" name="id" value="${member.id }"> 
			<input type="hidden" name="name" value="${member.name }" /> 	
 			<input type="hidden" name="seq" value="${vo.seq }" /> 
 			
		
			
		<table border="1" align="center">

			<tr>
				<td width="100" align="center">작성자</td>
				<td width="700">${member.name }</td>
			</tr>

			<tr>
				<td width="100" align="center">제목</td>
				<td width="700"><input type="text" size="50" maxlength="50" id="title"
					name="title" value="${vo.title}" /></td>

				<!-- <input type="text" size="50" maxlength="50" name="subject"
					value="[답변]" />
				</td>-->

			</tr>
			<tr>
				<td width="100" align="center">내용</td>
				<td><textarea name="content" id="ir1" rows="15" cols="600"
						style="width: 680px; height: 200px;">${vo.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" id="btnUpdate" class="writebt" value="수정" /> 
				<input type="reset" class="writebt" value="다시작성" /> 
				 <!-- 
				<a href="getAfterBoardList.do"> <input type="button" class="contentbt" value="목록"></a>
 				-->
 				<input type="button" class="contentbt" value="목록" id="listBt"/>
			</tr>
		</table>
	</form>
		<script type="text/javascript">
		$(function() {
			var oEditors = [];
			var content = '${vo.content}';
			nhn.husky.EZCreator.createInIFrame({

				oAppRef : oEditors,

				elPlaceHolder : "ir1",

				sSkinURI : "../resources/se2/SmartEditor2Skin.html",

				htParams : {
					bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
					bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
				},
				fOnAppload : function() {
					oEditors.getById["ir1"].exec("PASTE_HTML", []);
				},
				fCreator : "createSEditor2"

			});
			//수정버튼 클릭이벤트
			$("#btnUpdate").click(function() {
				//id가 ir1인 textarea에 에디터에서 대입
				oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증
				if ($("#title").val() == "") {
					alert("제목을 입력해주세요.");
					return;
				}
				if ($("#ir1").val() == "<p>&nbsp;</p>") {
					alert("내용을 입력해주세요.");
					return;
				}
				//폼 submit
				document.updateAfterForm.action="updateAfterBoard.do";
				document.updateAfterForm.submit();
			});
			
			//목록버튼 클릭이벤트
			$("#listBt").click(function() {
				
				//폼 submit
				document.updateAfterForm.action="getAfterBoardList.do";
				document.updateAfterForm.submit();
			});
		});
	</script>
	<script type="text/javascript" src="../resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>