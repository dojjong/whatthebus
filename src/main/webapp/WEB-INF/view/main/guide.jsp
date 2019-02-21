<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  padding: 5px;

}
</style>

</head>
<body>
<h2 align="center">이용가이드</h2>

<div align="center">

<table>
<tr><td colspan="5">


<div align="center">
<img src="../resources/images/guide2.png" width="100px" height="100px">

<h3>개인사용자</h3>
</div>

<table align="center">
  
  <tr>
   <td><img src="../resources/images/guide4.png" width="100px" height="100px">
</td>
   <td><b>1.회원가입 및 로그인</b><br><br>사이트를 이용하기 위해 일반 손님으로 회원가입 후 로그인을 합니다.</td>
  </tr>
  
  <tr>
  <td><img src="../resources/images/guide7.png" width="100px" height="100px">
</td>
	<td><b>2.견적요청</b><br><br>개인이 신청시 <a href="getBoardList.do">제안</a> 을 눌러 출발지와 도착지를 기입합니다.</td>
  </tr>
  
    <tr>
   <td><img src="../resources/images/guide8.png" width="100px" height="100px">
</td>
   <td><b>3.견적통보</b><br><br>개인이 작성한 글이 일정 추천수를 받게 되면 배차대기 상태로 넘어가게 됩니다.</td>
  </tr>
  
   
  <tr>
   <td><img src="../resources/images/guide9.png" width="100px" height="100px">
</td>
   <td><b>4.견적확인</b><br><br>자세한 출발일시, 소요시간, 금액확인은 예약게시판의 배차조회에서 조회가 가능합니다.</td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide5.png" width="100px" height="100px">
</td>
   <td><b>5.결제하기</b><br><br>조회게시판의 배차대기에 들어가 좌석선택을 하고 결제를 합니다.</td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide10.png" width="100px" height="100px">
</td>
   <td><b>6.버스이용</b><br><br>버스 이용전 자세한 질문은 <a href="getQaBoardList.do">QnA</a>를 이용하거나 버스 이용후 물건 분실시는 분실물서비스를 이용하시면 됩니다.</td>
  </tr>

</table>

<table>
<div align="center">
<img src="../resources/images/guide12.png" width="100px" height="100px">

<h3>단체사용자</h3>
</div>

  <table align="center">
  <tr>
   <td><img src="../resources/images/guide4.png" width="100px" height="100px">
</td>
   <td><b>1.회원가입 및 로그인</b><br><br>사이트를 이용하기 위해 일반 손님으로 회원가입 후 로그인을 합니다.</td>
  </tr>
  
    <tr>
  <td><img src="../resources/images/guide7.png" width="100px" height="100px">
</td>
	<td><b>2.견적요청</b><br><br>단체로 신청시 <a href="getAfterBoardList.do">대절신청</a>을 눌러 출발지와 도착지를 기입합니다.</td>
  </tr>
  
    <tr>
   <td><img src="../resources/images/guide8.png" width="100px" height="100px">
</td>
   <td><b>3.견적통보</b><br><br>작성한 글이 일정 추천수를 받게 되거나 수용인원이 맞는다면 배차대기 상태로 넘어가게 됩니다.</td>
  </tr>
  
   
  <tr>
   <td><img src="../resources/images/guide9.png" width="100px" height="100px">
</td>
   <td><b>4.견적확인</b><br><br>자세한 출발일시, 소요시간, 금액확인은 예약게시판의 배차조회에서 조회가 가능합니다.</td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide5.png" width="100px" height="100px">
</td>
   <td><b>5.결제하기</b><br><br>조회게시판의 배차대기에 들어가 좌석선택을 하고 결제를 합니다.</td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide10.png" width="100px" height="100px">
</td>
   <td><b>6.버스이용</b><br><br>버스 이용전 자세한 질문은 <a href="getQaBoardList.do">QnA</a>를 이용하거나 버스 이용후 물건 분실시는 분실물서비스를 이용하시면 됩니다.</td>
  </tr>

</table>
  
<table>
<div align="center">
<img src="../resources/images/guide3.png" width="100px" height="100px">

<h3>버스기사</h3>
</div>

  <table align="center">
  <tr>
   <td><img src="../resources/images/guide4.png" width="100px" height="100px">
</td>
   <td><b>1.회원가입 및 로그인</b><br><br>사이트를 이용하기 위해 기사님으로 회원가입 후 로그인을 합니다.</td></td>
  </tr>
  
    <tr>
  <td><img src="../resources/images/guide13.png" width="100px" height="100px">
</td>
	<td><b>2.배차신청</b><br><br>기사님이 직접 제안을 올려도 되고, <a href="getSuggestBoardList.do">배차대기</a>에 있는 목록들 중에서<br>운행하고자 하는 글의 배차신청을 눌러 경유지 추가와 자세한 견적을 입력하실수 있습니다.</td>
  </tr>
  
    <tr>
   <td><img src="../resources/images/guide6.png" width="100px" height="100px">
</td>
   <td><b>3.견적확인</b><br><br>배차신청이 완료된 경우엔 배차상태가 완료가 됩니다.</td>
  </tr>
  
   
  <tr>
   <td><img src="../resources/images/guide14.png" width="100px" height="100px">
</td>
   <td><b>4.준비완료</b><br><br>모든 준비가 끝났습니다. 안전운전 하시길 바랍니다. </td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide5.png" width="100px" height="100px">
</td>
   <td><b>5.결제하기</b><br><br>조회게시판의 배차대기에 들어가 좌석선택을 하고 결제를 합니다.</td>
  </tr>
  
    
  <tr>
   <td><img src="../resources/images/guide10.png" width="100px" height="100px">
</td>
   <td><b>6.버스이용</b><br><br>버스 이용전 자세한 질문은 <a href="getQaBoardList.do">QnA</a>를 이용하거나 버스 이용후 물건 분실시는 분실물서비스를 이용하시면 됩니다.</td>
  </tr>

</table>
    
</table>


<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>
