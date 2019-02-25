<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<style>
#tb01{
 width: 700px;

}

#tb02{
	border-top: 3px solid rgb(49, 100, 176);
    border-bottom: 3px solid rgb(49, 100, 176);
    width: 700px;
}

.color{
background-color: rgb(247, 248, 250);
text-align: center;
color: rgb(49, 100, 176);
}

.bottom{
border-bottom: 1px solid rgb(225, 226, 230);
}
</style>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>

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

<div>

<div align="center">
<br/>
<br/>
<table id="tb01">
<tr><td><i class='far fa-address-card' style='font-size:100px;color:rgb(49, 100, 176)'></i></td>
<td>&nbsp;&nbsp;&nbsp;</td>
<td><font size="5"><span style="color:red"><b>결제</b></span>가 <b>완료</b>되었습니다.</font><br/> 
<b>"${vo.name }" </b>님의 결제가 정상적으로 처리되었습니다. 아래 결제내역을 확인해 주세요.</td></tr>

</table>

</div>
<br/>
<br/>
<table align="center" width="700">
<tr><td align="left">
<i class='fas fa-arrow-alt-circle-right' style='font-size:20px'></i>&nbsp;결제완료내역</td>
<td></td>
</tr>
</table>

<table id="tb02" align="center">


<tr class="bottom"><td class="color">이름</td> <td>&nbsp;${vo.name }</td><tr>
<tr class="bottom"><td class="color">좌석번호</td> <td>&nbsp;${vo.sitnum }번</td></tr>
<tr class="bottom"><td class="color">결제금액</td> <td>&nbsp;${vo.pay }</td></tr>
<tr class="bottom"><td class="color">결제일시</td> <td>&nbsp;<%=year %>년 <%=month+1 %>월 <%=day %>일 <%=hour %>시 <%=minute %>분<%=second %>초</td></tr>
<tr class="bottom"><td class="color">결제수단</td> <td>&nbsp;${vo.selectpay }</td></tr>


</table>

</div>

</body>
</html>