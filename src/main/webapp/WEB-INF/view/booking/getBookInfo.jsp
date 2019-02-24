<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
Calendar c = Calendar.getInstance(); 
int year = c.get(Calendar.YEAR);
int month = c.get(Calendar.MONTH);
int day = c.get(Calendar.DATE);
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
%>

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
			<td><%=year %>년 <%=month+1 %>월 <%=day %>일 <%=hour %>시 <%=minute %>분<%=second %>초</td>
            <td>${vo.selectpay }</td>
           
            
           
</tr>


</table>



</body>
</html>