<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="../resources/css/bookingStyle.css" />
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

</head>
<body>

	<form id="payform" name="payform" action="bookingPay.do" method="post">
		<!-- 화면 센터 -->
		<input type="hidden" name="busseq" value="${vo.seq }"> <input
			type="hidden" name="id" value="${member.id }"> <input
			type="hidden" id="pname" name="name" value="${member.name }">
		<input type="hidden" id="tel" name="tel" value="${member.tel }">
		<input type="hidden" id="pay" name="pay" value="${vo.pay }"> <input
			type="hidden" id="sitnum" name="sitnum"> <input type="hidden"
			name="email" value="${member.email }"> <input type="hidden"
			id="title" name="title" value="${vo.title }">
		<table align="center">
			<tr>
				<td><div align="left">
						<h1>좌석정보</h1>
						<c:forEach var="num" begin="1" end="${vo.bus }" step="1"
							varStatus="status">
							<!-- 여기에 결제테이블에 정보가 있으면 이미 결제좌석인것 표시 -->
							<!-- 25인승 와꾸 -->
							<c:if test="${status.count%4==1 }">
								<br />
							</c:if>
							<c:if test="${status.count%2==1}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
							<c:set var="doneLoop" value="false" />
							<c:forEach items="${bussit }" varStatus="busstatus">

								<c:if test="${bussit[busstatus.index]==status.count}">
									<input type="button" class="sitNum" value="있는좌석"
										onclick="full()" />
									<c:set var="doneLoop" value="true" />
								</c:if>
							</c:forEach>
							<c:if test="${not doneLoop}">
								<input type="button" class="sitNum" value="${status.count }"
									onclick="sit(this.value)" />
							</c:if>
						</c:forEach>
					</div></td>
				<td>
					<div>
						<table>
							<tr>
								<td><h1>버스 경로정보</h1></td>
							<tr>
								<td align="left">노선명</td>
								<td>${vo.title }</td>
							</tr>
							<tr>
								<td>지도정보</td>
								<td>
									<!-- 기사님이 올린 해당버스 지도(경로) 디비에서 불러오기 -->해당 버스 지도
								</td>
							</tr>

							<tr>
								<td><h1>신청 정보</h1></td>
							</tr>
							<tr>
								<td>신청인 &nbsp;</td>
								<td>${member.name }</td>
							</tr>
							<tr>
								<td>연락처 &nbsp;</td>
								<td>${member.tel }</td>
							</tr>


							<tr>
								<td><h1>결제정보</h1></td>
							</tr>
							<tr>
								<td>결제수단</td>

								<td>
									<table>
										<tr>
											<td><input type="radio" name="selectpay" value="cardPay">신용카드</td>
											<td><input type="radio" name="selectpay"
												value="kakaoPay">카카오페이</td>
											<td><input type="radio" name="selectpay"
												value="phonePay">휴대폰결제</td>
										</tr>
										<!-- 추가 결제수단 -->
									</table>
								</td>
							</tr>
							<tr>
								<td><h2>신청동의</h2></td>
							</tr>
							<tr>
								<td colspan="3"><input type="checkbox"
									name="conditionsCheck" id="conditionsCheck" value="true">
									이용권 구매 및 결제대행서비스에 이용약관 등에 모두 동의합니다.</td>
							</tr>
							<tr>
								<td id="agree">
									<li>구매조건 확인 및 결제 진행 동의</li>
									<li>개인정보 수집 이용 및 제 3자 정보 제공 동의</li>
									<li>결제대행서비스 이용약관 동의</li>
								</td>
						</table>
					</div>
				</td>
				<td>
					<div align="right">
						<table>

							<tr>
								<td><h1>결제 금액</h1></td>
							</tr>
							<tr>
								<td>이용금액&nbsp;</td>
								<td align="left"><strong> ${vo.pay } </strong>원</td>
							</tr>

							<tr>
								<td><h3>최종 결제금액</h3></td>
							</tr>
							<tr>
								<td align="right" colspan="2"><strong> ${vo.pay }
								</strong>원</td>
							</tr>
							<tr>
								<td colspan="2"><input type="button" id="paybt"
									value="결제하기"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</form>
	<script>
		function sit(num) {
			document.payform.sitnum.value = num;
		}
		function full() {
			alert("다른 좌석을 골라주세요.");
		}
		$("#paybt").click(function() {
			if ($("input[name=conditionsCheck]:checked").val() != "true") {
				alert("이용약관 동의를 해주세요.");
				return;
			}
			if (document.payform.sitnum.value == 0) {
				alert("좌석을 선택해주세요.");
				return;
			}
			if (document.payform.sitnum.value == "") {
				alert("좌석을 선택해주세요.");
				return;
			}
			if (document.payform.id.value == "") {
				alert("로그인 후 이용해주세요.");
				return;
			}

			var IMP = window.IMP; // 생략가능
			IMP.init('imp11074230'); // 가맹점 식별 코드

			IMP.request_pay({
				pg : 'kakao', // 결제방식
				pay_method : 'card', // 결제 수단
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : $("#title").val(), // order 테이블에 들어갈 주문명 혹은 주문 번호
				amount : $("#pay").val(), // 결제 금액
				buyer_email : $("#email").val(), // 구매자 email
				buyer_name : $("#pname").val(), // 구매자 이름
				buyer_tel : $("#tel").val(), // 구매자 전화번호
				buyer_addr : '', // 구매자 주소
				buyer_postcode : '', // 구매자 우편번호
				m_redirect_url : 'http://localhost:8080/bus/view/bookingPay.do' // 결제 완료 후 보낼 컨트롤러의 메소드명
			}, function(rsp) {
				if (rsp.success) { // 성공시
					var msg = '결제가 완료되었습니다.';
					msg += '고유ID : ' + rsp.imp_uid;
					msg += '상점 거래ID : ' + rsp.merchant_uid;
					msg += '결제 금액 : ' + rsp.paid_amount;
					msg += '카드 승인번호 : ' + rsp.apply_num;
					document.payform.submit();
				} else { // 실패시
					var msg = '결제에 실패하였습니다.';
					msg += '에러내용 : ' + rsp.error_msg;

				}
			});

		});
	</script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>

</html>