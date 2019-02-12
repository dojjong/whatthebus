
	
	//var start_wido = Number($('#start_wido').val());
	//alert(Number(start_wido));	
	var start_wido=document.updateSuggestForm.start_wido.value;
	//var start_kyungdo = Number($('#start_kyungdo').val());
	//alert(Number(start_kyungdo));
	var start_kyungdo=document.updateSuggestForm.start_kyungdo.value;
	//var end_wido = Number($('#end_wido').val());
	//alert(Number(end_wido));	
	var end_wido=document.updateSuggestForm.end_wido.value;
	//var end_kyungdo = Number($('#end_kyungdo').val());
	//alert(Number(end_kyungdo));	
	var end_kyungdo=document.updateSuggestForm.end_kyungdo.value;
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new daum.maps.LatLng(Number(start_wido), Number(start_kyungdo)), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
	    };
	
	var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
	var positions = [
	    {
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">요청출발지</div>', 
	        latlng: new daum.maps.LatLng(Number(start_wido), Number(start_kyungdo))
	    },
	    {
	        content: '<div style="width:150px;text-align:center;padding:6px 0;">요청도착지</div>', 
	        latlng: new daum.maps.LatLng(Number(end_wido), Number(end_kyungdo))
	    },
	];
	
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
	
	

function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 법정동 상세 주소 정보를 요청합니다
	geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	
}

function search() {
	
	/* 주소로 좌표를 검색하기 */
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					document.getElementById('usertRegistMap_input').value,
					function(result, status) {
						
						// 정상적으로 검색이 완료됐으면 
						if (status == daum.maps.services.Status.OK) {
							
							var coords = new daum.maps.LatLng(result[0].y, result[0].x);
							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
							
						}
					});

	/* 클릭한 위치에 마커 표시하기 */
	// 지도를 클릭한 위치에 표출할 마커입니다

	var marker = new daum.maps.Marker({
		// 지도 중심좌표에 마커를 생성합니다 
		position : map.getCenter()
	});
	
	// 지도에 마커를 표시합니다
	marker.setMap(map);

	
	// 지도에 클릭 이벤트를 등록합니다
	// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
	daum.maps.event.addListener(map, 'click', function(mouseEvent) {
		
		/* 좌표 얻어오기 */
		// 클릭한 위도, 경도 정보를 가져옵니다 
		var latlng = mouseEvent.latLng;
		// 마커 위치를 클릭한 위치로 옮깁니다
		marker.setPosition(latlng);
		var imsi_wido = String(latlng.getLat());
		var imsi_kyungdo = String(latlng.getLng());
		
		document.updateSuggestForm.imsi_wido.value = imsi_wido;
		document.updateSuggestForm.imsi_kyungdo.value = imsi_kyungdo;
		
		
		/* 주소 얻어오기 */
		var coord = new daum.maps.LatLng(imsi_wido, imsi_kyungdo);
		var callback1 = function(result, status) {
			imsiJuso = result[0].road_address.address_name;
			console.log(result[0].road_address.address_name);
			var resultSpanImsiJuso = document.getElementById('spanImsiJuso');
			resultSpanImsiJuso.innerHTML = imsiJuso;
			document.updateSuggestForm.imsiJuso.value = imsiJuso;
		};
		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback1);
	});
}

function searchDetailAddrFromCoords(coords, callback) {
	// 좌표로 법정동 상세 주소 정보를 요청합니다
	geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}

function startSet(){
	var resultspanStartJuso = document.getElementById('spanStartJuso');

	var imsi1 = document.updateSuggestForm.imsi_wido.value;
	var imsi2 = document.updateSuggestForm.imsi_kyungdo.value;
	var imsiJuso = document.updateSuggestForm.imsiJuso.value;
	
	resultspanStartJuso.innerHTML = imsiJuso;
	
	document.updateSuggestForm.start_wido.value = imsi1;
	document.updateSuggestForm.start_kyungdo.value = imsi2;
	document.updateSuggestForm.startJuso.value = imsiJuso;
}




function endSet(){
	
	var resultspanEndJuso = document.getElementById('spanEndJuso');

	var imsi1 = document.updateSuggestForm.imsi_wido.value;
	var imsi2 = document.updateSuggestForm.imsi_kyungdo.value;
	var imsiJuso = document.updateSuggestForm.imsiJuso.value;
	
	resultspanEndJuso.innerHTML = '';
	resultspanEndJuso.innerHTML = imsiJuso;
	
	document.updateSuggestForm.end_wido.value = imsi1;
	document.updateSuggestForm.end_kyungdo.value = imsi2;
	document.updateSuggestForm.endJuso.value = imsiJuso;
}