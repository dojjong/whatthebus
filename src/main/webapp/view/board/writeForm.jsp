<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="../css/boardStyle.css" />
<link type="text/css" rel="stylesheet" href="../css/mainStyle.css" />
<script type="text/javascript" src="./se2/js/HuskyEZCreator.js"
	charset="utf-8"></script>

</head>
<body>

	<div align="center">
		<b>글쓰기</b>
	</div>
	<br />
	<form method="post" name="writeForm" action="insertBoard.do">
		<input type="hidden" name="seq" value="">
		<table border="1" align="center">

			<tr>
				<td width="100" align="center">작성자</td>
				<td width="700">
					<!-- 디비에서 받아온 이름 -->
				</td>
			</tr>

			<tr>
				<td width="100" align="center">제목</td>
				<td width="700"><input type="text" size="50" maxlength="50"
					name="title" /></td>

				<!-- <input type="text" size="50" maxlength="50" name="subject"
					value="[답변]" />
				</td>-->

			</tr>
			<tr>
				<td width="100" align="center">내용</td>
				<td><textarea name="content" id="ir1"
						rows="15" cols="600"  style="width:680px; height:200px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					class="writebt" value="글쓰기" /> <input type="reset" class="writebt"
					value="다시작성" /> <input type="button" class="writebt" value="목록"
					onClick="list.jsp"></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var oEditors = [];

		nhn.husky.EZCreator.createInIFrame({

			oAppRef : oEditors,

			elPlaceHolder : "ir1",

			sSkinURI : "./se2/SmartEditor2Skin.html",

			htParams : {
				bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
			},
			fCreator : "createSEditor2"

		});
	</script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>