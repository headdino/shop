<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품보기</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/product.js" />" ></script>
</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/util/hfer/header.jsp" %>
	<br/><br/>
	
	<c:set var="review" value="${reviewList}"/>
	<div class="container" style="margin-top: 100px; width: 1200px">
		<table class="table table-bordered">
			<thead>
				<tr class="table-primary" style="box-sizing: border-box;">
					<th colspan="10" style="font-size: 20px; text-align: center; padding: 10px; margin: 10px; font-size: 25px;">${categoryStr}</th>
				</tr>
				<tr class="table-primary">
					<th class="info" colspan="10" style="text-align: right; vertical-align: middle;">
						<h4>${pdVO.pd_brand}</h4>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td rowspan="4" width="50px;">
						<img alt="상품 이미지" referrerpolicy="no-referrer" onmouseover="hoverImage('${pdImgVO.img1}')"
						src="${pdImgVO.img1}" style="height: 50px; width: 50px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;">
					</td>
				</tr>
				<tr>
					<c:if test="${pdImgVO.img2 != null}">
						<td rowspan="4" width="50px;">
							<img alt="상품 이미지" referrerpolicy="no-referrer" onmouseover="hoverImage('${pdImgVO.img2}')"
							src="${pdImgVO.img2}" style="height: 50px; width: 50px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;">
						</td>
					</c:if>
				</tr>
				<tr>
					<c:if test="${pdImgVO.img3 != null}">
						<td rowspan="4" width="50px;">
							<img alt="상품 이미지" referrerpolicy="no-referrer" onmouseover="hoverImage('${pdImgVO.img3}')"
							src="${pdImgVO.img3}" style="height: 50px; width: 50px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;">
						</td>
					</c:if>
				</tr>
				<tr>
					<c:if test="${pdImgVO.img4 != null}">
						<td rowspan="4" width="50px;">
							<img alt="상품 이미지" referrerpolicy="no-referrer" onmouseover="hoverImage('${pdImgVO.img4}')"
							src="${pdImgVO.img4}" style="height: 50px; width: 50px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;">
						</td>
					</c:if>
				</tr>
				<tr>
					<td rowspan="10" width="100px">
						<img id="image_bigSize" src="${pdImgVO.img1}">
					</td>
				</tr>
				<tr>
					<th width="200px">상품명</th>
					<td width="650px">
						${pdVO.pd_name}
					</td>
				</tr>
				<tr>
					<th>평점</th>
					<td>
						<c:forEach var="i" begin="1"  end="5" >
							<c:if test="${pdVO.pd_score >= i * 2}">
								<img alt="별점" src="<c:url value="/resources/images/star.png" />" height="20px">
							</c:if>
						</c:forEach>
						<c:if test="${pdVO.pd_score % 2 == 1}">
							<img alt="별점" src="<c:url value="/resources/images/starhalf.png" />" height="20px">
						</c:if>		
						${reviewList.size()}개 상품평		
					</td>
				</tr>
				<tr>
					<th>가격</th>
					<td>
						<fmt:formatNumber value="${sellerVO.price}" pattern="#,###원"/>
					</td>
				</tr>
				<tr>
					<th>배송비</th>
					<td>
						<c:if test="${sellerVO.delivery_charge == 0}">
							무료배송
						</c:if>	
						<c:if test="${sellerVO.delivery_charge != 0}">
							<fmt:formatNumber value="${sellerVO.delivery_charge}" pattern="#,###원"/>
						</c:if>	
					</td>
				</tr>
				<tr>
					<th>판매자</th>
					<td>
						${sellerName}
					</td>
				</tr>
				<tr>
					<th>배송사</th>
					<td>
						${sellerVO.delivery_company}
					</td>
				</tr>
				<tr>
					<th>남은 재고수량</th>
					<td>
						${sellerVO.stock}
					</td>
				</tr>
				<tr>
					<td>
						<input id="product_count" type="number" value="1" autocomplete="off"/>
						<c:if test="${sellerVO.stock <= 0}">
							<button>품절</button>
						</c:if>
						<c:if test="${sellerVO.stock > 0}">
							<button onclick="insertCart('${sellerVO.pd_code}', '${sellerVO.id}')">장바구니 담기</button>
						</c:if>
						
					</td>
				</tr>
				<tr>
					<td>
						<h6>상품번호: ${sellerVO.pd_code}</h6>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<img alt="상품 이미지" referrerpolicy="no-referrer" src="${pdImgVO.detailimg}" style="width: 700px; margin: 15px; 
						padding: 5px 5px; border-radius: 20px; align-content: center;">
					</td>				
				</tr>
				<tr>
					<td colspan="5" align="right">
						<button class="btn btn-outline-secondary" onclick="location.href='/Shop/category/list/?category=${categoryStr}&currentPage=${currentPage}'">돌아가기</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div><br/>
	
	<hr style="width: 1000px; margin-left: auto; margin-right: auto;"/><br/>
	
	
	<table class="table" style="width: 1400px; margin-left: auto; margin-right: auto;">
		<tr class="table-primary">
			<th colspan="4">상품평(${reviewList.size()})</th>
			<td colspan="4">
			동일한 상품에 대해 작성된 상품평으로 판매자는 다를 수 있습니다.<br/>
			<c:forEach var="i" begin="1"  end="5" >
				<c:if test="${pdVO.pd_score >= i * 2}">
					<img alt="별점" src="<c:url value="/resources/images/star.png" />" height="20px">
				</c:if>
			</c:forEach>
			<c:if test="${pdVO.pd_score % 2 == 1}">
				<img alt="별점" src="<c:url value="/resources/images/starhalf.png" />" height="20px">
			</c:if>	
			${reviewList.size()}
			</td>
		</tr>			
	</table>
	<table class="table" style="width: 1400px; margin-left: auto; margin-right: auto;">	
		<tr>
			<th width="100px">닉네임</th>
			<th width="100px">별점</th>
			<th width="500px">내용</th>
			<th width="100px">판매자</th>
			<th width="200px">작성시각</th>
		</tr>
		<!-- 리뷰가 없는 경우 -->
		<c:if test="${reviewList.size() == 0}">
			<tr align="center">
				<td colspan="4" style="margin: 20px;">
					<h2>아직 작성된 리뷰가 없습니다.</h2>
				</td>
			</tr>
		</c:if>
		<c:if test="${reviewList.size() != 0}">
			<c:forEach var="review" items="${reviewList}" varStatus="i">
				<tr>
					<td>${reviewerNameList[i.index]}(${review.id})</td>
					<td>
						<c:forEach var="i" begin="1"  end="5" >
							<c:if test="${review.score >= i * 2}">
								<img alt="별점" src="<c:url value="/resources/images/star.png" />" height="20px">
							</c:if>
						</c:forEach>
						<c:if test="${review.score % 2 == 1}">
							<img alt="별점" src="<c:url value="/resources/images/starhalf.png" />" height="20px">
						</c:if>	
					</td>
					<c:set var="content" value="${fn:replace(review.reviews, '<', '&lt;')}"/>
					<c:set var="content" value="${fn:replace(content, '>', '&gt;')}"/>
					<c:set var="content" value="${fn:replace(content, enter, '<br/>')}"/>
					<td> ${content}</td>
					<td>${review.seller_id}</td>
					<td>
						${review.write_date}
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	

	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>

</body>
</html>