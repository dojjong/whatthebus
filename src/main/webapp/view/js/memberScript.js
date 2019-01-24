/* 
 *회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 시작 
 */
$(function() {
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
				} else {
					$("#idMessage").html("사용가능한 ID입니다.");
				}

			},
			error : function(error) {
					$("#idMessage").html("아이디를 입력해주세요.");
			}
		});

	});
});

/*
 * 회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 끝
 */
/*
 * function checkMember(form) { var query = { id : $("#id").val() }; var
 * check; $.ajax({ type : "POST", url : "checkMember.do", data : query,
 * success : function(data) { alert("성공"); check = data;
 * $("#checkMember").html(check); } }); if (document.form.id.value == "") {
 * $("#idMessage").html("아이디를 입력해주세요."); } else if ($("#checkMember").val() ==
 * "1") { $("#idMessage").html("중복된 ID입니다."); } else {
 * $("#idMessage").html("사용가능한 ID입니다."); } } });
 */

