<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>	
<jsp:include page="../main/mainHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<style>
nav {
	color: black;
	margin-top: 10px;
}



@
mypageul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 100px;
	background-color: #f1f1f1;
}

li a {
	display: block;
	font-color: black;
	padding: 8px 8px;
	text-decoration: none;
}

/* Change the link color on hover */
li a:hover {
	background-color: rgb(49, 100, 176);
	color: white;
}



</style>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
<div align="center">
	<div>
	<table width="1024px">
	
	<tr>
	<td width="200px">
	<aside id="left">
		<nav>
			<ul style="list-style-type: none;" id="mypageul">
				<li><a href="#" id="p1">ȸ����������</a></li>
				<li><a href="#" id="p2">��й�ȣ����</a></li>
				<li><a href="#">���� �ۼ��� ��</a></li>
				<li><a href="#">��������</a></li>
				<li><a href="#" id="p3">ȸ��Ż��</a></li>
			</ul>
		</nav>
	</aside>
	</td>
	
	<td id="result">
	</td>
	
	</tr>
	
	
	
</table>
</div>
</div>

<script>
$(document).ready(function(){
	$("#p1").click(function() {
		$("#result").load("moveUpdateCheckMember.do");
		
	});
	
});

$(document).ready(function(){
	$("#p2").click(function() {
		$("#result").load("movePwCheckMember.do");
		
	});
	
});

$(document).ready(function(){
	$("#p3").click(function() {
		$("#result").load("moveDeleteMember.do");
		
	});
	
});

</script>
	
	<footer>
		<jsp:include page="../main/mainFooter.jsp"></jsp:include>
	</footer>
</body>
</html>