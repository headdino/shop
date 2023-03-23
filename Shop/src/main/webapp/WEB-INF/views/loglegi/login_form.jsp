<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인/회원가입</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/login_form.css" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/login_form.js" />" ></script>
</head>
<body>

	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<div class="form">
				<h1>회원가입</h1>
				<!-- <div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div> -->
				<fieldset id="regiField">
					<div id="register">
						<input type="text" name="name" placeholder="이름" />
						<input type="text" name="id" placeholder="아이디" autocomplete="off"/>
						<input type="text" name="email" placeholder="E-메일" />
						<select class="form-control" name="email2" id="email2">
							<option>@naver.com</option>
							<option>@daum.net</option>
							<option>@gmail.com</option>
							<option>@hanmail.com</option>
							<option>@yahoo.co.kr</option>
						</select>
						<input type="text" name="emailCode" placeholder="인증문자" onkeyup="mailcodeChk()"/>
						<input type="password" name="password" placeholder="비밀번호" />
						<input type="password" name="passwordCh" placeholder="비밀번호 확인" onkeyup="pssChk()"/>
						<button name="forRegi" class="btn-sm skyblue" onclick="register()">회원가입</button>
					</div>
				</fieldset>
			</div>
		</div>
		<div class="form-container sign-in-container">
			<div class="form">
				<h1>로그인</h1>
				<!-- <div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div> -->
				<div id="login">
					<input type="text" name="id" placeholder="아이디" />
					<input type="password" name="password" placeholder="비밀번호" />
					<button class="skyblue" onclick="login()">로그인</button>
				</div>
			</div>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1 id="hRegiMsg">환영합니다!</h1>
					<p id="pRegiMsg">전국 어디에서도 경험할수없는 혜택들이 쏟아지는 잿투샵입니다.</p>
					
					<!-- 아이디 중복 검사 결과 메시지가 출력될 영역 -->
					<h5 id="idChkMsg" style="color: white; font-weight: bold;"></h5>
					<!-- 비밀번호 일치 검사 결과 메시지가 출력될 영역 -->
					<h5 id="pssChkMsg" style="color: white; font-weight: bold;"></h5>
					<button name="forRegi" class="green" onclick="idChk()">아이디 중복검사</button><br/>
					<button name="forRegi" class="black" onclick="emailChk()">이메일 인증하기</button><br/>
					<button class="skyblue" id="signIn">로그인 하러 가기</button>
					
				</div>
				<div class="overlay-panel overlay-right">
					<h1>회원이 아니신가요?</h1><!-- findPass -->
					<p>몇가지 개인정보를 입력한 뒤 잿투샵의 회원이 되어보세요.</p>
					
					<!-- 로그인 결과 메시지가 출력될 영역 -->
					<h5 id="loginMsg" style="color: white; font-weight: bold;"></h5>
					
					<button class="green" onclick="location.href='/Shop/find_acount/'">아이디/비밀번호 찾기</button><br/>
					<button class="skyblue" id="signUp">회원 가입 하기</button>
				</div>
			</div>
		</div>
	</div>
	
	<footer>
		<p>
		<i class="fa fa-heart"></i>
			<div id="footerMsg">have a nice day with our site</div>
		</p>
	</footer>



</body>
</html>