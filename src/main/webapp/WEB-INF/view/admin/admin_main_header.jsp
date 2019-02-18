<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>What The Bus 관리자화면</title>

</head>
<body>

<div class="container">


		
		<table>
			
					<%-- 세션에 저장된 값이 있으면 보여지는 화면 --%>
			<%-- 라이센스가 null이냐 아니냐로 보여지는 화면 구분 --%>
			<c:choose>
				<c:when test="${member ne null }">
					<c:if test="${member.license==null }">


						<div align="right">
							<table>
								<tr>
									<td>${member.name }회원님환영합니다.&nbsp;</td>
									<!-- 
									<td><form method="post"
											action="../member/pwCheckMember.jsp">
											<input type="submit" value="비밀번호 변경" class="mainbt">
										</form></td>
									<td><form method="post"
											action="../member/updateCheckMember.jsp">
											<input type="submit" value="회원정보 수정" class="mainbt">
										</form></td>
									<td><form method="post" action="logoutMember.do">
											<input type="submit" value="로그아웃" class="mainbt">
										</form></td>
										 -->
							</table>
						</div>
					</c:if>

					<c:if test="${member.license!=null }">
						<div align="right">
							<table>
								<tr>
									<td width="90px" align="center"><a href="../driver/driverMypage.jsp">마이페이지</a></td>
									<td width="150px" align="center">${member.name }기사님<br>환영합니다.</td>
									<td><form method="post" action="logoutDriver.do"><input type="submit" value="로그아웃" class="btn btn-link"></form></td>
									
									<!-- 
									<td><form method="post"
											action="../driver/pwCheckDriver.jsp">
											<input type="submit" value="비밀번호 변경" class="mainbt">
										</form></td>
									<td><form method="post"
											action="../driver/updateCheckDriver.jsp">
											<input type="submit" value="회원정보 수정" class="mainbt">
										</form></td>
									<td><form method="post" action="logoutDriver.do">
											<input type="submit" value="로그아웃" class="mainbt">
										</form></td>
									 -->	
							</table>
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
	
				</c:otherwise>
			</c:choose>
			
			
	
			
</table>
			

<h3>관리자화면입니다.</h3>
<table>
<tr>
<td width="250px">
  <ul class="nav nav-pills nav-stacked">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">통계(임시)<span class="caret"></span></a>
      
      <ul class="dropdown-menu">
        <li><a href="../admin/admin_chart.jsp" >차트(임시)</a></li>
        <li><a href="#" >보고서(임시)</a></li>
        <li><a href="../admin/admin_map.jsp" >지도(임시)</a></li>           
      </ul>
    </li>

   <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원관리(임시)<span class="caret"></span></a>
      
      <ul class="dropdown-menu">
        <li><a href="#">전체회원목록</a></li>
        <li><a href="#">가입승인대기(드라이버)</a></li>
      </ul>
    </li>

<li><a href="#">결제용(임시)</a>
<li><a href="#" >(임시:결제화면)</a></li>
<li><a href="moveSetBestCount.do">게시판 추천 수 변경</a></li>
  
  </ul>
  </td>
  </tr>
</table>
</div>





					
						
			</div>
		</header>
	</div>
	<!-- container -->

	

</body>
</html>