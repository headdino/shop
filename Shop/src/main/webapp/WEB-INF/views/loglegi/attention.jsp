<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/main.js" />" ></script>
</head>
<body>


	<h1>해당 페이지는 로그인한 회원만 이용이 가능합니다.</h1>

 	<input type="button" class="btn btn-primary" onclick="openwin()" value="로그인/회원가입">
 	<input type="button" class="btn btn-primary" onclick="location.href='/Shop/'" value="메인으로 돌아가기">

	<c:if test="${loginVO != null}">
		<script type="text/javascript">
			location.href="/Shop/";
		</script>
	</c:if>
</body>
</html>