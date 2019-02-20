<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#chartdiv {
	width: 100%;
	height: 500px;
}
</style>

<!-- Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>


</head>
<body>

	<!-- 모든 차트는 여기서 나올 예정 -->
	<div id="chartdiv"></div>
	<div id="chartDatadiv"></div>
	
	<!-- 차트선택하기  -->
	<table>
		<tr>
			<td><input
					type="button" id="chart1Databt" value="BoardCountPerRegdate_data" />&nbsp;</td>
			<td><input type="button" id="chart1bt" value="BoardCountPerRegdate_chart" />&nbsp;</td>
		</tr>
		<tr>
			<td><input type="button" id="chart2Databt" value="MemberCountPerRegdate_data" />&nbsp;</td>
			<td><input type="button" id="chart2bt" value="getBoardCountPerRegdate_data_chart" /></a>&nbsp;</td>
		</tr>
	</table>


	<script>
		$(document).ready(
				function() {
					//listChart1(); //Json 리턴 방식
					//버튼 클릭 이벤트(ajax로 처리)
					$("#chart1bt").click(
							function() {

								$.ajax({
									type : "post",
									url : "getBoardCountPerRegdateJson.do",
									success : function(result) {
										chart1(result);
									},
									error : function(request, status, error) {
										alert("code=" + request.status
												+ " message="
												+ request.responseText
												+ " error=" + error);
									}

								});
							});
					
					$("#chart1Databt").click(
							function() {

								$.ajax({
									type : "post",
									url : "getBoardCountPerRegdateJson.do",
									success : function(result) {
										
										var output = "<table>";

										for ( var i in result) {
											
											output += "<tr>";

											output += "<td style='width: 500px; text-align: center;'>";

											output += "dateValue : " + result[i].condition + " / count : "+result[i].count+"<br></td>";
											output += "</tr>";
										}
										output += "</table>";
										
										$("#chartdiv").html(output);
										
									},
									error : function(request, status, error) {
										alert("code=" + request.status
												+ " message="
												+ request.responseText
												+ " error=" + error);
									}

								});
							});

					$("#chart2bt").click(
							function() {

								$.ajax({
									type : "post",
									url : "getMemberCountPerRegdateJson.do",
									success : function(result) {
										chart2(result);
									},
									error : function(request, status, error) {
										alert("code=" + request.status
												+ " message="
												+ request.responseText
												+ " error=" + error);
									}

								});
							});
					
					$("#chart2Databt").click(
							function() {

								$.ajax({
									type : "post",
									url : "getMemberCountPerRegdateJson.do",
									success : function(result) {
										
										var output = "<table>";

										for ( var i in result) {
											
											output += "<tr>";

											output += "<td style='width: 500px; text-align: center;'>";

											output += "dateValue : " + result[i].dateValue + " / count : "+result[i].count+"<br></td>";

											output += "</tr>";
										}
										output += "</table>";
										
										$("#chartdiv").html(output);
										
									},
									error : function(request, status, error) {
										alert("code=" + request.status
												+ " message="
												+ request.responseText
												+ " error=" + error);
									}

								});
							});

				});

		function chart1(result) {

			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Add data
			chart.data = result;
			/*
			for ( var i in chart.data) {
				alert(i + ":" + chart.data[i].condition + "/"
						+ chart.data[i].count);
			}
			*/

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "count";
			series.dataFields.dateX = "condition";
			series.tooltipText = "{count}"
			series.strokeWidth = 2;
			series.minBulletDistance = 15;

			// Drop-shaped tooltips
			series.tooltip.background.cornerRadius = 20;
			series.tooltip.background.strokeOpacity = 0;
			series.tooltip.pointerOrientation = "vertical";
			series.tooltip.label.minWidth = 40;
			series.tooltip.label.minHeight = 40;
			series.tooltip.label.textAlign = "middle";
			series.tooltip.label.textValign = "middle";

			// Make bullets grow on hover
			var bullet = series.bullets.push(new am4charts.CircleBullet());
			bullet.circle.strokeWidth = 2;
			bullet.circle.radius = 4;
			bullet.circle.fill = am4core.color("#fff");

			var bullethover = bullet.states.create("hover");
			bullethover.properties.scale = 1.3;

			// Make a panning cursor
			chart.cursor = new am4charts.XYCursor();
			chart.cursor.behavior = "panXY";
			chart.cursor.xAxis = dateAxis;
			chart.cursor.snapToSeries = series;

			// Create vertical scrollbar and place it before the value axis
			chart.scrollbarY = new am4core.Scrollbar();
			chart.scrollbarY.parent = chart.leftAxesContainer;
			chart.scrollbarY.toBack();

			// Create a horizontal scrollbar with previe and place it underneath the date axis
			chart.scrollbarX = new am4charts.XYChartScrollbar();
			chart.scrollbarX.series.push(series);
			chart.scrollbarX.parent = chart.bottomAxesContainer;

			chart.events.on("ready", function() {
				dateAxis.zoom({
					start : 0.2,
					end : 1
				});
			});
		}
		
		function chart2(result) {

			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Add data
			chart.data = result

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());

			// Create value axis
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var lineSeries = chart.series.push(new am4charts.LineSeries());
			lineSeries.dataFields.valueY = "count";
			lineSeries.dataFields.dateX = "dateValue";
			lineSeries.name = "Sales";
			lineSeries.strokeWidth = 3;

			// Add simple bullet
			var bullet = lineSeries.bullets.push(new am4charts.Bullet());
			var image = bullet.createChild(am4core.Image);
			image.href = "https://www.amcharts.com/lib/images/star.svg";
			image.width = 30;
			image.height = 30;
			image.horizontalCenter = "middle";
			image.verticalCenter = "middle";
		}
	</script>
</body>
</html>
