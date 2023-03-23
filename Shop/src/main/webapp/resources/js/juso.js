var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: 5, // 지도의 확대 레벨
        marker: marker
    };

//지도를 미리 생성
var map = new daum.maps.Map(mapContainer, mapOption);
//주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();
//마커를 미리 생성
var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    title: "배송장소",
    map: map
});

var targetAddrName = undefined;

function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = data.address; // 최종 주소 변수

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById('addr').value = addr;
            // 주소로 상세 정보를 검색
            geocoder.addressSearch(data.address, function(results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === daum.maps.services.Status.OK) {

                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    var coords = new daum.maps.LatLng(result.y, result.x);
                    // 지도를 보여준다.
                    mapContainer.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords)
                }
            });
        },
        theme: 
        	{
        		bgColor: "#102596",
        		searchBgColor: "#0B65C8", //검색창 배경색
            	queryTextColor: "#FFFFFF" //검색창 글자색
        	}
    }).open({
    	popupTitle: '배송지 주소 검색',
    	popupKey: 'popup1'
    });
}

function saveAddr(SvtKind)
{
	let addrName = $('#addrName').val().trim();
	let addr = $('#addr').val().trim();
	let detail_address = $('#detail_address').val().trim();
	let phone = $('#phone').val().trim();
	let memo = $('#memo').val().trim();
	
	if(addrName == null || addrName == '' ||
		addr == null || addr == '' ||
		phone == null || phone == '' ||
		memo == null || memo == '' ||
		detail_address == null || detail_address == '')
	{
		alert('저장할 주소록에 입력하지 않은 내용이 있습니다.')
		return;
	}

	
	$.ajax(
			{
				type: 'POST',
				url: 'address',
				data: 
				{
					SvtKind: SvtKind,
					addrName: addrName,
					addr:  addr,
					detail_addr: detail_address,
					phone: phone,
					memo: memo,
					targetAddrName: targetAddrName
				},
				success: res =>
				{
					switch(res)
					{
						case "fail":
							alert("이미 있는 주소 이름입니다. 주소 이름을 변경해주세요.");
							break;
						case "update":
							alert("주소가 수정되었습니다.");
							location.reload();
							break;
						default:
							alert("주소가 추가되었습니다.");
							location.reload();
							break;
					}
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

function delAddr(addrName)
{
	
	$.ajax(
			{
				type: 'POST',
				url: 'address',
				data: 
				{
					SvtKind: 'del',
					addrName: addrName
				},
				success: res =>
				{
					alert(addrName + ' 주소가 삭제되었습니다.');
					location.reload();
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

//	넘어온 addrName으로 저장된 주소를 찾아 입력칸에 값을 넣어주는 ajax호출
function findAddr(addrName)
{
	$.ajax(
			{
				type: 'POST',
				url: 'address',
				data: 
				{
					SvtKind: 'findAddr',
					addrName: addrName
				},
				success: res =>
				{
					let result = JSON.parse(res);
					$('#addrName').val(result.addrName);
					$('#addr').val(result.addr);
					$('#detail_address').val(result.detail_addr);
					$('#phone').val(result.phone);
					$('#memo').val(result.memo);
					$('#updateAddrBtn').show();
					targetAddrName = $('#addrName').val().trim();
//					console.log(targetAddrName);
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

function updateMember()
{
	let nickname = $('#nickname').val().trim();
	
	if(nickname == null || nickname == '')
	{
		alert('입력하지 않은 회원정보가 있습니다.')
		return;
	}
	
	$.ajax(
			{
				type: 'POST',
				url: 'address',
				data: 
				{
					SvtKind: 'memberUpdate',
					nickname: nickname
				},
				success: res =>
				{
					alert('회원정보변경에 성공했습니다.');
					location.reload();
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

