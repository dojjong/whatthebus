<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>

	<div align="center">
		<form name="form" method="post" action="insertNaverMember.do">
		<input type="hidden" name="id" value="${member.id }">
			<table>
				<tr>
					<td id="welcome" colspan="3" align="center">What The Bus에 오신것을
						환영합니다 !</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<h4>원활한 서비스 이용을 위해 추가정보를 입력해주세요.</h4>
					</td>
				</tr>

				<tr>
					<td align="right">이름 :&nbsp;</td>
					<td align="left"><input type="text" id="insertName"
						name="name" value="${member.name }" /> &nbsp; <font color="red">
							<span id="nameMessage"> </span>
					</font></td>
				</tr>
				<tr>
					<td align="right">성별 : &nbsp;</td>
					<td align="left"><input type="radio" id="insertGender1"
						name="gender" value="M">남성 <input type="radio"
						id="insertGender2" name="gender" value="F">여성&nbsp;&nbsp;
						<font color="red"> <span id="genderMessage"> </span></font></td>
				</tr>


				<tr>
					<td align="right">전화번호 :&nbsp;</td>
					<td align="left"><select id="insertTel1" name="tel1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
					</select>- <input type="text" id="insertTel2" name="tel2" size="2" value="" />
						- <input type="text" id="insertTel3" name="tel3" size="2" value="" />
						&nbsp; <font color="red"><span id="telMessage"> </span></font></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="reset"
						class="insertbt" value="다시입력" />&nbsp;&nbsp; <input type="submit"
						id="insertCheckbt" class="insertbt" value="수정완료" />&nbsp;&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>
</html>