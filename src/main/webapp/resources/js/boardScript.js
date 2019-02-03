$(function() {
	$("#writebt").click(function() {
		if ($("#member").val() == "") {
			alert("로그인 후 이용해주세요.");
			return;
		}
		document.form.submit();
	});

});