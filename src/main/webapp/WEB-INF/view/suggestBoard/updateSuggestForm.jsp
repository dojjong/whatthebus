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
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>

<script>
	var count = 0;
	function appendItem() {
		count++;

		var newItem = document.createElement("div");
		newItem.setAttribute("id", "item_" + count);

		var midTimeItem = document.createElement("div");
		midTimeItem.setAttribute("id", "midTimeItem_" + count);

		var midtime = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[' + count
				+ ']경유지 출발시간<input type="time" name="middate">';

		var html = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="경유지 확정" onclick="midSet('
				+ count
				+ ')"/>&nbsp;<input type="button" value="삭제" onclick="removeItem('
				+ count
				+ ')"/>&nbsp;&nbsp;&nbsp;&nbsp;확정 경유지['
				+ count
				+ '] : <span name="spanMidJuso" id="spanMidJuso_'+count+'"></span><span style="display:none;" name="spanMidWido" id="spanMidWido_'+count+'"></span><span style="display:none;" name="spanMidKyungdo" id="spanMidKyungdo_'+count+'"></span>';

		midTimeItem.innerHTML = midtime;
		var midTimeList = document.getElementById('midTimeDiv');
		midTimeList.appendChild(midTimeItem);

		newItem.innerHTML = html;
		var itemListNode = document.getElementById('itemList');
		itemListNode.appendChild(newItem);

	}

	function removeItem(idCount) {

		var item = document.getElementById("item_" + idCount);
		var timeItem = document.getElementById("midTimeItem_" + idCount);

		if (item != null) {
			item.parentNode.removeChild(item);
			timeItem.parentNode.removeChild(timeItem);

		}
	}

	function midSet(idCount) {

		imsi5 = 'spanMidJuso_' + idCount;
		imsi6 = 'spanMidWido_' + idCount;
		imsi7 = 'spanMidKyungdo_' + idCount;
		var resultspanMidJuso = document.getElementById(imsi5);
		var resultspanMidWido = document.getElementById(imsi6);
		var resultspanMidKyungdo = document.getElementById(imsi7);

		var imsi1 = document.updateSuggestForm.imsi_wido.value;
		var imsi2 = document.updateSuggestForm.imsi_kyungdo.value;
		var imsi3 = document.updateSuggestForm.imsiJuso.value;

		resultspanMidJuso.innerHTML = '';
		resultspanMidJuso.innerHTML = imsi3;
		resultspanMidWido.innerHTML = '';
		resultspanMidWido.innerHTML = imsi1;
		resultspanMidKyungdo.innerHTML = '';
		resultspanMidKyungdo.innerHTML = imsi2;

		//document.updateSuggestForm.mid_wido.value = imsi1;
		//document.updateSuggestForm.mid_kyungdo.value = imsi2;
		document.updateSuggestForm.midJuso.value = imsi3;

	}

	$(document)
			.ready(
					function() {
						$("#insertBoardbt")
								.click(
										function() {

											var getValueJuso = document
													.getElementsByName('spanMidJuso');
											var getValueWido = document
													.getElementsByName('spanMidWido');
											var getValueKyungdo = document
													.getElementsByName('spanMidKyungdo');

											var i = 0;
											var temp1;
											var temp2;

											document.updateSuggestForm.mid_wido.value = "";
											document.updateSuggestForm.mid_kyungdo.value = "";
											while (i < getValueWido.length) {

												temp1 = getValueWido[i].innerHTML;

												temp2 = getValueKyungdo[i].innerHTML;
												//alert('i='+i+'temp1='+temp1+'temp2='+temp2);

												document.updateSuggestForm.mid_wido.value = document.updateSuggestForm.mid_wido.value
														+ "/" + temp1;
												document.updateSuggestForm.mid_kyungdo.value = document.updateSuggestForm.mid_kyungdo.value
														+ "/" + temp2;

												i = i + 1;
											}

											document.updateSuggestForm.action = "insertSuggestBoard.do";
											document.updateSuggestForm.submit();
											return;
										});
					});
</script>
</head>
<body>
	<div align="center">
		<h3>배차신청</h3>
	</div>
	<br />
	<form method="post" id="updateSuggestForm" name="updateSuggestForm">

		<input type="hidden" name="id" value="${member.id }"> <input
			type="hidden" name="name" value="${member.name }" /> <input
			type="hidden" id="imsi_wido" name="imsi_wido" value="" /> <input
			type="hidden" id="imsi_kyungdo" name="imsi_kyungdo" value="" /> <input
			type="hidden" id="imsiJuso" name="imsiJuso" value="" /> <input
			type="hidden" id="start_wido" name="start_wido"
			value="${vo.start_wido }" /> <input type="hidden" id="start_kyungdo"
			name="start_kyungdo" value="${vo.start_kyungdo }" /> <input
			type="hidden" id="mid_wido" name="mid_wido" value="" /> <input
			type="hidden" id="mid_kyungdo" name="mid_kyungdo" value="" /> <input
			type="hidden" id="end_wido" name="end_wido" value="${vo.end_wido }" />
		<input type="hidden" id="end_kyungdo" name="end_kyungdo"
			value="${vo.end_kyungdo }" /> <input type="hidden" id="startJuso"
			name="startJuso" value="" /> <input type="hidden" id="endJuso"
			name="endJuso" value="" /> <input type="hidden" id="miduso"
			name="midJuso" value="" /> <input type="hidden" id="spanImsiKyungdo" />
		<input type="hidden" id="spanImsiWido" /> <input type="hidden"
			name="middate" value="" /> <input type="hidden" name="seq"
			value="${vo.seq }" />
		<table border="1" align="center">

			<tr>
				<td class="contenttd" width="100" align="center">작성자</td>
				<td width="700">${member.name }</td>
			</tr>

			<tr>
				<td width="100" align="center">제목</td>
				<td width="700"><input type="text" size="50" maxlength="50"
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
				<td colSpan="2">
					<table>
						<tr>
							<td>
								<h4>경로 선택</h4> &nbsp;&nbsp;&nbsp;&nbsp; 경유지가 있는 경우 필요하신 만큼 버튼을
								클릭해주세요&nbsp; <input type="button" value="경유지 추가+"
								onclick="appendItem()" />
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;1) 원하는 위치를 입력해주세요 → <input
								type="text" id="usertRegistMap_input" />&nbsp;<input
								type="button" value="검색" onclick="search()" /> &nbsp;&nbsp;ex)
								OO동
							</td>
						</tr>
						<tr>
							<td><div id="map" style="width: 800px; height: 300px;"></div></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;2) 검색 후, 정확한 위치를 마우스로 클릭해주세요<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;주소
								: <span id="spanImsiJuso"></span></td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;3) 확정하기<br>
								&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="startSetBt"
								value="출발지 확정" onClick="startSet()" />&nbsp;확정 출발지 : <span
								id="spanStartJuso"></span><br>
								<div id="itemList"></div>&nbsp;&nbsp;&nbsp;&nbsp;<input
								type="button" id="endSetBt" onClick="endSet()" value="도착지 확정" />&nbsp;확정
								도착지 : <span id="spanEndJuso"></span></td>
						</tr>
						<tr>
							<td>
								<h4>차종 선택</h4> <input type="radio" name="bus" value="45" checked>45인승
								대형 <input type="radio" name="bus" value="28">28인승 리무진 대형
								<input type="radio" name="bus" value="25">25인승 중형
							</td>
						</tr>
						<tr>
							<td>
								<h4>출발일시 선택</h4> <input type="datetime-local" id="startdate"
								name="startdate" required>
							</td>
						</tr>
						<tr>
							<td>
								<div id="midTimeDiv"></div>
							</td>
						</tr>
						<tr>
							<td>
								<h4>총 예상 소요시간</h4> <input type="number" name="finishtime"
								width="50">분
							</td>
						</tr>
						<tr>
							<td>
								<h4>승차금액</h4> <input type="number" id="pay" name="pay" 
								width="50">원
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					id="insertBoardbt" class="writebt" value="글쓰기" /> <input
					type="reset" class="writebt" value="다시작성" /> <a
					href="getSuggestBoardList.do"> <input type="button"
						class="contentbt" value="목록"></a></td>
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

		});
		//전송버튼 클릭이벤트
		$("#insertBoardbt").click(function() {
			//id가 ir1인 textarea에 에디터에서 대입
			oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);

			if ($("#startdate").val() == "") {
				alert("날짜와 시간을 입력해주세요.");
				return;
			}
			if ($("#pay").val() == "") {
				alert("승차요금을 입력해주세요.");
				return;
			}
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

			document.updateSuggestForm.submit();
			return;
		});

		window.addEventListener("load", function() {
			var now = new Date();
			var utcString = now.toISOString().substring(0, 19);
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var day = now.getDate();
			var hour = now.getHours();
			var minute = now.getMinutes();
			var second = now.getSeconds();
			var localDatetime = year + "-"
					+ (month < 10 ? "0" + month.toString() : month) + "-"
					+ (day < 10 ? "0" + day.toString() : day) + "T"
					+ (hour < 10 ? "0" + hour.toString() : hour) + ":"
					+ (minute < 10 ? "0" + minute.toString() : minute)
					+ utcString.substring(16, 19);
			var datetimeField = document.getElementById("startdate");
			datetimeField.value = localDatetime;
		});
	</script>
	<script type="text/javascript"
		src="../resources/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="../resources/js/userUpdateMapScript.js"></script>

	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>