const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');
let code = undefined

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});


//아이디 중복 검사를 실행하는 함수
function idChk()
{
	
	let id = $('#register').children('input[name=id]').val().trim();

	if(id == null || id == '')
	{
		$('#idChkMsg').html('※아이디를 입력하고 중복 체크 버튼을 누르세요.');
		
		return;
	}
	//	jQuery ajax
	$.ajax(
		{
			type: 'POST',
			url: '/Shop/logRegi/',
			data: 
			{
				userID: id.toLowerCase(),
				SvtKind: 'idChk'
			},
			success: res =>
			{
				switch(res)
				{
					case '0':
						$('#idChkMsg').html('※사용중인 아이디 입니다~~~');
						$('#register').children('input[name=id]').val('');
						break;
					case '1':
						$('#idChkMsg').html('※사용 가능한 아이디입니다.');
						//result = 'true';
						break;
				}
				
			},
			error: e =>
			{
				console.log('요청 실패: ', e.status);
			}
		});
		
}

//	비밀번호와 비밀번호 확인이 같은지 확인하는 함수
function pssChk()
{
	
	let pss1 = $('#register').children('input[name=password]').val();
	let pss2 = $('#register').children('input[name=passwordCh]').val();
	
	if(pss1 == null || pss1 == ''
	 || pss2 == null || pss2 == '')
	{
		$('#pssChkMsg').html('※비밀번호를 입력해주세요.');
		return;
	}
	
	if(pss1 != pss2)
	{
		$('#pssChkMsg').html('※비밀번호가 일치하지 않습니다.');
		return;
	}
	else
	{
		$('#pssChkMsg').html('');
		return true;
	}
	
}

//	email 인증을 하는 함수
function emailChk()
{
	let email = $('#register').children('input[name=email]').val().trim();
	let email2 = $('#email2').val();
	
	if(email == null || email == '')
	{
		$('#idChkMsg').html('※이메일을 입력해주세요.');
		return;
	}
	
	$.ajax({
		type : 'POST',
		url : '/Shop/mailCheck',
		data:
		{
			email: email + email2
		},
		success: res =>
		{
			$('#idChkMsg').html('');
			code = res;
			alert('인증번호가 전송되었습니다.');
		},
		error: e =>
		{
			console.log('요청 실패: ', e.status);
		}		
	});
}

function mailcodeChk()
{
	
	let emailCode = $('#register').children('input[name=emailCode]').val().trim();
	
	if(code == undefined || code == null)
	{
		$('#idChkMsg').html('※이메일 인증을 진행해주세요.');
		return false;
	}
	
	if(emailCode == null || emailCode == '')
	{
		$('#idChkMsg').html('※이메일 인증문자를 입력해주세요.');
		return false;
	}
	
	if(code != emailCode)
	{
		$('#idChkMsg').html('※인증번호가 일치하지 않습니다.');
		return false;
	}
	else
	{
		$('#idChkMsg').html('※이메일 인증이 완료되었습니다.');
		return true;
	}
	
}
	


function register()
{
	//	비밀번호 검사를 통과 못하면 종료
	if(!pssChk())
	{
		//$('#idChkMsg').html('※비번체크  빈칸을 다 채워주세요.');
		return;
	}
	
	if(!mailcodeChk())
	{
		return;
	}
	
	let id = $('#register').children('input[name=id]').val().trim();
	let pss = $('#register').children('input[name=password]').val().trim();
	let name = $('#register').children('input[name=name]').val().trim();
	let email = $('#register').children('input[name=email]').val().trim();
	let email2 = $('#email2').val();
	if(id == null || id == '' ||
		name == null || name == '' ||
		email == null || email == '')
	{
		$('#idChkMsg').html('※빈칸을 다 채워주세요.');
		return;
	}


	$.ajax(
		{
			type: 'POST',
			url: '/Shop/logRegi/',
			data: 
			{
				userID: id.toLowerCase(),
				userPSS: pss,
				userName: name,
				userEmail: email + email2,
				SvtKind: 'regiChk'
			},
			success: res =>
			{
				switch(res)
				{
					case '0':
						$('#idChkMsg').html('※사용중인 아이디 입니다~~~');
						$('#register').children('input[name=id]').val('');
						break;
					case '1':
						$('#idChkMsg').html('');
						$('#pssChkMsg').html('');
						closeRtnRegiSucc();
						break;
				}
				
			},
			error: e =>
			{
				console.log('요청 실패: ', e.status);
			}
		});

}

//	회원가입 성공시
function closeRtnRegiSucc()
{
	$('#hRegiMsg').html('회원가입 성공');
	$('#pRegiMsg').html('저희 회원이 되신것을 진심으로 축하드립니다~~~ 놀라운 혜택들을 손쉽게 누리세요');
	
	$('button[name=forRegi]')[0].style.display = 'none';
	$('button[name=forRegi]')[1].style.display = 'none';
	$('button[name=forRegi]')[2].style.display = 'none';
	
	$('#regiField').children().children().attr("disabled", "disabled");
}

function login()
{
	
	let id = $('#login').children('input[name=id]').val().trim();
	let pss = $('#login').children('input[name=password]').val().trim();
	
	if(id == null || id == '')
	{
		$('#loginMsg').html('※아이디를 입력해주세요');
		return;
	}
	if(pss == null || pss == '')
	{
		$('#loginMsg').html('※비밀번호를 입력해주세요');
		return;
	}


	$.ajax(
		{
			type: 'POST',
			url: '/Shop/logRegi/',
			data: 
			{
				userID: id.toLowerCase(),
				userPSS: pss,
				SvtKind: 'login'
			},
			success: res =>
			{
				switch(res)
				{
					case '0':
						loginSuccess();
						break;
					case '1':
						$('#loginMsg').html('아이디 또는 비밀번호를 확인하세요.');
						break;
				}
				
			},
			error: e =>
			{
				console.log('요청 실패: ', e.status);
			}
		});

}



function loginSuccess()
{
	opener.location.reload();
	self.close();
}




function findID()
{
	let email = $('#findID').children('input[name=email]').val().trim();
	

	if(email == null || email == '')
	{
		$('#findIDMsg').html('※이메일을 입력해주세요.');
		return;
	}
	
//	우선 이메일기준으로 DB에 저장된 값이 있는지 검사해서 ID들을 얻어온다.
	$.ajax(
		{
			type: 'POST',
			url: '/Shop/logRegi/',
			data: 
			{
				userMail: email,
				SvtKind: 'findID'
			},
			success: res =>
			{
				switch(res)
				{
					case '0':
						$('#findIDMsg').html('해당 이메일로 가입한 ID를 보냈습니다.');
						findMail(email);
						break;
					case '1':
						$('#findIDMsg').html('해당 이메일로 가입한 고객이 존재하지 않습니다.\n확인 후 이용 바랍니다.');
						break;
				}
				
			},
			error: e =>
			{
				console.log('요청 실패: ', e.status);
			}
		});
	
	
	
}

function findPss()
{
	let id = $('#findPss').children('input[name=id]').val().trim();
	
	
	if(id == null || id == '')
	{
		$('#findPssMsg').html('※아이디를 입력해주세요.');
		return;
	}
	
//	우선 이메일기준으로 DB에 저장된 값이 있는지 검사해서 ID들을 얻어온다.
	$.ajax(
			{
				type: 'POST',
				url: '/Shop/logRegi/',
				data: 
				{
					userID: id,
					SvtKind: 'findPSS'
				},
				success: res =>
				{
//					console.log(JSON.parse(res));
					let result = JSON.parse(res);
					switch(result.type)
					{
					case '0':
						$('#findPssMsg').html('가입된 이메일로 비밀번호를 보냈습니다.');
						findMail(result.email);
						break;
					case '1':
						$('#findPssMsg').html('해당 아이디로 가입한 고객이 존재하지 않습니다.\n확인 후 이용 바랍니다.');
						break;
					}
					
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
	
	
	
}

// 해당 email로 가입한 유저가 있으면 그 유저에게 메일을 보내주는 함수
function findMail(email)
{
	$.ajax({
		type : 'POST',
		url : '/Shop/mailFind',
		data:
		{
			email: email
		},
		success: res =>
		{
			alert('메일 전송 완료');
		},
		error: e =>
		{
			console.log('요청 실패: ', e.status);
		}		
	});
}



