<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>What The Bus !?</title>

<link type="text/css" rel="stylesheet"
	href="../resources/css/mainStyle.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- 로그인관련 js -->
<link type="text/css" rel="stylesheet"
	href="../resources/css/loginStyle.css">
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
	charset="utf-8"></script>


</head>
<body>


	<header id="header">

		<div align="center">

			<table id="headertable">
				<tr>
					<td width="700px"><a href="main.do"><img
							src="../resources/images/whatthebuslogo.png" id="gogo"></a></td>

					<td>
						<!-- 로그인 modal -->
						<div class="modal fade" id="myModal">
							<div class="modal-dialog modal-dialog-centered">
								<div class="modal-content">

									<!-- Modal Header -->
									<div class="modal-header">
										<h1 class="modal-title"></h1>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<!-- Modal body -->
									<!--  <div class="modal-body">Modal body..</div> -->
									<div align="center">
										<aside id="center">
											<form id="ryanform" name="ryanform" method="post">
												<svg id="ryan" viewBox="0 0 120 120"
													xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243"
														stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32"
														fill="#e0a243" stroke="#000" stroke-width="2.5"
														stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32"
														fill="#e0a243" stroke="#000" stroke-width="2.5"
														stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000"
														stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000"
														stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000"
														stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path
														d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
														fill="#fff" />
                <path
														d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71"
														fill="#fff" stroke="#000" stroke-width="2.5"
														stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65"
														fill="#000" stroke="#000" stroke-width="5"
														stroke-linejoin="round" />
            </g>
            <path
														d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105"
														fill="#fff" />
        </svg>



												<table id="ryonLogin" align="center">
													<tr>
														<td><input type="text" name="id" placeholder="아이디"
															class="ryantext" id="id" autocomplete="off"></td>

													</tr>
													<tr>
														<td><input type="password" name="password"
															placeholder="비밀번호" class="ryantext" id="pw"></td>
													</tr>
													<!-- 로그인버튼 비번 입력 잘못했을 때 alert뜨도록 수정해야함  -->
													<tr>
														<td><input type="button" value="로그인" id="login_bt"
															name="login_bt" onclick="idCheck(this.form.id.value)" /></td>
													</tr>
													<tr>
														<td align="center"><a href="findidandpass.do"
															onClick="window.open(this.href, '','width=500, height=220'); return false;"><input
																type="button" class="btn btn-link" value="아이디/비밀번호 찾기"></a>

															<a href="insertMemberChoice.do"><input type="button"
																class="btn btn-link" value="회원가입"></a></td>


													</tr>
													<!-- 카카오 로그인버튼 추가 -->
													<tr>
														<td><div align="center">
																<a id="custom-login-btn"
																	href="javascript:loginWithKakao()"> <img
																	src="../resources/images/kakaologin.png" width="240"
																	height="50" id="kakaologinbt" />
																</a>
															</div></td>
													</tr>
													<!-- 카카오 로그인버튼 추가 끝 -->
													<!-- 네이버 아이디로 로그인 추가버튼 -->
													<tr>
														<td>
															<div id="naverIdLogin" class="naverLogin" align="center"></div>
														</td>
													</tr>
													<!-- 네이버 아이디로 로그인 추가버튼 끝-->


												</table>
											</form>
											<script src="../resources/js/loginScript.js"></script>
										</aside>
									</div>





									<!-- Modal footer -->
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>

								</div>
							</div>
						</div> <!-- 로그인 modal --> <%-- 세션에 저장된 값이 있으면 보여지는 화면 --%> <%-- 라이센스가 null이냐 아니냐로 보여지는 화면 구분 --%>
						<c:choose>
							<c:when test="${member ne null }">
								<c:if test="${member.license==null }">


									<div align="right">
										<table>
											<tr>
												<td width="90px" align="center"><a
													href="memberMypage.do">마이페이지</a></td>
												<td width="150px" align="center">${member.name }회원님<br>환영합니다.&nbsp;
												</td>

												<td><form method="post" action="logoutMember.do">
														<input type="submit" value="로그아웃" class="btn btn-link">
													</form></td>
										</table>
									</div>
								</c:if>

								<c:if test="${member.license!=null }">
									<div align="right">
										<table>
											<tr>
												<td width="90px" align="center"><a
													href="driverMypage.do">마이페이지</a></td>
												<td width="150px" align="center">${member.name }기사님<br>환영합니다.
												</td>
												<td><form method="post" action="logoutDriver.do">
														<input type="submit" value="로그아웃" class="btn btn-link">
													</form></td>
										</table>
									</div>
								</c:if>
							</c:when>

							<c:otherwise>

								<!-- 메인 헤더 상단의 로그인/회원가입 부분 -->
								<div align="right" id="login_member">
									<button type="button" class="btn btn-link" data-toggle="modal"
										data-target="#myModal">로그인/회원가입</button>
								</div>
								<!-- 로그인/회원가입 부분 -->
							</c:otherwise>
						</c:choose>


					</td>

				</tr>

			</table>





			<div class="menubar">
				<ul>
					<li><a href="site.do">소개</a>
						<ul>
							<li><a href="site.do">사이트소개</a></li>
							<li><a href="guide.do">이용가이드</a></li>
						</ul></li>
					<li><a href="getBoardList.do">제안/대절신청</a>
						<ul>
							<li><a href="getBoardList.do">제안(개인)</a></li>
							<li><a href="getAfterBoardList.do">대절신청(단체)</a></li>
						</ul></li>
					<li><a href="getSuggestBoardList.do">조회</a>
						<ul>
							<li><a href="getSuggestBoardList.do">배차대기</a></li>
						</ul></li>
					<li><a href="getBookBoardList.do">예약</a>
						<ul>
							<li><a href="getBookBoardList.do">배차조회</a></li>
						</ul></li>
					<li><a href="#">고객센터</a>
						<ul>
							<li><a href="getQaBoardList.do">Q&A</a></li>
							<li><a href="getAfterBoardList.do">after</a></li>
							<li><a href="getLostBoardList.do">분실물서비스</a></li>
							<li><a href="#">ContactUs</a></li>
						</ul></li>
					<li><a href="#">공지사항</a>
						<ul>
							<li><a href="getNoticeBoardList.do">공지사항</a></li>
							<li><a href="getEventBoardList.do">이벤트</a></li>
						</ul></li>
				</ul>
			</div>

		</div>

	</header>



	<!-- container -->

	<!-- 카카오로 로그인 초기화 스크립트 -->
	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('9c7768efbf95af2e0039c27fd0b2cb6d');
		// 카카오 로그인 버튼을 생성합니다.
		function loginWithKakao() {
			// 로그인 창을 띄웁니다.
			Kakao.Auth.login({
				success : function(authObj) {
					alert(JSON.stringify(authObj));
				},
				fail : function(err) {
					alert(JSON.stringify(err));
				}
			});
		};
		//]]>
	</script>
	<!-- 카카오로 로그인 초기화 스크립트 끝 -->
	<!-- 네이버아이디로로그인 초기화 Script -->
	<script type="text/javascript">
		var naverLogin = new naver.LoginWithNaverId(
				{
					clientId : "WIH5P0pD74ERtN5bANjy",
					callbackUrl : "http://localhost:8080/whatthebus_project/main/main.html",
					isPopup : true, /* 팝업을 통한 연동처리 여부 */
					loginButton : {
						color : "green",
						type : 3,
						height : 50
					}
				/* 로그인 버튼의 타입을 지정 */
				});

		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
	</script>
	<!-- // 네이버아이디로로그인 초기화 Script -->
	<script>
		function idCheck(id) {
			if (id == "") {
				alert("아이디를 입력해 주세요.");
				document.ryanform.id.focus();
				return;
			}
			$.ajax({
				type : "POST",
				url : "loginMemberCheck.do",
				data : $("#ryanform").serialize(),
				success : function(data) {
					if (data == "fail") {
						alert("아이디 또는 비밀번호가 일치하지 않습니다.");
						return;
					} else if (data == "success") {
						loginCheck();
						//window.location.replace("loginMember.do");							
					}
				},
				error : function(request, status, error) {
					alert("잘못된 접근입니다.");
				}
			});
		}
		function loginCheck() {
			document.ryanform.action = "loginMember.do";
			document.ryanform.submit();
		}
		$(document).ready(function() {
			$("#pw").keypress(function(e) {
				if (e.which == 13) {
					idCheck(id); // 실행할 이벤트
				}
			});
		});
	</script>

</body>
</html>