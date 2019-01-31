/* 
 *회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 시작 
 */
$(function() {
	var check = 0;
	var join = 0;
	var mailNumber;
	$("#insertId").blur(function() {
		var checkmember = $("#insertId").val();
		$.ajax({
			async : true,
			type : 'POST',
			url : "checkMember.do",
			data : checkmember,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				if (data.check > 0) {
					$("#idMessage").html("중복된 ID입니다.");
					check = 1;
				} else {
					$("#idMessage").html("사용가능한 ID입니다.");
					check = 0;
				}
			},
			error : function(error) {
				$("#idMessage").html("아이디를 입력해주세요.");
				check = -1;
			}
		});
	});

	$("#insertPasswordCheck").blur(function() {
		if ($("#insertPasswordCheck").val() != $("#insertPassword").val()) {
			$("#passwordCheckMessage").html("비밀번호가 일치하지 않습니다.");
		} else if($("#insertPasswordCheck").val()==""||$("#insertPassword").val()==""){
			$("#passwordCheckMessage").html("비밀번호를 입력해주세요.");
		}else{
			$("#passwordCheckMessage").html("비밀번호가 일치합니다.");
		}
	});
	$("#insertCheckbt").click(
			function() {
				if (check == 1) {
					alert("중복된 ID가 있습니다.");
					$("#inserId").focus();
					return;
				}
				if ($("#insertId").val() == "") {
					alert("ID를 입력해주세요.");
					$("#insertId").focus();
					return;
				}
				if ($("#insertPassword").val() == "") {
					alert("비밀번호를 입력해주세요.");
					$("#insertPassword").focus();
					return;
				}
				if ($("#insertPasswordCheck").val() != $("#insertPassword")
						.val()) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#insertPasswordCheck").focus();
					return;
				}
				if ($("#insertName").val() == "") {
					alert("이름을 입력해주세요.");
					$("#insertName").focus();
					return;
				}
				if (!$("#insertGender1").prop("checked")
						&& !$("#insertGender2").prop("checked")) {
					alert("성별을 선택해주세요.");
					return;
				}

				if ($("#insertTel1").val() == "") {
					alert("통신사를 입력해주세요.");
					$("#insertTel1").focus();
					return;
				}
				if ($("#insertTel2").val() == "") {
					alert("전화번호를 입력해주세요.");
					$("#insertTel2").focus();
					return;
				}
				if ($("#insertTel3").val() == "") {
					alert("전화번호를 입력해주세요.");
					$("#insertTel3").focus();
					return;
				}
				if ($("#insertEmail").val() == "") {
					alert("이메일을 입력해주세요.");
					$("#insertEmail").focus();
					return;
				}
				var str = $("#insertEmail").val();
				var atPos = str.indexOf('@');
				var atLastPos = str.lastIndexOf('@');
				var dotPos = str.indexOf('.');
				var spacePos = str.indexOf(' ');
				var commaPos = str.indexOf(',');
				var eMailSize = str.length;
				if (atPos > 1 && atPos == atLastPos && dotPos > 3
						&& spacePos == -1 && commaPos == -1
						&& atPos + 1 < dotPos && dotPos + 1 < eMailSize)
					;
				else {
					alert("이메일 주소 형식이 잘못되었습니다.\n\r 다시 입력해주세요.");
					$("#insertEmail").focus();
					return;
				}

				if (join == 0) {
					alert("인증번호가 일치하지 않습니다.");
					return;
				}
				if ($("#insertEmailCheck").val() == "") {
					alert("이메일 인증코드를 입력해주세요.");
					$("#insertEmailCheck").focus();
					return;
				}

				document.form.submit();
			});
	$("#emailbt").click(
			function() {
				var email = $("#insertEmail").val();
				if (email == "") {
					alert("메일을 입력해 주세요.");
					return false;
				}
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4) {
						var data = JSON.parse(xhttp.responseText);
						if (data != null) {
							alert("이미 가입한 메일입니다.");
						} else {
							sendMail(email);
						}
					}
				};
				xhttp.open("POST", 'checkEmail.do', true);
				xhttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded;charset=UTF-8");
				xhttp.send('email=' + email);
				return false;
			});
	function sendMail(email) {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				if (xhttp.status == 200) {
					alert("메일이 발송되었습니다.");
				} else
					alert("올바른 메일 형식이 아닙니다.");
			}
		};
		xhttp.open("POST", 'sendEmail.do', true);
		xhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");
		xhttp.send('email=' + email);
		return false;
	}
	$("#emailCheckbt").click(function() {
		var joinCode = $("#insertEmailCheck").val();
		$.ajax({
			async : true,
			type : 'POST',
			url : "getJoin.do",
			data : joinCode,
			dataType : "json",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				if (data.getJoin > 0) {
					alert("메일 인증에 성공했습니다.");
					join = 1;
				} else {
					alert("메일 인증에 실패했습니다.");
					join = 0;
				}
			},
			error : function(error) {
				$("#emailCheckMessage").html("인증번호를 입력해주세요.");
				join = -1;
			}
		});
	});
});
