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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4de4206e2d6a84be146b474073b38dd8&libraries=services"></script>
<script defer="defer" type="text/javascript" src="<c:url value="resources/js/juso.js" />"></script> 
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
					닉네임: <input type="text"  id="nickname" value="${loginVO.nickname}"/>
					<div style="width: 450px; height: 80px;">이메일: ${loginVO.email}</div>
					<div style="width: 450px; height: 80px;">가입일: ${loginVO.signdate}</div>
					<input type="text" id="addrName" placeholder="배송지 이름"><br/><br/>
					<input type="text" id="addr" placeholder="주소" readonly="readonly" style="width: 300px">
					<input type="text" id="detail_address" placeholder="상세주소">
					<input class="btn btn-primary" type="button" onclick="DaumPostcode()" value="주소 검색"><br/>
					<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div><br/><br/>
					<input type="text" id="phone" placeholder="전화번호"><br/><br/>
					<input type="text" id="memo" placeholder="배송메모" style="width: 300px"><br/><br/>
					<button class="btn btn-primary" onclick="saveAddr('save')">배송지 저장하기</button>
					<button class="btn btn-warning" id="updateAddrBtn" onclick="saveAddr('update')" style="display:none" >배송지 수정완료</button><br/><br/><br/>
					
					<c:if test="${addrList.size() != 0}">
						<c:forEach var="addr" items="${addrList}">
							<div style="width: 450px; height: 30px;">배송지이름: ${addr.addrName}</div>
							<div style="width: 450px; height: 30px;">배송지: ${addr.addr}</div>
							<div style="width: 450px; height: 30px;">상세주소: ${addr.detail_addr}</div>
							<div style="width: 450px; height: 30px;">전화번호: ${addr.phone}</div>
							<div style="width: 450px; height: 30px;">배송메모: ${addr.memo}</div><br/>
							
							<button class="btn btn-danger" onclick="delAddr('${addr.addrName}')">배송지 삭제</button> &nbsp;
							<button class="btn btn-warning" onclick="findAddr('${addr.addrName}')">배송지 수정</button><br/><br/>
						</c:forEach>
					</c:if>
					
					<br/><br/>
					<button class="btn btn-primary" onclick="updateMember()" >정보수정</button>
				</div>
				
			</div>
		</div><br/><br/><br/>
	</div>
	
	
	
	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>
	


</body>
</html>