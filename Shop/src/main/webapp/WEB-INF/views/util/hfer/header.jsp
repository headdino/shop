<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/header.css" />" />
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/main.js" />" ></script>
</head>
<body>
	<!-- header -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="/Shop/">Shop</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarColor01">
		      <ul class="navbar-nav me-auto">
		       <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown" role="button" aria-haspopup="true" id="dropdownMenuClickableInside" data-bs-auto-close="outside" aria-expanded="false">식품코너</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="/Shop/category/list/?category=식품&currentPage=1">식품</a>
		            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=식품>과일&currentPage=1">&nbsp;&nbsp;과일</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
						            	<a class="dropdown-item" href="/Shop/category/list/?category=식품>과일>사과/배&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;사과/배</a>
						           		<a class="dropdown-item" href="/Shop/category/list/?category=식품>과일>귤/한라봉/감귤류&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;귤/한라봉/감귤류</a>
						            	<a class="dropdown-item" href="/Shop/category/list/?category=식품>과일>수박/메론/참외&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;수박/메론/참외</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=식품>채소&currentPage=1">&nbsp;&nbsp;채소</a> 
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>채소>두부/콩나물&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;두부/콩나물</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>채소>오이/고추/열매채소&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;오이/고추/열매채소</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>채소>건나물/건채소&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;건나물/건채소</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란&currentPage=1">&nbsp;&nbsp;축산/계란</a>
					            <div class="dropdown-divider"></div>
					           		<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
						            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란>소고기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;소고기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란>돼지고기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;돼지고기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란>닭/오리고기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;닭/오리고기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란>양/말고기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;양/말고기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>축산/계란>계란/알류/가공란&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;계란/알류/가공란</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식&currentPage=1">&nbsp;&nbsp;간식</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식>과자&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;과자</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식>쿠키/파이&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;쿠키/파이</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식>초콜릿&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;초콜릿</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식>젤리&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;젤리</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=식품>간식>전통과자/떡&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;전통과자/떡</a>
		            				</div>
		          </div>
		        </li>
		       <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown" role="button" aria-haspopup="true" id="dropdownMenuClickableInside" data-bs-auto-close="outside" aria-expanded="false">생활용품코너</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품&currentPage=1">생활용품</a>
			            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>화장지/물티슈&currentPage=1">&nbsp;&nbsp;화장지/물티슈</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>화장지/물티슈>화장지&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;화장지</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>화장지/물티슈>갑티슈/여행용티슈&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;갑티슈/여행용티슈</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>화장지/물티슈>물티슈&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;물티슈</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>화장지/물티슈>키친타올&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;키친타올</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>욕실용품&currentPage=1">&nbsp;&nbsp;욕실용품</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>욕실용품>샤워기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;샤워기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>욕실용품>수건/타월&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;수건/타월</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>욕실용품>욕실화&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;욕실화</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=생활 용품>욕실용품>욕조&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;욕조</a>
					            	</div>
		          </div>
		        </li>
		       <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown" role="button" aria-haspopup="true" id="dropdownMenuClickableInside" data-bs-auto-close="outside" aria-expanded="false">강아지코너</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품&currentPage=1">반려동물용품</a>
		            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지사료&currentPage=1">&nbsp;&nbsp;강아지사료</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지사료>건식&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;건식</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지사료>습식&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;습식</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지사료>분유&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;분유</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지간식&currentPage=1">&nbsp;&nbsp;강아지간식</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지간식>캔&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;캔</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지간식>덴탈껌&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;덴탈껌</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지간식>건조간식/육포&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;건조간식/육포</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지간식>음료&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;음료</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품&currentPage=1">&nbsp;&nbsp;강아지용품</a>
		          				<div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품>하우스/울타리&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;하우스/울타리</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품>급식기/급수기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;급식기/급수기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품>의류/패션&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;의류/패션</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품>배변용품&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;배변용품</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>강아지용품>장난감/훈련용품&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;장난감/훈련용품</a>
					            	</div>
		          </div>
		        </li>
		       <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle active" data-bs-toggle="dropdown" role="button" aria-haspopup="true" id="dropdownMenuClickableInside" data-bs-auto-close="outside" aria-expanded="false">고양이코너</a>
		          <div class="dropdown-menu">
		            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품&currentPage=1">반려동물용품</a>
					        <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이사료&currentPage=1">&nbsp;&nbsp;고양이사료</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이사료>건식&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;건식</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이사료>습식&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;습식</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이사료>분유&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;분유</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이간식&currentPage=1">&nbsp;&nbsp;고양이간식</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이간식>캔&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;캔</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이간식>파우치&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;파우치</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이간식>동결/건조간식&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;동결/건조간식</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이간식>음료&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;음료</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품&currentPage=1">&nbsp;&nbsp;고양이용품</a>
					            <div class="dropdown-divider"></div>
					            	<a class="dropdown-item"  href="javascript:void(0)" onclick="openCategory(this)">&nbsp;&nbsp;▼펼치기</a>
					            	<div class="smallCate">
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품>캣타워/스크래쳐&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;캣타워/스크래쳐</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품>하우스/방석&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;하우스/방석</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품>급식기/급수기&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;급식기/급수기</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품>모래/화장실&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;모래/화장실</a>
							            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>고양이용품>장난감&currentPage=1">&nbsp;&nbsp;&nbsp;&nbsp;장난감</a>
					            	</div>
					            <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/Shop/category/list/?category=반려동물 용품>관상어용품&currentPage=1">&nbsp;&nbsp;관상어용품</a>
					            <div class="dropdown-divider"></div>
		          </div>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/Shop/category/list/?category=전체&currentPage=1">전체상품보기</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/Shop/mypage/cartView">장바구니</a>
		        </li>
		       
		       
		      </ul>
		      <form class="border">
		      	<c:if test="${loginVO == null}">
					<a class="nav-link"  href="javascript:void(0)" onclick="openwin()">로그인/회원가입</a>
		      	</c:if>
		      	<c:if test="${loginVO != null}">
		      		<a class="nav-link"  href="/Shop/mypage/">${loginVO.name}님 안녕하세요.</a><br/>
		      		<a class="nav-link"  href="javascript:void(0)" onclick="logout()">로그아웃</a>
	  				<h4>세션 만료시간</h4>
	  				<h4 id="loginTime"></h4>
		      	</c:if>
		      </form>
		    </div>
		  </div>
		</nav>
	</header>


</body>
</html>