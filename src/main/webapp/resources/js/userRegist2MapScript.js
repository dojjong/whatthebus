
	var start_wido=document.updateSuggestForm.start_wido.value;
	var start_kyungdo=document.updateSuggestForm.start_kyungdo.value;
	var end_wido=document.updateSuggestForm.end_wido.value;
	var end_kyungdo=document.updateSuggestForm.end_kyungdo.value;
	
	// 실제 지도를 띄우는 코드
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center : new daum.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level : 3
	//지도의 레벨(확대, 축소 정도)
	};

	var map = new daum.maps.Map(container, options); //지도 생성 및 객체 리턴
	
	
	function search() {
	
	/* 주소로 좌표를 검색하기 */
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(
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
		
		document.writeForm.imsi_wido.value = imsi_wido;
		document.writeForm.imsi_kyungdo.value = imsi_kyungdo;
		
		
		/* 주소 얻어오기 */
		var coord = new daum.maps.LatLng(imsi_wido, imsi_kyungdo);
		var callback1 = function(result, status) {
			
			imsiJuso = result[0].road_address.address_name;
			console.log(result[0].road_address.address_name);
			var resultSpanImsiJuso = document.getElementById('spanImsiJuso');
			resultSpanImsiJuso.innerHTML = imsiJuso;
			document.writeForm.imsiJuso.value = imsiJuso;
			
		};
		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback1);
	});
	return;
}

	function searchDetailAddrFromCoords(coords, callback) {
		// 좌표로 법정동 상세 주소 정보를 요청합니다
		geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
	}

	function startSet(){
		var resultspanStartJuso = document.getElementById('spanStartJuso');
	
		var imsi1 = document.writeForm.imsi_wido.value;
		var imsi2 = document.writeForm.imsi_kyungdo.value;
		var imsiJuso = document.writeForm.imsiJuso.value;
		
		resultspanStartJuso.innerHTML = imsiJuso;
		
		document.writeForm.start_wido.value = imsi1;
		document.writeForm.start_kyungdo.value = imsi2;
		document.writeForm.startJuso.value = imsiJuso;
	}




	function endSet(){
		
		var resultspanEndJuso = document.getElementById('spanEndJuso');
	
		var imsi1 = document.writeForm.imsi_wido.value;
		var imsi2 = document.writeForm.imsi_kyungdo.value;
		var imsiJuso = document.writeForm.imsiJuso.value;
		
		resultspanEndJuso.innerHTML = '';
		resultspanEndJuso.innerHTML = imsiJuso;
		
		document.writeForm.end_wido.value = imsi1;
		document.writeForm.end_kyungdo.value = imsi2;
		document.writeForm.endJuso.value = imsiJuso;
	}

