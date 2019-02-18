<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
  border-style: solid;
  border-width: 1px; 
  width: 120px;
  height: 120px;
}

fieldset { 
  display: block;
  margin-left: 2px;
  margin-right: 2px;
  padding-top: 0.35em;
  padding-bottom: 0.625em;
  padding-left: 0.75em;
  padding-right: 0.75em;
  border: 2px groove (internal value);
}

</style>

</head>
<body>
<div align="center">

<table>
<tr><td colspan="5">
<h3>이용절차</h3></td></tr>



<tr><td><p>요청하기</p></td>

<td><p>견적받기<br>(이메일,핸드폰)<br></p></td>

<td><p>견적검토 및 상담하기</p></td>

<td><p>결제하기</p></td>

<td><p>버스임대</p></td>

</tr>

<tr>
<td colspan="5">
<h3>개인사용자의 경우 </h3>

<fieldset>
<legend>1. 견적요청</legend><br>
개인의 경우 제안(개인)게시판에 원하시는 출발지와 경유지를 선택하여 글을 작성합니다.
</fieldset>
<h3>2. 견적통보</h3><br>
제안(개인)게시판에 작성한 글이 추천수(--이상)을 받게 되면 배차대기 상태가 됩니다. 


<h3>3. 견적확인</h3><br>
예약게시판의 배차조회에서 조회가 가능합니다. 

<h3>4. 결제하기</h3>
배차조회에서 원하시는 글을 선택하여 좌석선택 및 결제

<h3>5. 버스이용 </h3>

<br>
<br>
<br>

<h3>버스 대절(단체)의 경우</h3>

<h3>1. 견적요청</h3><br>
개인의 경우 제안(개인)게시판에 원하시는 출발지와 경유지를 선택하여 글을 작성합니다.

<h3>2. 견적통보</h3><br>
제안(개인)게시판에 작성한 글이 추천수(--이상)을 받게 되면 배차대기 상태가 됩니다. 


<h3>3. 견적확인</h3><br>
예약게시판의 배차조회에서 조회가 가능합니다. 

<h3>4. 결제하기</h3>
배차조회에서 원하시는 글을 선택하여 좌석선택 및 결제

<h3>5. 버스이용 </h3>

<br>
<br>
<br>

<h3>기사님의 경우</h3>

<h3>1. 견적요청</h3><br>
개인의 경우 제안(개인)게시판에 원하시는 출발지와 경유지를 선택하여 글을 작성합니다.

<h3>2. 견적통보</h3><br>
제안(개인)게시판에 작성한 글이 추천수(--이상)을 받게 되면 배차대기 상태가 됩니다. 


<h3>3. 견적확인</h3><br>
예약게시판의 배차조회에서 조회가 가능합니다. 

<h3>4. 결제하기</h3>
배차조회에서 원하시는 글을 선택하여 좌석선택 및 결제

<h3>5. 버스이용 </h3>




</table>

<form>
 <fieldset>
  <legend>Personalia:</legend>
  Name: <input type="text"><br>
  Email: <input type="text"><br>
  Date of birth: <input type="text">
 </fieldset>
</form>




</div>



<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>