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
<script>

$("#registBt").click(function() {
		document.form.action = "insertBanner.do";
		document.form.submit();
		document.form.action = "getBannerList.do";
		document.form.submit();
		return;
})
</script>
</head>
<body>

	<!-- 
<form action="main_banner_center.do" method="post">
<input type="text" id="banner02" name="c_banner_01" value="${param['c_banner_01'] }">
<input type="submit" value="확인">
</form>
 -->

	<form name="form" method="post" action="insertBanner.do"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>배너등록</td>
				<td><input type="file" id="insertBanner" name="uploadBanner"></td>
				<td><input type="button" id="registBt" value="등록" /></td>
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





</body>
</html>