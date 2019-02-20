<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

	<!-- 모든 레포트는 여기서 나올 예정 -->
	<div id="chartdiv"></div>
	<div id="chartDatadiv"></div>

	<!-- 레포트선택하기  -->
	<table>
		<tr>
			<td><input type="button" id="xlsx" value="xlsx" />&nbsp;</td>
			<td><input type="button" id="xls" value="xls" />&nbsp;</td>
		</tr>

	</table>
	<script>
	$(document).ready(function(){
		$("#xlsx").click(function() {
			alert('d');
			$("#result").load("#");
			
		});
	});
	</script>
</body>
</html>
