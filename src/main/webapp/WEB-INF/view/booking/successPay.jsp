<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>


</head>
<body>

<jsp:include page="../booking/getBookInfo.jsp"></jsp:include>

<div align="center">
<!-- 
예약정보
예약테이블
 -->
<br>
<!-- 뿌려주기 -->
<a href="main.do"><input type="button" value="메인페이지로 이동"></a>
<a href="getBookBoardList.do"><input type="button" value="배차조회목록으로 이동"></a>
</div>

<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>