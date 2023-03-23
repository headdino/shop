<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	
	<!-- header -->
	<%@ include file="/WEB-INF/views/util/hfer/header.jsp" %>
	
	<div class="m-3">
		<jsp:useBean id="date" class="java.util.Date" />
		<div id="wrap">
			<nav style="display: none;">메뉴영역</nav>
			<div id="content">
				<div class="container mt-3" align="center" style="vertical-align: middle;">
					<div style="padding: 80px 20px;">
						<img src="<c:url value="/resources/images/profile.jpg" />" id="profile" width=150px>
					</div>
					<h2 style="padding-bottom: 15px">이름: ${loginVO.name}</h2>
					<div style="width: 450px; height: 80px;">등급: ${loginVO.grade}</div>
					<div style="width: 450px; height: 80px;">닉네임: ${loginVO.nickname}</div>
					<div style="width: 450px; height: 80px;">이메일: ${loginVO.email}</div>
					<div style="width: 450px; height: 80px;">가입일: ${loginVO.signdate}</div>
					<c:if test="${addrList.size() == 0 }">
						<div>저장된 주소록이 없습니다. 정보수정을 통해 주소록을 입력해주세요.</div>
					</c:if>
					<c:if test="${addrList.size() != 0}">
						<c:forEach var="addr" items="${addrList}">
							<div style="width: 450px; height: 30px;">배송지이름: ${addr.addrName}</div>					
							<div style="width: 450px; height: 30px;">배송지: ${addr.addr}</div>					
							<div style="width: 450px; height: 30px;">전화번호: ${addr.phone}</div>					
							<div style="width: 450px; height: 30px;">배송메모: ${addr.memo}</div><br/>
							<div>------------------------------------------------------</div><br/>
						</c:forEach>
					</c:if>
					
					<br/><br/><br/><br/>
					<button onclick="location.href='/Shop/mypage-update'" >정보수정</button>
				</div>
				
			</div>
		</div><br/><br/><br/>
	</div>
	
	
	
	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>


</body>
</html>