<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 찾기</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<link rel="stylesheet" href="<c:url value="/resources/css/login_form.css" />">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/login_form.js" />" ></script>
</head>
<body>

	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<div class="form">
				<h1>비밀번호 찾기</h1>
				<!-- <div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div> -->
				<div id="findPss">
					가입한 아이디를 입력하시면 <br/>가입할때 기입한 이메일로 보내드립니다.
					<input type="text" name="id" placeholder="아이디" autocomplete="off"/>
					<button class="btn-sm skyblue" onclick="findPss()">메일보내기</button>
				</div>
			</div>
		</div>
		<div class="form-container sign-in-container">
			<div class="form">
				<h1>아이디 찾기</h1>
				<!-- <div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
					<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
					<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div> -->
				<div id="findID">
					가입한 이메일 주소를 적어주세요.
					<input type="email" name="email" placeholder="이메일" />
					<button class="skyblue" onclick="findID()">메일보내기</button>
				</div>
			</div>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>아이디를 잊었나요?</h1>
					<p>아이디는 이쪽에서 찾으실 수  있습니다.</p>
					
					<!-- 비밀번호찾기 결과가 출력된 공간 -->
					<h5 id="findPssMsg" style="color: white; font-weight: bold;"></h5>
					
					<button class="skyblue" id="signIn">아이디 찾기</button>
					
				</div>
				<div class="overlay-panel overlay-right">
					<h1>아이디는 아시나요?</h1><!-- findPass -->
					<p>비밀번호는 이쪽에서 찾으실 수 있습니다.</p>
					
					<!-- 아이디찾기 결과가 출력된 공간 -->
					<h5 id="findIDMsg" style="color: white; font-weight: bold;"></h5>
					
					<button class="green" onclick="location.href='/Shop/login/'">로그인 창 돌아가기</button><br/>
					<button class="skyblue" id="signUp">비밀번호 찾기</button>
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