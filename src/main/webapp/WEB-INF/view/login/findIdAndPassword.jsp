<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
</style>

</head>
<body>



<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'id')">아이디찾기</button>
  <button class="tablinks" onclick="openCity(event, 'password')">비밀번호재설정</button>

</div>

<div id="id" class="tabcontent">

	<h3>아이디찾기</h3>
	<table>
			
<form:form id="signupform" role="form" modelAttribute="memberVO" 
action="../member/findId.do" method="post">
		
		
				<tr>
					<td align="right"width="200">이름 :&nbsp;</td>
					<td align="left" width="500"><input type="text" name="Name" value="${memberVO.name}" placeholder="이름을 작성해주세요."></td>
				</tr>
				
				<tr>
				<td><div style="color:red ; margin-top:2px" >
                     <form:errors path="name"/>
                     <form:errors/></div>
                     </td>
				</tr>
				
				
				
				<tr>
					<td align="right">이메일 :&nbsp;</td>
					<td align="left"><input type="text" name="Email" value="${memberVO.email}" placeholder="이메일을 작성해주세요"></td>
				</tr>
				<tr>
				<td><div style="color:red ; margin-top:2px" >
                     <form:errors path="email"/>
                     <form:errors/></div>
                     </td>
				</tr>
	
				<tr>
				<td colspan="2" align="center">가입하신 이메일로 아이디를 전송해드리겠습니다.</td>
				</tr>
			<tr><td colspan="2" align="center">
			<button type="submit">확인</button></td></tr>
		</form:form>
			</table>

</div>



<div id="password" class="tabcontent">
<h3>비밀번호 재설정</h3>
<table>
		
				<tr>
					<td align="right"width="200">이름 :&nbsp;</td>
					<td align="left" width="500"><input type="text">&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right"width="200">아이디 :&nbsp;</td>
					<td align="left" width="500"><input type="text">&nbsp;</td>
				</tr>
				
				<tr>
					<td align="right">이메일 :&nbsp;</td>
					
					<td align="left"><input type="text"><br /></td>
				</tr>
			
			<tr>
				<td colspan="2" align="center">확인버튼을 누르면 인증번호 입력 화면으로 넘어갑니다.</td>
				</tr>
			
			<tr><td colspan="2" align="center">
			<input type="button" value="확인"  /></td></tr>
		
		
		</table>
</div>





<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
   
</body>
</html> 
