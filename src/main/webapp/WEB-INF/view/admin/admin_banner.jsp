<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>


<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<!-- 
<form action="main_banner_center.do" method="post">
<input type="text" id="banner02" name="c_banner_01" value="${param['c_banner_01'] }">
<input type="submit" value="확인">
</form>
 -->

	<form id="ajaxForm" name="ajaxForm" method="post"
		action="insertBanner.do" enctype="multipart/form-data">
		<table>
			<tr>
				<td>배너등록</td>
				<td><%-- <input type="file" id="uploadBanner" name="uploadBanner">--%></td>
				<td><input type="submit" id="registBt" value="등록" /></td>
			</tr>
		</table>
	</form>

	<div id="view">
		<c:if test="${list!=null}">



			<table border="1">

				<tr>
					<th>이미지경로</th>
				</tr>

				<c:forEach var="row" items="${list }">
					<tr>
						<td>${row.bannername }</td>
					</tr>
				</c:forEach>
			</table>

		</c:if>
	</div>



	<script>
		//function insertBanner() {
			//alert(document.form.uploadBanner.value);
			//var form = $('#bannerForm')[0];
			//var formData = new FormData(form);
			//formData.append("fileObj", $("#uploadBanner")[0].files[0]);
			//$('#ajaxform').ajaxForm({
				//보내기전 validation check가 필요할경우 beforeSubmit: 
				//function (data, frm, opt) { alert("전송전!!"); return true; }, 
				//submit이후의 처리 
			//	success : function(responseText, statusText) {
			//		alert("전송성공!!");
			//	},
				//ajax error 
			//	error : function() {
			//		alert("에러발생!!");
			//	}
			//});

			//var uploadBanner;
			//alert("var:" + uploadBanner);
			//document.form.uploadBanner.value = uploadBanner;
			//alert("var2:"+uploadBanner);
			/*alert("얼럿 : " + formData);
			$.ajax({
				type : "POST",
				url : "insertBanner.do",
				data : formData,
				success : function(data) {
					if (data == "success") {
						alert("등록되었습니다.");
						//document.updateDriverForm.action = "refreshApprovalDriverList.do";
						//document.updateDriverForm.submit();
						$("#result").load("getBannerList.do");
						return;
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});*/
	//	}
	</script>


</body>
</html>