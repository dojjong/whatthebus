<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분실물 updateLostForm</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
<style>
#outline{
	border: 1px solid lightgrey;
	background-color: rgb(249, 249, 249);
}


</style>
</head>
<body>
	<div align="center">
		<b>글수정</b>
	</div>
	<br />
	<form method="post" id="updateLostForm" name="updateLostForm"
		action="updateLostBoard.do?seq=${vo.seq}">
		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" />
		<table border="1" align="center" id="outline" width="1000">

			<tr>
				<td width="100" align="center">작성자</td>
				<td width="700">${member.name }</td>


			</tr>

			<tr>
				<td width="100" align="center">제목</td>
				<td width="700"><input type="text" size="110" maxlength="50"
					name="title" value="${vo.title}"/></td>

				<!-- <input type="text" size="50" maxlength="50" name="subject"
					value="[답변]" />
				</td>-->

			</tr>
			<tr>
				<td width="100" align="center">내용</td>
				<td><textarea name="content" id="ir1" rows="15" cols="600"
						style="width: 850px; height: 200px;">${vo.content }</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					id="insertBoardbt" class="writebt" value="글쓰기" /> <input
					type="reset" class="writebt" value="다시작성" /> <a
					href="getLostBoardList.do"> <input type="button" class="contentbt"
						value="목록"></a>
			</tr>
		</table>
	</form>
	<br/>
	<script type="text/javascript">
		$(function() {
			var oEditors = [];

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
				fCreator : "createSEditor2"

			});
			//전송버튼 클릭이벤트
			$("#insertBoardbt").click(function() {
				//id가 ir1인 textarea에 에디터에서 대입
				oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

				// 이부분에 에디터 validation 검증

				//폼 submit
				document.writeForm.submit();
			});
		});
	</script>
	<script type="text/javascript"
		src="../resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript" src="../resources/js/boardScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>