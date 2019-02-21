<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">

<tr>
<th>이미지경로</th>
</tr>

<c:forEach var="row" items="${list }">
<tr><td>${row.bannername }</td></tr>
</c:forEach>
</table>


</body>
</html>