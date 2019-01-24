/* 
 *회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 시작 
 */
$(document).ready(function() {

	$("#id").focus(function() {
		$.ajax({
			type : "POST",
			url : "resetCheck.do",
			data : query,
			success : function(data) {
			}
		});
	});

	$("#id").blur(function() {
		var query = {
			id : $("#id").val()
		};
		var check;
		$.ajax({
			type : "POST",
			url : "checkMember.do",
			data : query,
			success : function(data) {
				check = data;

			}
		});
		if (document.form.id.value == "") {
			$("#idMessage").html("아이디를 입력해주세요.");
		} else if ($("#checkMember").val() == "1") {
			$("#idMessage").html("중복된 ID입니다.");
		} else {
			$("#idMessage").html("사용가능한 ID입니다.");
		}

	});
});

/*
 * 회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 끝
 */

