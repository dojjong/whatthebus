<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<style>
nav {
	color: black;
	float: left;
	width: 30%;
	margin-left: 100px;
	margin-top: 10px;
}

article {
  float: left;
  
}

@mypageul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 100px;
  background-color: #f1f1f1;
}

li a{

  display: block;
  font-color: black;
  padding: 8px 16px;
  text-decoration: none;
 
}

/* Change the link color on hover */
li a:hover {
  background-color: rgb(49, 100, 176);
  color: white;
}




</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<aside id="left">
	<nav>
			<ul style="list-style-type:none;" id="mypageul">
				<li><a href="../driver/updateCheckDriver.jsp">회원정보수정</a></li>
				<li><a href="../driver/pwCheckDriver.jsp">비밀번호변경</a></li>
				<li><a href="../driver/deleteDriver.jsp">회원탈퇴</a></li>
				
				
			</ul>
	
	
	
	
	
			
	</nav>

</aside>
	<section>

	

		<article>
		
		<!-- 
										<table>
			<tr>
			<td><form method="post" action="../driver/pwCheckDriver.jsp">
			<input type="submit" value="비밀번호 변경" class="mainbt">
			</form></td>
			</tr>
			
			<tr>
			<td><form method="post" action="../driver/updateCheckDriver.jsp">
			<input type="submit" value="회원정보 수정" class="mainbt">
			</form></td>
			</tr>
			
			<tr>
			<td><form method="post" action="logoutDriver.do">
				<input type="submit" value="로그아웃" class="mainbt">
				</form></td>
			</tr>
		
		
		</table>
										
										
										
										
										
			
									 -->	
		
		
		</article>

	</section>

	<footer>
		<jsp:include page="../main/mainFooter.jsp"></jsp:include>
	</footer>
</body>
</html>