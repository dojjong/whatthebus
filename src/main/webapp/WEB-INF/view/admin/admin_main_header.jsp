
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<title>What The Bus 관리자화면</title>

</head>
<body>

	<div class="container">



		<table>
			<tr>
			<td><a href="main.do"><input type="text" value="홈으로"></a></td></tr>

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
									<td width="90px" align="center"><a
										href="../driver/driverMypage.jsp">마이페이지</a></td>
									<td width="150px" align="center">${member.name }기사님<br>환영합니다.
									</td>
									<td><form method="post" action="logoutDriver.do">
											<input type="submit" value="로그아웃" class="btn btn-link">
										</form></td>

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


</div>

</body>
</html>