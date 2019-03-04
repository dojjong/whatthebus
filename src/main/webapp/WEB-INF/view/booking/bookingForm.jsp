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

<style>
.tb_td {
	height: 50px;
	vertical-align: top;
}
</style>

</head>
<body>
	<br />
	<div>


		<form id="payform" name="payform" action="bookingPay.do" method="post">
			<!-- 화면 센터 -->
			<input type="hidden" name="busseq" value="${vo.seq }"> <input
				type="hidden" name="id" value="${member.id }"> <input
				type="hidden" id="pname" name="name" value="${member.name }">
			<input type="hidden" id="tel" name="tel" value="${member.tel }">
			<input type="hidden" id="pay" name="pay" value="${vo.pay }">
			<input type="hidden" id="sitnum" name="sitnum"> <input
				type="hidden" name="email" value="${member.email }"> <input
				type="hidden" id="title" name="title" value="${vo.title }">
			<input type="hidden" id="memberPoint" name="memberPoint"
				value="${point }">

			<table align="center" width="1024px">
				<!-- 전체 화면 끝나는 제일 큰 테이블 -->
				<tr>
					<td class="tb_td">


						<table align="center">
							<!-- 좌석정보 테이블 -->
							<tr>
								<td><h4>좌석정보</h4></td>
							</tr>
							<tr>
								<td><c:forEach var="num" begin="1" end="${vo.bus }"
										step="1" varStatus="status">
										<!-- 여기에 결제테이블에 정보가 있으면 이미 결제좌석인것 표시 -->
										<!-- 25인승 와꾸 -->
										<c:if test="${status.count%4==1 }">
											<br />
										</c:if>
										<c:if test="${status.count%2==1}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if>
										<c:set var="doneLoop" value="false" />
										<c:forEach items="${bussit }" varStatus="busstatus">

											<c:if test="${bussit[busstatus.index]==status.count}">
												<input type="button" class="onsitNum"
													value="${status.count }" onclick="full()" />
												<c:set var="doneLoop" value="true" />
											</c:if>
										</c:forEach>
										<c:if test="${not doneLoop}">
											<input type="button" class="sitNum" value="${status.count }"
												onclick="sit(this.value)" />
										</c:if>
									</c:forEach></td>
							</tr>
						</table> <!-- 좌석정보 테이블 -->
					<td class="tb_td">
						<table>
							<!-- 버스에 대한 정보 테이블 -->

							<tr>
								<td colspan="2"><h4>버스 경로정보</h4></td>
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
								<td colspan="2"><h4>신청 정보</h4></td>
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
								<td colspan="2"><h4>결제정보</h4></td>
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
								<td colspan="2"><h4>신청동의</h4></td>
							</tr>
							<tr>
								<td colspan="3"><input type="checkbox"
									name="conditionsCheck" id="conditionsCheck" value="true">
									이용권 구매 및 결제대행서비스에 이용약관 등에 모두 동의합니다.</td>
							</tr>
							<tr>
								<td colspan="2">
									<ul id="agree">
										<li>구매조건 확인 및 결제 진행 동의</li>
										<li>개인정보 수집 이용 및 제 3자 정보 제공 동의</li>
										<li>결제대행서비스 이용약관 동의</li>
									</ul>
								</td>
						</table> <!-- 버스에 대한 정보 테이블 -->
					</td>

					<td class="tb_td">
						<table>

							<tr>
								<td colspan="2"><h4>결제 금액</h4></td>
							</tr>
							<tr>
								<td>이용금액&nbsp;</td>
								<td align="left"><strong> ${vo.pay } </strong>원</td>
							</tr>
							<tr>
								<td>현재 포인트</td>
								<td><strong>${point }</strong>P</td>
							</tr>
							<tr>
								<td>사용 포인트</td>
								<td><input type="number" id="point" name="point" value=0
									onKeyUp="setPay();" onfocus="zeroPoint();"
									onblur="zeroCheck();">P</td>
							</tr>
							<tr>
								<td colspan="2"><font size="1">* 포인트는 300점 이상부터
										사용하실수 있습니다.<br />* 최소 1원 이상 결제하여야 합니다. <br />* 포인트는 결제금액의
										10%가 적립됩니다.(포인트사용제외)
								</font></td>
							</tr>
							<tr>
								<td colspan="2"><h4>최종 결제금액</h4></td>
							</tr>
							<tr>
								<td align="right" colspan="2"><strong><label
										id="setPayValue">${vo.pay }원</label></strong></td>
							</tr>
							<tr>
								<td colspan="2"><input type="button" id="paybt"
									value="결제하기"></td>
							</tr>
						</table> <!-- 결제정보에 대한 테이블 -->
					</td>
				</tr>



			</table>
			<!-- 전체 화면 끝나는 제일 큰 테이블 -->


		</form>



	</div>
	<br />
	<script>
		function sit(num) {
			document.payform.sitnum.value = num;
		}
		function full() {
			alert("다른 좌석을 골라주세요.");
		}
		function setPay() {
			$("#setPayValue").text(
					Number($("#pay").val()) - Number($("#point").val()) + "원");
		}
		function zeroPoint() {
			document.payform.point.value = "";
		}
		function zeroCheck() {
			if (document.payform.point.value == "") {
				document.payform.point.value = 0;
				$("#setPayValue").text($("#pay").val() + "원");
			}
		}
		$("#paybt")
				.click(
						function() {
							if ($("input[name=conditionsCheck]:checked").val() != "true") {
								alert("이용약관 동의를 해주세요.");
								return;
							}

							if (document.payform.point.value < 300
									&& document.payform.point.value != 0) {
								alert("포인트는 300점 이상 사용해주세요.");
								document.payform.point.value = 0;
								$("#setPayValue").text($("#pay").val() + "원");
								return;
							}

							if (Number($("#point").val()) > Number($("#pay")
									.val())) {
								alert("이용금액보다 큰 포인트는 사용하실수 없습니다.");
								document.payform.point.value = 0;
								$("#setPayValue").text($("#pay").val() + "원");
								return;
							}
							if (Number($("#memberPoint").val()) < Number($(
									"#point").val())) {
								alert("포인트가 부족합니다.");
								document.payform.point.value = 0;
								$("#setPayValue").text($("#pay").val() + "원");
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

							IMP
									.request_pay(
											{
												pg : 'kakao', // 결제방식
												pay_method : 'card', // 결제 수단
												merchant_uid : 'merchant_'
														+ new Date().getTime(),
												name : $("#title").val(), // order 테이블에 들어갈 주문명 혹은 주문 번호
												amount : $("#pay").val()
														- $("#point").val(), // 결제 금액
												buyer_email : $("#email").val(), // 구매자 email
												buyer_name : $("#pname").val(), // 구매자 이름
												buyer_tel : $("#tel").val(), // 구매자 전화번호
												buyer_addr : '', // 구매자 주소
												buyer_postcode : '', // 구매자 우편번호
												m_redirect_url : 'http://localhost:8080/bus/view/bookingPay.do' // 결제 완료 후 보낼 컨트롤러의 메소드명
											}, function(rsp) {
												if (rsp.success) { // 성공시
													var msg = '결제가 완료되었습니다.';
													msg += '고유ID : '
															+ rsp.imp_uid;
													msg += '상점 거래ID : '
															+ rsp.merchant_uid;
													msg += '결제 금액 : '
															+ rsp.paid_amount;
													msg += '카드 승인번호 : '
															+ rsp.apply_num;
													document.payform.submit();
												} else { // 실패시
													var msg = '결제에 실패하였습니다.';
													msg += '에러내용 : '
															+ rsp.error_msg;

												}
											});

						});
	</script>
	<jsp:include page="../main/mainFooter.jsp"></jsp:include>
</body>

</html>