<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<style>
/* 빨간선-확인용 삭제 할겁니다!*/
div {
	border: 1px solid red;
}

table {
	border: 1px solid red;
}

tr {
	border: 1px solid red;
}

td {
	border: 1px solid red;
}
/* 구간 확인용 삭제 할겁니다!*/

</style>

</head>
<body>

성공적으로 예약/결제가 완료되었습니다.

<jsp:include page="../booking/getBookInfo.jsp"></jsp:include>

예약정보
예약테이블
<br>
<!-- 뿌려주기 -->
<a href="main.do"><input type="button" value="메인페이지로 이동"></a>
<a href="getBookBoardList.do"><input type="button" value="배차조회목록으로 이동"></a>

</body>
</html>