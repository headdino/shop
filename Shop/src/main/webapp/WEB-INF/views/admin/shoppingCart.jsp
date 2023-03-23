<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script defer="defer" type="text/javascript" src="<c:url value="/resources/js/shopCart.js" />" ></script>
</head>
<body>

	
	<!-- header -->
	<%@ include file="/WEB-INF/views/util/hfer/header.jsp" %>
	
	<h1>장바구니</h1>
	
	<table class="table table-success" style="width: 90%; margin-left: auto; margin-right: auto;">	
		<tr align="center">
			<th width="350px">상품이름</th>
			<th width="200px">수량</th>
			<th width="100px">상품가격</th>
			<th width="100px">배송비</th>
		</tr>
		<!-- 장바구니가 없는 경우 -->
		<c:if test="${cartList.size() == 0}">
			<tr align="center">
				<td colspan="4" style="margin: 20px;">
					<h2>장바구니에 담은 상품이 없습니다.</h2>
				</td>
			</tr>
		</c:if>
		<c:if test="${cartList.size() != 0}">
			<c:forEach var="cart" items="${cartList}" varStatus="i">
				<tr align="center">
					<td>
						<div class="cart_info">
							<input type="hidden" class="productPrice" value="${sellerList[i.index].price * cart.count}"/>
							<input type="hidden" class="delivery_charge" value="${sellerList[i.index].delivery_charge}"/>
						</div>
						<a href="/Shop/category/list/products?code=${productList[i.index].pd_code}&currentPage=1&sellerId=${sellerList[i.index].id}&categoryStr=전체">
							${productList[i.index].pd_name}(${productList[i.index].pd_brand})
							<img alt="상품 이미지" referrerpolicy="no-referrer" src="${productList[i.index].pd_image}" 
							style="height: 80px; width: 80px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;">
						</a>
					</td>
					<td>
						<input class="cartCount" type="number" value="${cart.count}" autocomplete="off" style="width:50px;"/>
						<button onclick="cart_remove('${productList[i.index].pd_code}', '${sellerList[i.index].id}')">X</button><br/><br/>
						<button class="btn btn-sm btn-info" onclick="cart_update('${productList[i.index].pd_code}', '${sellerList[i.index].id}', '${i.index}')">수량변경</button>
					</td>
					<td valign="middle">
						<fmt:formatNumber value="${sellerList[i.index].price}" pattern="#,###원"/>
					</td>
					<td valign="middle">
						<fmt:formatNumber value="${sellerList[i.index].delivery_charge}" pattern="#,###원"/>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td align="right">
					상품 금액: 
				</td>
				<td align="left">
					<span id="productPrice">1000</span> 원
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td align="right">
					배송비: 
				</td>
				<td align="left">
					<span id="delivery_charge">1000</span> 원
				</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td align="right">
					총 결제 금액: 
				</td>
				<td align="left">
					<span id="totalPrice">1000</span> 원
				</td>
			</tr>
		</c:if>
	</table>
	
	
	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>


</body>
</html>