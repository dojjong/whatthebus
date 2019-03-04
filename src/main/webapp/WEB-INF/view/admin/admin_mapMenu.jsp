<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>마커 클러스터러에 클릭이벤트 추가하기</title>
<style>
#mapwrap{position:relative;overflow:hidden;}
.category, .category *{margin:0;padding:0;color:#000;}   
.category {position:absolute;overflow:hidden;top:10px;left:10px;width:250px;height:50px;z-index:10;border:1px solid black;font-family:'Malgun Gothic','맑은 고딕',sans-serif;font-size:12px;text-align:center;background-color:#fff;}
.category .menu_selected {background:#FF5F4A;color:#fff;border-left:1px solid #915B2F;border-right:1px solid #915B2F;margin:0 -1px;} 
.category li{list-style:none;float:left;width:50px;height:45px;padding-top:5px;cursor:pointer;} 
.category .ico_comm {display:block;margin:0 auto 2px;width:22px;height:26px;background:url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/category.png') no-repeat;} 
.category .ico_start {background-position:-10px 0;}  
.category .ico_mid {background-position:-10px -36px;}   
.category .ico_end {background-position:-10px -72px;} 
.category .ico_all {background-position:-10px -108px;} 
.category .ico_allcluster {background-position:-10px -144px;} 
</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
</head>
<body>
	<br/>
	<br/>
	<p style="margin-top: -12px">
		사용한 데이터를 보시려면 클릭하세요..<em class="link"><br> <a
			href="javascript:dataView('1')" target="_blank">출발지만Data</a>
		</em>&nbsp;&nbsp;
		<em class="link"> <a
			href="javascript:dataView('2')" target="_blank">경유지만Data</a>
		</em>&nbsp;&nbsp;
		<em class="link"> <a
			href="javascript:dataView('3')" target="_blank">도착지만Data</a>
		</em>&nbsp;&nbsp;
		<em class="link"> <a
			href="javascript:dataView('5')" target="_blank">전체Data</a>
		</em><br>
	</p>

	<div id="mapwrap"> 
    <!-- 지도가 표시될 div -->
    <div id="map" style="overflow-y:scroll;width:1000px;height:500px;"></div>
    <!-- 지도 위에 표시될 마커 카테고리 -->
	
    <div class="category">
        <ul>
	        <li id="startMenu" onclick="changeMarker('start')">
	               <!--<span class="ico_comm ico_start"> </span> --> 
	               <span><i class='fas fa-map-marker-alt' style='font-size:12px;color:red'></i><br/></span>
	                출발지
	            </li>
            <li id="midMenu" onclick="changeMarker('mid')">
                <!-- <span class="ico_comm ico_mid"></span> -->
                <span><i class='fas fa-map-marked-alt' style='font-size:12px;color:red'></i><br/></span>
                경유지
            </li>
            <li id="endMenu" onclick="changeMarker('end')">
                <!-- <span class="ico_comm ico_end"></span> -->
                <span><i class="fa fa-map-marker" style="font-size:12px;color:red"></i><br/></span>
                도착지
            </li>
            <li id="allMenu" onclick="changeMarker('all')">
                <span><i class="fa fa-map-pin" style="font-size:12px;color:red"></i><br/></span>
                짬뽕
            </li>
            <li id="allClusterMenu" onclick="changeMarker('allcluster')">
                <span><i class="fa fa-map" style="font-size:12px;color:red"></i><br/></span>
                클러스터
            </li>
        </ul> 
    </div>

    
</div>


	<script>

	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new daum.maps.LatLng(37.498004414546934, 127.02770621963765), // 지도의 중심좌표 
        level: 10 // 지도의 확대 레벨 
    }; 

	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	var clusterResult = [];
	
	var startPositions = [];
	var midPositions = [];
	var endPositions = [];
	var allPositions = [];
	
	var startData = [];
	var midData = [];
	var endData = [];
	var allData = [];
	
	
	var startMarkers = []; // 출발지 마커 객체를 가지고 있을 배열입니다
	var midMarkers = []; // 경유지 마커 객체를 가지고 있을 배열입니다
	var endMarkers = []; // 도착지 마커 객체를 가지고 있을 배열입니다
	var allMarkers = [];
	
	dataSetting("1");
	dataSetting("2");
	dataSetting("3");
	dataSetting("5");
	
	function dataSetting(sort, view){
			
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "getClusterDate.do?sort="+sort,
			success : function(result) {
				//alert('success');
				//alert(result.positions[0].lng);
				process(result, sort);
			},
			error : function(request, status,
					error) {
				alert("code=" + request.status
						+ " message="
						+ request.responseText
						+ " error=" + error);
			}
		});
	}
	var markerImageSrc = '';
	function process(result, sort) {
			
		
		markerImageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/category.png';  // 마커이미지의 주소입니다. 스프라이트 이미지 입니다
		//var imageSrc1 = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다    
    	//imageSize1 = new daum.maps.Size(22, 26), // 마커이미지의 크기입니다
    	//imageOption1 = {offset: new daum.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
		
		if(sort=="1"){
			startPositions = result.positions;
			createstartMarkers(); // 출발지 마커를 생성하고 출발지 마커 배열에 추가합니다
		}else if(sort=="2"){
			midPositions = result.positions;
			createmidMarkers(); // 경유지 마커를 생성하고 경유지 마커 배열에 추가합니다
		}else if(sort=="3"){
			endPositions = result.positions;
			createendMarkers(); // 도착지 마커를 생성하고 도착지 마커 배열에 추가합니다*/
		}else if(sort=="5"){			
			clusterResult = result;
		}
	}
	

	function callCluster(result){
		var data = result;		

			// 마커 클러스터러를 생성합니다 
				
			var clusterer = new daum.maps.MarkerClusterer({
			    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
			    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
			    minLevel: 10 // 클러스터 할 최소 지도 레벨 
			});
			
		
			var markers = $(data.positions).map(function(i, position) {
			    return new daum.maps.Marker({
			        position : new daum.maps.LatLng(position.lat, position.lng)
			    });
			});
			
			// 클러스터러에 마커들을 추가합니다
			clusterer.addMarkers(markers);
	}

	    
 	// 마커이미지의 주소와, 크기, 옵션으로 마커 이미지를 생성하여 리턴하는 함수입니다
    function createMarkerImage(src, size, options) {
        var markerImage = new daum.maps.MarkerImage(src, size, options);
        return markerImage;            
    }

    // 좌표와 마커이미지를 받아 마커를 생성하여 리턴하는 함수입니다
    function createMarker(position, image) {
        var marker = new daum.maps.Marker({
            position: new daum.maps.LatLng(position.lat, position.lng),
            image: image
        });
        return marker;  
    }   
   
    // 출발지 마커를 생성하고 출발지 마커 배열에 추가하는 함수입니다
    function createstartMarkers() {
        for (var i = 0; i < startPositions.length; i++) {  
            var imageSize = new daum.maps.Size(22, 26),
                imageOptions = {  
                    spriteOrigin: new daum.maps.Point(10, 0),    
                    spriteSize: new daum.maps.Size(36, 98)  
                };     
            
            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions);
            var marker = createMarker(startPositions[i], markerImage);  
            // 생성된 마커를 출발지 마커 배열에 추가합니다
            startMarkers.push(marker);
            
        }     
    }
  
    // 출발지 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setstartMarkers(map) {
        for (var i = 0; i < startMarkers.length; i++) {  
            startMarkers[i].setMap(map);
        }        
    }
    
    // 경유지 마커를 생성하고 경유지 마커 배열에 추가하는 함수입니다
    function createmidMarkers() {
        for (var i = 0; i < midPositions.length; i++) {
            
            var imageSize = new daum.maps.Size(22, 26),
                imageOptions = {   
                    spriteOrigin: new daum.maps.Point(10, 36),    
                    spriteSize: new daum.maps.Size(36, 98)  
                };       
         
            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),    
                marker = createMarker(midPositions[i], markerImage);  
			
            // 생성된 마커를 경유지 마커 배열에 추가합니다
            midMarkers.push(marker);    
        }        
    }
      
    // 경유지 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setmidMarkers(map) {        
        for (var i = 0; i < midMarkers.length; i++) {  
            midMarkers[i].setMap(map);
        }        
    }
  
    // 도착지 마커를 생성하고 도착지 마커 배열에 추가하는 함수입니다
    function createendMarkers() {
        for (var i = 0; i < endPositions.length; i++) {
            
            var imageSize = new daum.maps.Size(22, 26),
                imageOptions = {   
                    spriteOrigin: new daum.maps.Point(10, 72),    
                    spriteSize: new daum.maps.Size(36, 98)  
                };       
         
            // 마커이미지와 마커를 생성합니다
            var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),    
                marker = createMarker(endPositions[i], markerImage);  

            // 생성된 마커를 도착지 마커 배열에 추가합니다
            endMarkers.push(marker);        
        }                
    }

    // 도착지 마커들의 지도 표시 여부를 설정하는 함수입니다
    function setendMarkers(map) {        

        for (var i = 0; i < endMarkers.length; i++) {  
            endMarkers[i].setMap(map);
        }        
    }

    // 카테고리를 클릭했을 때 type에 따라 카테고리의 스타일과 지도에 표시되는 마커를 변경합니다
    function changeMarker(type){
        var startMenu = document.getElementById('startMenu');
        var midMenu = document.getElementById('midMenu');
        var endMenu = document.getElementById('endMenu');
        var allMenu = document.getElementById('allMenu');
        var allClusterMenu = document.getElementById('allClusterMenu');
        
        // 출발지 카테고리가 클릭됐을 때
        if (type === 'start') {
            // 출발지 카테고리를 선택된 스타일로 변경하고
            startMenu.className = 'menu_selected';
            
            // 경유지과 도착지 카테고리는 선택되지 않은 스타일로 바꿉니다
            midMenu.className = '';
            endMenu.className = '';
            allMenu.className = '';
            allClusterMenu.className ='';
            
            // 출발지 마커들만 지도에 표시하도록 설정합니다
            map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다 
            setmidMarkers(null);
            setendMarkers(null);
            setstartMarkers(map); 
            
          
         
        } else if (type === 'mid') { // 경유지 카테고리가 클릭됐을 때
        
            // 경유지 카테고리를 선택된 스타일로 변경하고
            startMenu.className = '';
            midMenu.className = 'menu_selected';
            endMenu.className = '';
            allMenu.className = '';
            allClusterMenu.className ='';
            
            // 경유지 마커들만 지도에 표시하도록 설정합니다
          	map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다 
            setstartMarkers(null);
            setmidMarkers(map);
          	setendMarkers(null);
            callCluster(null);
            
     
        } else if (type === 'end') { // 도착지 카테고리가 클릭됐을 때
         
            // 도착지 카테고리를 선택된 스타일로 변경하고
            startMenu.className = '';
            midMenu.className = '';
            endMenu.className = 'menu_selected';
            allMenu.className = '';
            allClusterMenu.className ='';
            
            // 도착지 마커들만 지도에 표시하도록 설정합니다
           	map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다 	
            setstartMarkers(null);
            setmidMarkers(null);
            setendMarkers(map);
            callCluster(null);
          
        }   else if (type === 'all') { // 전체 카테고리가 클릭됐을 때
         
            // 전체 카테고리를 선택된 스타일로 변경하고
            startMenu.className = '';
            midMenu.className = '';
            endMenu.className = '';
            allMenu.className = 'menu_selected';
            allClusterMenu.className ='';
            
            // 전체 마커들만 지도에 표시하도록 설정합니다
            map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다 
            setstartMarkers(map);
            setmidMarkers(map);
            setendMarkers(map);  
            callCluster(null);
            
        }  else if (type === 'allcluster') { // 클러스터 카테고리가 클릭됐을 때
         
            // 클러스터 카테고리를 선택된 스타일로 변경하고
            
            startMenu.className = '';
            midMenu.className = '';
            endMenu.className = '';
            allMenu.className = '';
            allClusterMenu.className = 'menu_selected';
            
            // 클러스터 마커들만 지도에 표시하도록 설정합니다
            map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다 
            setstartMarkers(null);
            setmidMarkers(null);
            setendMarkers(null);  
            
            callCluster(clusterResult);
             
        }  
        
    } 
    function dataView(sort){
    	
		$("#map").load("getClusterDate.do?sort="+sort);
		
    }
    
</script>

</body>
</html>