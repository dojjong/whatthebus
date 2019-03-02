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
<b>"${vo.name }" </b>님의 결제가 정상적으로 처리되었습니다. <br/>아래 결제내역을 확인해 주세요.</td></tr>

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

<div align="center">
<!-- 
예약정보
예약테이블
 -->
<br>
<!-- 뿌려주기 -->
<input type="button" value="영수증출력" onClick="fnPrint()" /> 
<a href="main.do"><input type="button" value="메인페이지로 이동"></a>
<a href="getBookBoardList.do"><input type="button" value="배차조회목록으로 이동"></a>
</div>






<script type="text/javascript">
		var fnPrint = function() {
			var strFeature = "";
			strFeature += "width=700, height=500, all=no";
			var objWin = window.open('', 'print,strFeature');
			objWin.document.write("<div>");
			objWin.document.write("<div align='center'>");
			objWin.document.write("<br/>");
			objWin.document.write("<br/>");
			objWin.document.write("<table width='700'>");
			objWin.document.write("<tr>");
			objWin.document.write("<td>");
			objWin.document.write("<font size='5'>");
			objWin.document.write("<span style='color:red'>");
			objWin.document.write("<b>");	
			objWin.document.write("결제");
			objWin.document.write("</b>");	
			objWin.document.write("</span>");
			objWin.document.write("가");	
			objWin.document.write("<b>");
			objWin.document.write("완료");	
			objWin.document.write("</b>");
			objWin.document.write(" 되었습니다.");
			objWin.document.write("</font>");
			objWin.document.write("<br/>");
			objWin.document.write("<b>");
			objWin.document.write("${vo.name }");
			objWin.document.write("</b>");
			objWin.document.write("님의 결제가 정상적으로 처리되었습니다.");
			objWin.document.write("<br/>");
			objWin.document.write("아래 결제내역을 확인해 주세요.");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("</table>");
			objWin.document.write("</div>");
			
			objWin.document.write("<br/>");
			objWin.document.write("<br/>");
			objWin.document.write("<table align='center' width='500'>");
			objWin.document.write("<tr>");
			objWin.document.write("<td colspan='2' align='left'>");
			objWin.document.write("결제완료내역");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("</table>");
			
			objWin.document.write("<table width='500' align='center' border='1px'>");
			objWin.document.write("<tr class='bottom'>");
			objWin.document.write("<td class='color'>");
			objWin.document.write("이름");
			objWin.document.write("</td>");
			objWin.document.write("<td>");
			objWin.document.write("&nbsp;");
			objWin.document.write("${vo.name }");
			objWin.document.write("</td>");
			objWin.document.write("<tr>");
			objWin.document.write("<tr class='bottom'>");
			objWin.document.write("<td class='color'>");
			objWin.document.write("좌석번호");
			objWin.document.write("</td>");
			objWin.document.write("<td>");
			objWin.document.write("&nbsp;");
			objWin.document.write("${vo.sitnum }");
			objWin.document.write("번");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("<tr class='bottom'>");
			objWin.document.write("<td class='color'>");
			objWin.document.write("결제금액");
			objWin.document.write("</td>");
			objWin.document.write("<td>");
			objWin.document.write("&nbsp;");
			objWin.document.write("${vo.pay }");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("<tr class='bottom'>");
			objWin.document.write("<td class='color'>");
			objWin.document.write("결제일시");
			objWin.document.write("</td>");
			objWin.document.write("<td>");
			objWin.document.write("&nbsp;");
			objWin.document.write(<%=year %>);
			objWin.document.write("년");
			objWin.document.write(<%=month+1 %>);
			objWin.document.write("월");
			objWin.document.write(<%=day %>);
			objWin.document.write("일");
			objWin.document.write(<%=hour %>);
			objWin.document.write("시");
			objWin.document.write(<%=minute %>);
			objWin.document.write("분");
			objWin.document.write(<%=second %>);
			objWin.document.write("초");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("<tr class='bottom'>");
			objWin.document.write("<td class='color'>");
			objWin.document.write("결제수단");
			objWin.document.write("</td>");
			objWin.document.write("<td>");
			objWin.document.write("&nbsp;");
			objWin.document.write("${vo.selectpay }");
			objWin.document.write("</td>");
			objWin.document.write("</tr>");
			objWin.document.write("</table>");
			objWin.document.write("</div>");
	
 
			
			objWin.print();
			objWin.close();
			
		};
</script>



</body>
</html>