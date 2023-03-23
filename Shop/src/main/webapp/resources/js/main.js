function openwin() 
{	
	let title = '로그인';
	let option = 'top=100px, left=100px, width=1200px, height=600px';
	window.open('/Shop/login/', title, option);
}

function logout()
{
	$.ajax(
			{
				type: 'POST',
				url: '/Shop/logRegi/',
				data: 
				{
					SvtKind: 'logout'
				},
				success: res =>
				{
					alert(res + "님이 로그아웃되었습니다.");
					location.reload();
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

$(function()
		{
			setTimeOffsetBetweenServerAndClient();
//			checkSessionExpired();
			showSessionTimer();
		}
);

//	서버시간과 브라우저의 시간을 동기화하는 offset
var setTimeOffsetBetweenServerAndClient = function()
{
	var latestTouch = getCookie('latestTouch');
	latestTouch = latestTouch==null ? null : Math.abs(latestTouch);
	//	브라우저의 시간을 받아오고
	var clientTime = (new Date()).getTime();
	//	서버시간과 브라우저의 시간의 오차를 계산한 시간
	var clientTimeOffset = clientTime - latestTouch;
	setCookie('clientTimeOffset', clientTimeOffset);
}

//	현재 시점에 세션이 만료된 상태인지 여부를 검사하는 용도
var isSessionExpired = function(offset)
{
	var sessionExpiry = Math.abs(getCookie('sessionExpiry'));
	var timeOffset = Math.abs(getCookie('clientTimeOffset'));
	var localTime = (new Date()).getTime();
	setCookie('remainTime', (sessionExpiry - (localTime - timeOffset)));
//	setCookie('remainTime', ((localTime - timeOffset)));
//	console.log(sessionExpiry)
	return localTime - timeOffset > (sessionExpiry-(offset||0));
}

//	타이머
//function checkSessionExpired(){
//	var isExpired = isSessionExpired(-5*1000);	//세션만료예정시간을 5초 앞당겨서 검사
//	if(isExpired === true)
//	{
//		alert('세션이 만료되어 로그아웃되었습니다.\n계속 이용하시려면 다시 로그인해주세요~');
//		location.reload();
//	}else
//	{
//		setTimeout('checkSessionExpired()', 30 * 1000);	//	30초에 한번씩 티이머 반복
//	}
//}

//	설정된 세션 만료 시간자체가 담긴 쿠키를 받아와서 remainSecond에 담는다. (요청이 없는 한 가지는 최대 세션 유지 시간)
var remainSecond = Math.abs(getCookie('maxInactiveInterval'));
let date = new Date();
date.setSeconds(Math.abs(getCookie('maxInactiveInterval')) + date.getSeconds())
var outTime = date.toLocaleTimeString('ko-kr');
//	jsp화면에 남은 세션 시간을 표시하기 위한용도
function showSessionTimer()
{
	var isExpired = isSessionExpired(-1*1000);	//세션만료예정시간을 5초 앞당겨서 검사
	if(isExpired === true)
	{
		alert('세션이 만료되어 로그아웃되었습니다.\n계속 이용하시려면 다시 로그인해주세요~');
		location.reload();
	}
	else
	{
//		hh : mm 으로 남은시간 표기하기 위한 변수
		remainSecond_ = parseInt(remainSecond % 60);
		remainMinute_ = parseInt(remainSecond / 60);
		$("#loginTime").empty();
		$("#loginTime").append("남은시간: " + remainMinute_ + ":" + remainSecond_ + "\n종료시간: " + outTime);    // hh:mm 표기
		remainSecond--;
		setTimeout("showSessionTimer()", 1000); //1초간격으로 재귀호출!
	}
	
}


//	쿠키 생성용 함수
function setCookie(cookieName, cookieValue, cookieExpire, cookiePath, cookieDomain, cookieSecure)
{
    var cookieText=escape(cookieName)+'='+escape(cookieValue);
    cookieText+=(cookieExpire ? '; EXPIRES='+cookieExpire.toGMTString() : '');
    cookieText+=(cookiePath ? '; PATH='+cookiePath : '');
    cookieText+=(cookieDomain ? '; DOMAIN='+cookieDomain : '');
    cookieText+=(cookieSecure ? '; SECURE' : '');
    document.cookie=cookieText;
}

//	쿠키값 받아오기용 함수
function getCookie(cookieName)
{
    var cookieValue=null;
    if(document.cookie)
    {
        var array=document.cookie.split((escape(cookieName)+'='));
        if(array.length >= 2){
            var arraySub=array[1].split(';');
            cookieValue=unescape(arraySub[0]);
        }
    }
    return cookieValue;
}

//	카테고리 펼치기 함수
function openCategory(element)
{
	 var before = document.getElementsByClassName("active")[0]               // 기존에 활성화된 버튼
     if (before && document.getElementsByClassName("active")[0] != element) {  // 자신 이외에 이미 활성화된 버튼이 있으면
         before.nextElementSibling.style.maxHeight = null;   // 기존에 펼쳐진 내용 접고
         before.classList.remove("active");                  // 버튼 비활성화
     }
     element.classList.toggle("active");         // 활성화 여부 toggle

     var content = element.nextElementSibling;
     if (content.style.maxHeight != 0) {         // 버튼 다음 요소가 펼쳐져 있으면
         content.style.maxHeight = null;         // 접기
     } else {
         content.style.maxHeight = content.scrollHeight + "px";  // 접혀있는 경우 펼치기
     }
      
}

