<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

결제내역
<table>
<tr>
<th>버스번호</th>
<th>결제수단</th>
<th>자리번호</th>
<th>결제금액</th>
<th>결제일시</th>
</tr>


<c:forEach var="row" items="${list }">
<tr>
<td>${row.busseq }</td>
<td>${row.selectpay }</td>
<td>${row.sitnum }</td>
<td>${row.pay }</td>
<td>${row.realregdate }</td>
</tr>
</c:forEach>



</table>

</body>
</html>