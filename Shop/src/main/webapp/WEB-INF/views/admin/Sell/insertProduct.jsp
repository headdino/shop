<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/product.js" />" ></script>
</head>
<body>

	
	<!-- header -->
	<%@ include file="/WEB-INF/views/util/hfer/header.jsp" %>
	
	<select id="category-large" onChange="category_change(this.value,'large')" >
	  <option>-선택-</option>
	  <option value='00'>반려동물 용품</option>
	  <option value='01'>식품</option>
	  <option value='02'>생활 용품</option>
	</select>
	<select id="category-medium" onChange="category_change(this.value, 'medium')" >
	  <option>-선택-</option>
	</select>
	<select id="category-small">
		<option>-선택-</option>
	</select>
	<br/><br/>
	브랜드: <input type="text" id="brand" />
	<br/><br/>
	<h3>*같은 카테고리 내에 이미 등록된 상품명일 경우 기존에 등록된 상품으로 등록됩니다.*</h3>
	상품명: <input type="text" id="productName" />
	<br/><br/>
	판매자: <input type="text" id="sellID"  readonly="readonly" value="${loginVO.id}"/>
	<br/><br/>
	가격:  <input type="text" id="price" />
	<br/><br/>
	배송비: <input type="text" id="delivery_charge" />
	<br/><br/>
	배송사: <input type="text" id="delivery_company" />
	<br/><br/>
	수량: <input type="text" id="stock" />
	<br/><br/>
	<h3>*이미지1과 상세페이지는 필수고 이미지2~4는 선택사항입니다.	*</h3>
	이미지1: <input type="text" id="imgurl1" style="width: 350px;"/>
	<img alt="이미지1" src="" 
	id="img1" referrerpolicy="no-referrer" style="height: 230px; width: 230px; 
	margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center; display:none;">
	<br/><br/>
	이미지2: <input type="text" id="imgurl2" style="width: 350px;" />
	<img alt="이미지2" src="" 
	id="img2" referrerpolicy="no-referrer" style="height: 230px; width: 230px; 
	margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center; display:none;">
	<br/><br/>
	이미지3: <input type="text" id="imgurl3" style="width: 350px;" />
	<img alt="이미지3" src="" 
	id="img3" referrerpolicy="no-referrer" style="height: 230px; width: 230px; 
	margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center; display:none;">
	<br/><br/>
	이미지4: <input type="text" id="imgurl4" style="width: 350px;" />
	<img alt="이미지4" src="" 
	id="img4" referrerpolicy="no-referrer" style="height: 230px; width: 230px; 
	margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center; display:none;">
	<br/><br/>
	상세페이지: <input type="text" id="detailImgurl" />
	<br/><br/>
	<button class="btn btn-outline-primary" onclick="imgView()">이미지 미리보기</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-outline-warning" onclick="insertProduct()">등록하기</button>
	
	
	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>
	


</body>
</html>