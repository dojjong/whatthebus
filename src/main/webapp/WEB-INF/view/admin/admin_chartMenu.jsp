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



</head>
<body>


	<!-- 차트선택하기  -->
	<form id="chartform">
		<table>
			<tr>
				<td align="center">검색조건</td>
				<td><input type="date" id="startdate">&nbsp;&nbsp;~&nbsp;&nbsp;<input
					type="date" id="enddate"></td>
			</tr>
			<tr>
				<td align="center">일별 게시판 글 등록수&nbsp;</td>
				<td><input type="button" id="chart1bt" value="차트보기" /> 사용한
					데이터를 보시려면 <em> <a target="_blank" id="chart1Databt">여기를
							클릭하세요!</a>
				</em></td>
			</tr>
			<tr>
				<td align="center">일별 User가입자수&nbsp;</td>
				<td><input type="button" id="chart2bt" value="차트보기" /> 사용한
					데이터를 보시려면 <em> <a target="_blank" id="chart2Databt">여기를
							클릭하세요!</a>
				</em></td>
			</tr>
			<tr>
				<td align="center">일별 매출액&nbsp;</td>
				<td><input type="button" id="chart3bt" value="차트보기" /> 사용한
					데이터를 보시려면 <em> <a target="_blank" id="chart3Databt">여기를
							클릭하세요!</a>
				</em></td>
			</tr>
			<tr>
				<td align="center">기사님 별 평균별점&nbsp;</td>
				<td><input type="button" id="chart4bt" value="차트보기" /> 사용한
					데이터를 보시려면 <em> <a target="_blank" id="chart4Databt">여기를
							클릭하세요!</a>
				</em></td>
			</tr>
		</table>
	</form>

	<!-- 모든 차트는 여기서 나올 예정 -->
	<div id="chartTitle"></div>
	<div id="chartdiv"></div>


	<script>
		/*
		- 1번 차트 : 일자별 게시판 글 등록 수 
		- 2번 차트 : 일자별 가입자 수 
		- 3번 차트 : 일자별 매출액
		- 4번 차트 : 기사님별 평균별점
		 */

		$(document)
				.ready(
						function() {
							//listChart1(); //Json 리턴 방식
							//버튼 클릭 이벤트(ajax로 처리)
							$("#chart1bt")
									.click(
											function() {
												
												if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
													alert('검색 날짜를 입력해주세요');
													return;
												}
												var param = "startdate="
														+ document
																.getElementById("startdate").value
														+ "&enddate="
														+ document
																.getElementById("enddate").value;
												//alert(param);
												$
														.ajax({
															type : "post",
															data : param,
															url : "getBoardCountPerRegdateJson.do",
															success : function(
																	result) {
																//alert('성');
																chart1(result);
															},
															error : function(
																	request,
																	status,
																	error) {
																alert("code="
																		+ request.status
																		+ " message="
																		+ request.responseText
																		+ " error="
																		+ error);
															}

														});
											});

							$("#chart1Databt")
									.click(
											function() {
												if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
													alert('검색 날짜를 입력해주세요');
													return;
												}
												var param = "startdate="
														+ document
																.getElementById("startdate").value
														+ "&enddate="
														+ document
																.getElementById("enddate").value;
												$
														.ajax({
															type : "post",
															data : param,
															url : "getBoardCountPerRegdateJson.do",
															success : function(
																	result) {

																var output = "<div style='overflow:scroll;height: 480px;'><table>";

																for ( var i in result) {

																	output += "<tr>";

																	output += "<td style='width: 500px; text-align: center;'>";

																	output += "날짜 : "
																			+ result[i].date
																			+ " / 게시판 등록 글수 : "
																			+ result[i].value
																			+ "<br></td>";
																	output += "</tr>";
																}
																output += "</table></div>";

																$("#chartdiv")
																		.html(
																				output);

															},
															error : function(
																	request,
																	status,
																	error) {
																alert("code="
																		+ request.status
																		+ " message="
																		+ request.responseText
																		+ " error="
																		+ error);
															}

														});
											});

							$("#chart2bt")
									.click(
											function() {
												if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
													alert('검색 날짜를 입력해주세요');
													return;
												}
												var param = "startdate="
														+ document
																.getElementById("startdate").value
														+ "&enddate="
														+ document
																.getElementById("enddate").value;
												//alert(param);
												$
														.ajax({
															type : "post",
															data : param,
															url : "getMemberCountPerRegdateJson.do",
															success : function(
																	result) {
																chart2(result);
															},
															error : function(
																	request,
																	status,
																	error) {
																alert("code="
																		+ request.status
																		+ " message="
																		+ request.responseText
																		+ " error="
																		+ error);
															}

														});
											});

							$("#chart2Databt")
									.click(
											function() {
												if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
													alert('검색 날짜를 입력해주세요');
													return;
												}
												var param = "startdate="
														+ document
																.getElementById("startdate").value
														+ "&enddate="
														+ document
																.getElementById("enddate").value;
												$
														.ajax({
															type : "post",
															data : param,
															url : "getMemberCountPerRegdateJson.do",
															success : function(
																	result) {

																var output = "<div style='overflow:scroll;height: 480px;'><table>";

																for ( var i in result) {

																	output += "<tr>";

																	output += "<td style='width: 500px; text-align: center;'>";

																	output += "날짜 : "
																			+ result[i].date
																			+ " / 가입한 user 명수 : "
																			+ result[i].value
																			+ "<br></td>";

																	output += "</tr>";
																}
																output += "</table></div>";

																$("#chartdiv")
																		.html(
																				output);

															},
															error : function(
																	request,
																	status,
																	error) {
																alert("code="
																		+ request.status
																		+ " message="
																		+ request.responseText
																		+ " error="
																		+ error);
															}

														});
											});

						});

		$("#chart3bt").click(
				function() {
					if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
						alert('검색 날짜를 입력해주세요');
						return;
					}
					
					var param = "startdate="
							+ document.getElementById("startdate").value
							+ "&enddate="
							+ document.getElementById("enddate").value;
					//alert(param);
					$
							.ajax({
								type : "post",
								data : param,
								url : "getPayPerRegdate.do",
								success : function(result) {
									//alert('성');
									chart3(result);
								},
								error : function(request, status, error) {
									alert("code=" + request.status
											+ " message="
											+ request.responseText + " error="
											+ error);
								}

							});
				});

		$("#chart3Databt")
				.click(
						function() {
							if(document.getElementById("startdate").value==""||document.getElementById("enddate").value==""){
								alert('검색 날짜를 입력해주세요');
								return;
							}
							var param = "startdate="
									+ document.getElementById("startdate").value
									+ "&enddate="
									+ document.getElementById("enddate").value;
							$
									.ajax({
										type : "post",
										data : param,
										url : "getPayPerRegdate.do",
										success : function(result) {
											
	
											var output = "<div style='overflow:scroll;height: 480px;'><table>";
												
											for ( var i in result) {

												output += "<tr>";

												output += "<td style='width: 500px; text-align: center;'>";

												output += "날짜 : "
														+ result[i].date
														+ " / 매출액 : "
														+ result[i].value
														+ "<br></td>";
												output += "</tr>";
											}
											output += "</table></div>";

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
		$("#chart4bt").click(
				function() {
					$
							.ajax({
								type : "post",
								url : "getAvgStarPerDriver.do",
								success : function(result) {
									//alert('성');
									chart4(result);
								},
								error : function(request, status, error) {
									alert("code=" + request.status
											+ " message="
											+ request.responseText + " error="
											+ error);
								}

							});
				});

		$("#chart4Databt")
				.click(
						function() {
							$
									.ajax({
										type : "post",
										url : "getAvgStarPerDriver.do",
										success : function(result) {

											var output = "<div style='overflow:scroll;height: 480px;'><table>";

											for ( var i in result) {

												output += "<tr>";

												output += "<td style='width: 500px; text-align: center;'>";

												output += "기사님(건수) : "
														+ result[i].name
														+ " / 평균별점 : "
														+ result[i].points
														+ "<br></td>";
												output += "</tr>";
											}
											output += "</table></div>";

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

		function chart1(result) {

			document.getElementById("chartTitle").innerHTML = "<h4>일별 게시판 글 등록수</h4>";
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Add data
			chart.data = result;

			// Set input format for the dates
			chart.dateFormatter.inputDateFormat = "yyyy-MM-dd";

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.dataFields.valueY = "value";
			series.dataFields.dateX = "date";
			series.tooltipText = "{value}"
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
					start : 0.79,
					end : 1
				});
			});
		}

		function chart2(result) {

			document.getElementById("chartTitle").innerHTML = "<h4>일별 User 가입자수</h4>";
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Add data
			chart.data = result;

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());

			// Create value axis
			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var lineSeries = chart.series.push(new am4charts.LineSeries());
			lineSeries.dataFields.valueY = "value";
			lineSeries.dataFields.dateX = "date";
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

		function chart3(result) {
			document.getElementById("chartTitle").innerHTML = "<h4>일별 매출액</h4>";
			
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);

			// Enable chart cursor
			chart.cursor = new am4charts.XYCursor();
			chart.cursor.lineX.disabled = true;
			chart.cursor.lineY.disabled = true;

			// Enable scrollbar
			chart.scrollbarX = new am4core.Scrollbar();

			// Add data
			chart.data = result;

			// Create axes
			var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
			dateAxis.dataFields.category = "Date";
			dateAxis.renderer.grid.template.location = 0.5;
			dateAxis.dateFormatter.inputDateFormat = "yyyy-MM-dd";
			dateAxis.renderer.minGridDistance = 40;
			dateAxis.tooltipDateFormat = "MMM dd, yyyy";
			dateAxis.dateFormats.setKey("day", "dd");

			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

			// Create series
			var series = chart.series.push(new am4charts.LineSeries());
			series.tooltipText = "{date}\n[bold font-size: 17px]value: {valueY}[/]";
			series.dataFields.valueY = "value";
			series.dataFields.dateX = "date";
			series.strokeDasharray = 3;
			series.strokeWidth = 2
			series.strokeOpacity = 0.3;
			series.strokeDasharray = "3,3"

			var bullet = series.bullets.push(new am4charts.CircleBullet());
			bullet.strokeWidth = 2;
			bullet.stroke = am4core.color("#fff");
			bullet.setStateOnChildren = true;
			bullet.propertyFields.fillOpacity = "opacity";
			bullet.propertyFields.strokeOpacity = "opacity";

			var hoverState = bullet.states.create("hover");
			hoverState.properties.scale = 1.7;
			/*
			function createTrendLine(data) {
			  var trend = chart.series.push(new am4charts.LineSeries());
			  trend.dataFields.valueY = "value";
			  trend.dataFields.dateX = "date";
			  trend.strokeWidth = 2
			  trend.stroke = trend.fill = am4core.color("#c00");
			  trend.data = data;

			  var bullet = trend.bullets.push(new am4charts.CircleBullet());
			  bullet.tooltipText = "{date}\n[bold font-size: 17px]value: {valueY}[/]";
			  bullet.strokeWidth = 2;
			  bullet.stroke = am4core.color("#fff")
			  bullet.circle.fill = trend.stroke;

			  var hoverState = bullet.states.create("hover");
			  hoverState.properties.scale = 1.7;

			  return trend;
			};

			createTrendLine([
			  { "date": result[0].date, "value": result[0].value },
			  { "date": result[result.length-1].date, "value": result[(result.length%3)].value }
			]);
			
			createTrendLine([
				  { "date": result[0].date, "value": result[0].value },
				  { "date": result[result.length-1].date, "value": result[result.length-1].value }
				]);
			
			
			
			
			var lastTrend = createTrendLine([
			  { "date": "2012-01-17", "value": 16 },
			  { "date": "2012-01-22", "value": 10 }
			]);

			// Initial zoom once chart is ready
			lastTrend.events.once("datavalidated", function(){
			  series.xAxis.zoomToDates(new Date(2012, 0, 2), new Date(2012, 0, 13));
			});
			 */
		}
		
		function chart4(result) {
			
			// Themes begin
			am4core.useTheme(am4themes_animated);
			// Themes end

			// Create chart instance
			var chart = am4core.create("chartdiv", am4charts.XYChart);
			
			chart.data = result;
			for (var i=0; i<result.length; i++) {	
				chart.data[i].name = result[i].name;
				//alert(chart.data[i].name);
				chart.data[i].points = result[i].points;
				chart.data[i].bullet = "https://www.amcharts.com/lib/images/faces/A04.png";
				chart.data[i].color = chart.colors.next();
				
			}
			
			/*
			for (var i=0; i<chart.data.length; i++) {
				alert(chart.data[0].name+"/"+chart.data[0].points+1+" / "+chart.data[0].color+"/"+chart.data[0].bullet);
			}
			*/
			
			// Create axes
			var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
			categoryAxis.dataFields.category = "name";
			categoryAxis.renderer.grid.template.disabled = true;
			categoryAxis.renderer.minGridDistance = 30;
			categoryAxis.renderer.inside = true;
			categoryAxis.renderer.labels.template.fill = am4core.color("#fff");
			categoryAxis.renderer.labels.template.fontSize = 20;

			var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
			valueAxis.renderer.grid.template.strokeDasharray = "4,4";
			valueAxis.renderer.labels.template.disabled = true;
			valueAxis.min = 0;

			// Do not crop bullets
			chart.maskBullets = false;

			// Remove padding
			chart.paddingBottom = 0;

			// Create series
			var series = chart.series.push(new am4charts.ColumnSeries());
			series.dataFields.valueY = "points";
			series.dataFields.categoryX = "name";
			series.columns.template.propertyFields.fill = "color";
			series.columns.template.propertyFields.stroke = "color";
			series.columns.template.column.cornerRadiusTopLeft = 15;
			series.columns.template.column.cornerRadiusTopRight = 15;
			series.columns.template.tooltipText = "{categoryX}: [bold]{valueY}[/b]";

			// Add bullets
			var bullet = series.bullets.push(new am4charts.Bullet());
			var image = bullet.createChild(am4core.Image);
			image.horizontalCenter = "middle";
			image.verticalCenter = "bottom";
			image.dy = 20;
			image.y = am4core.percent(100);
			image.propertyFields.href = "bullet";
			image.tooltipText = series.columns.template.tooltipText;
			image.propertyFields.fill = "color";
			image.filters.push(new am4core.DropShadowFilter());
		}
	</script>
</body>
</html>
