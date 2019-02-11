<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>

<link type="text/css" rel="stylesheet"
	href="../resources/css/boardStyle.css" />

</head>
<body>

	<div align="center">
		<b>글쓰기</b>
	</div>
	<br />
	<form method="post" id="writeForm" name="writeForm"
		action="insertBoard.do">
		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" /> <input
			type="hidden" id="imsi_wido" name="imsi_wido" value="" /> <input
			type="hidden" id="imsi_kyungdo" name="imsi_kyungdo" value="" /> <input
			type="hidden" id="imsiJuso" name="imsiJuso" value="" /> <input
			type="hidden" id="start_wido" name="start_wido" value="" /> <input
			type="hidden" id="start_kyungdo" name="start_kyungdo" value="" /> <input
			type="hidden" id="end_wido" name="end_wido" value="" /> <input
			type="hidden" id="end_kyungdo" name="end_kyungdo" value="" /> <input
			type="hidden" id="startJuso" name="startJuso" value="" /> <input
			type="hidden" id="endJuso" name="endJuso" value="" /> <input
			type="hidden" id="spanImsiKyungdo" /> <input type="hidden"
			id="spanImsiWido">
		<table border="1" align="center">

			<tr>
				<td width="100" align="center">작성자</td>
				<td width="700">${member.name }</td>


			</tr>

			<tr>
				<td width="100" align="center">제목</td>
				<td width="700"><input type="text" id="title" size="50"
					maxlength="50" name="title" /></td>

				<!-- <input type="text" size="50" maxlength="50" name="subject"
					value="[답변]" />
				</td>-->

			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="ir1" rows="15" cols="600"
						style="width: 680px; height: 200px;"></textarea></td>
			</tr>

			<tr>
				<td colSpan="2">1) 원하는 위치를 입력해주세요 → <input type="text"
					id="usertRegistMap_input" />&nbsp;<input type="button" value="검색"
					onClick="search()" /></td>
			</tr>
			<tr>
				<td colSpan="2"><div id="map"
						style="width: 800px; height: 300px;"></div></td>
			</tr>
			<tr>
				<td colSpan="2">2) 검색 후, 정확한 위치를 마우스로 클릭해주세요</td>
			</tr>

			<tr>
				<td colSpan="2">&nbsp;&nbsp;&nbsp;&nbsp;주소 : <span
					id="spanImsiJuso"></span></td>
			</tr>
			<tr>
				<td colSpan="2">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
					id="startSetBt" value="희망출발지 지정" onClick="startSet()" />&nbsp;<input
					type="button" id="endSetBt" onClick="endSet()" value="희망도착지 지정" /></td>
			</tr>
			<tr>
				<td colSpan="2">3) 확정 결과</td>
			</tr>
			<tr>
				<td colSpan="2">&nbsp;&nbsp;&nbsp;&nbsp;확정 출발지 : <span
					id="spanStartJuso"></span></td>
			</tr>
			<tr>
				<td colSpan="2">&nbsp;&nbsp;&nbsp;&nbsp;확정 도착지 : <span
					id="spanEndJuso"></span></td>
			</tr>



			<tr>
				<td colspan="2" align="center"><input type="button"
					id="insertBoardbt" class="writebt" value="글쓰기" /> <input
					type="reset" class="writebt" value="다시작성" /> <input type="button"
					class="writebt" value="목록"
					onclick="location.href='getBoardList.do'"></td>
			</tr>
		</table>
	</form>
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
				if ($("#title").val() == "") {
					alert("제목을 입력해주세요.");
					return;
				}
				if ($("#ir1").val() == "<p>&nbsp;</p>") {
					alert("내용을 입력해주세요.");
					return;
				}
				// 이부분에 에디터 validation 검증

				//폼 submit
				document.writeForm.submit();
			});
		});
	</script>
	<script type="text/javascript"
		src="../resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="../resources/js/userRegistMapScript.js"></script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>