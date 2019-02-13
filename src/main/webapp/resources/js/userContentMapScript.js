window.onload=function(){
	
	var start_wido = Number($('#start_wido').val());	
	var start_kyungdo = Number($('#start_kyungdo').val());
	var end_wido = Number($('#end_wido').val());
	var end_kyungdo = Number($('#end_kyungdo').val());
	var mid_wido = $('#mid_wido').val();
	var mid_kyungdo = $('#mid_kyungdo').val();
	
	var mid_wido_split = mid_wido.split('/');
	var mid_kyungdo_split = mid_kyungdo.split('/');
	
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new daum.maps.LatLng(Number(start_wido), Number(start_kyungdo)), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
	    };
	
	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	 
	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
	var positions = [
	    {
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">출발지</div>', 
	        latlng: new daum.maps.LatLng(Number(start_wido), Number(start_kyungdo))
	    },
	    {
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">도착지</div>', 
	        latlng: new daum.maps.LatLng(Number(end_wido), Number(end_kyungdo))
	    },
	];
	
	for(var i=1; i<mid_wido_split.length;i++){
		positions.push({content:'<div style="width:150px;text-align:center;padding:6px 0;">경유지'+i+'</div>', latlng: new daum.maps.LatLng(Number(mid_wido_split[i]), Number(mid_kyungdo_split[i]))});
	}
	for (var i = 0; i < positions.length; i ++) {
	    // 마커를 생성합니다
	    var marker = new daum.maps.Marker({
	        map: map, // 마커를 표시할 지도
	        position: positions[i].latlng // 마커의 위치
	    });
	
	    // 마커에 표시할 인포윈도우를 생성합니다 
	    var infowindow = new daum.maps.InfoWindow({
	        content: positions[i].content // 인포윈도우에 표시할 내용
	    });
		 infowindow.open(map, marker);
	}
	
	var geocoder = new daum.maps.services.Geocoder();
	
	/* 주소 얻어오기 */
	var coord1 = new daum.maps.LatLng(start_wido, start_kyungdo);
	var callback1 = function(result, status) {
		startJuso = result[0].road_address.address_name;
		console.log(result[0].road_address.address_name);
		var resultSpanStartJuso = document.getElementById('spanStartJuso');
		resultSpanStartJuso.innerHTML = startJuso;
		document.contentForm.startJuso.value = startJuso;
	};
	geocoder.coord2Address(coord1.getLng(), coord1.getLat(), callback1);
	
	var coord2 = new daum.maps.LatLng(end_wido, end_kyungdo);
	var callback2 = function(result, status) {
		endJuso = result[0].road_address.address_name;
		console.log(result[0].road_address.address_name);
		var resultSpanEndJuso = document.getElementById('spanEndJuso');
		resultSpanEndJuso.innerHTML = endJuso;
		document.contentForm.endJuso.value = endJuso;
	};
	
	geocoder.coord2Address(coord2.getLng(), coord2.getLat(), callback2);

	var coord5;
	var midJusoArray = new Array;
	var resultDivMidJuso = document.getElementById('divMidJuso');
	for(var i=1; i<mid_wido_split.length;i++){
		
		var callback4 = function(result, status) {
			midJuso = result[0].road_address.address_name;
			midJusoArray.push(midJuso);
			resultDivMidJuso.innerHTML += '확정 경유지 : <span name="spanMidJuso" id="spanMidJuso_'+i+'">'+midJuso+'</span><br>';
		};
		coord5 = new daum.maps.LatLng(Number(mid_wido_split[i]), Number(mid_kyungdo_split[i]));
		geocoder.coord2Address(coord5.getLng(), coord5.getLat(), callback4);
	}
	
}

function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 법정동 상세 주소 정보를 요청합니다
	geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}
