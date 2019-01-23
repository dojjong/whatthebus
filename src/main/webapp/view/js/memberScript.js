/* 
 *회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 시작 
 */
$(document).ready(function(){
	$("#id").blur(function(){
		if(document.form.id.value==""){
			$("#idMessage").html("아이디를 입력해주세요.");
		}else if(/*디비에서 불러온 ID값이 있으면*/true){
			$("#idMessage").html("중복된 ID입니다.");
		}else{
			$("#idMessage").html("사용가능한 ID입니다.");
		}
	});
});




/*
*회원가입시 ID 중복검사, 비밀번호 일치여부, 이메일 인증 등 끝
*/

