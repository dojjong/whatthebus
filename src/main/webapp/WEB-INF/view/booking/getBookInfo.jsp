<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>



<table>
<tr>
<td>이름</td>
<td>좌석번호</td>
<td>결제금액</td>
<td>결제일시</td>
<td>결제수단</td>
</tr>


<tr>
			<td>${vo.name }	</td>
			<td>${vo.sitnum }</td>
			<td>${vo.pay }</td>
			<td>${vo.regdate }</td>
            <td>${vo.selectpay }</td>
           
            
           
</tr>


</table>


</body>
</html>