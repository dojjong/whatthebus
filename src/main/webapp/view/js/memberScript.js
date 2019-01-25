/* 
 *회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 시작 
 */
$(function() {
	var check = 0;
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
		} else {
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

				/* 이메일 인증코드 들어갈것 */
				if ($("#insertEmailCheck").val() == "") {
					alert("이메일 인증코드를 입력해주세요.");
					$("#insertEmailCheck").focus();
					return;
				}
				document.form.submit();
			});

});
