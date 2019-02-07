<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커 클러스터러에 클릭이벤트 추가하기</title>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9c7768efbf95af2e0039c27fd0b2cb6d&libraries=services,clusterer,drawing"></script>
    <script type="text/javascript" src="../js/adminClusterMap.js"></script>
</head>
<body>
	<div id="map" style="width:100%;height:350px;"></div>
	
	<form action="#" method="post" id="clusterForm">
			<c:forEach var="vo" items="${list }">
				<input type="text" id="start_wido" name="start_wido" value="${vo.start_wido }" />
				 <input type="text" id="start_kyungdo" name="start_kyungdo" value="${vo.start_kyungdo }" />
				 <input type="text" id="end_wido" name="end_wido" value="${vo.end_wido }" />
				 <input type="text" id="end_kyungdo" name="end_kyungdo" value="${vo.end_kyungdo }" />
				 <script type="text/javascript" >myAddMarker()</script>
			</c:forEach>
	</form>
	<script type="text/javascript" src="../js/adminClusterMap.js"></script>
</body>
</html>