<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리</title>
<link rel="icon" href="<c:url value="/resources/images/favicon-32x32.png" />" />
<script	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/listView.css" />" />
</head>
<body>

	
	<!-- header -->
	<%@ include file="/WEB-INF/views/util/hfer/header.jsp" %>
	
	<div class="m-3">
		<table class="table" style="width: 1200px; margin-left: auto; margin-right: auto; box-sizing: border-box;">
			<tr class="table-primary" style="box-sizing: border-box;">
				<th colspan="4" style="font-size: 20px; text-align: center; padding: 10px; margin: 10px; font-size: 25px;">${categoryStr} 상품 보기</th>
			</tr>			
			<tr>
				<td colspan="3" align="right" style="vertical-align: middle;">
					${productList.totalCount} 건 (${productList.currentPage} / ${productList.totalPage})<br/>	
				</td>
			</tr>
			<tr class="table table-light">
				<th colspan="4" style="text-align: center; font-size: 20px; padding: 18px">상품 목록</th>
			</tr>		
		
			<tbody id="ajaxTable">
			<!-- 상품 목록을 출력한다. -->
			<!-- productList에서 1페이지 분량의 글이 저장된 ArrayList를 꺼내온다. -->
			<c:set var="list" value="${productList.sellerList}"/>
			<c:set var="pdList" value="${productList.pdList}"/>
			
			<!-- 상품 목록이 1건도 없으면 글이 없다고 출력한다. -->
			<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="6" align="center">
					<h2>준비된 상품이 없습니다.</h2>			
				</td>
			</tr>
			</c:if>
			
			<c:if test="${list.size() != 0}">
				<tr>
					<c:forEach var="vo" items="${list}" varStatus="i">
						<td>
							<div style="box-sizing: border-box;">
								<div style="padding: 30px 10px; box-sizing: border-box;" id="hov_item">
									<a href="/Shop/category/list/products?code=${vo.pd_code}&currentPage=${productList.currentPage}&sellerId=${vo.id}&categoryStr=${categoryStr}">
										<img alt="상품 이미지" referrerpolicy="no-referrer" src="${pdList[i.index].pd_image}" style="height: 230px; width: 230px; margin: 15px; padding: 5px 5px; border-radius: 20px; align-content: center;"><br/>
										&nbsp;&nbsp;&nbsp;<span style="font-size: 20px;">${pdList[i.index].pd_brand} ${sellerNameList[i.index]} ${pdList[i.index].pd_name}</span>
									</a>
									&nbsp;&nbsp;&nbsp;<fmt:formatNumber value="${vo.price}" pattern="#,###원"/>
									<c:if test="${vo.stock <= 0}">
										품절
									</c:if>
									<c:forEach var="j" begin="1"  end="5" >
										<c:if test="${pdList[i.index].pd_score >= j * 2}">
											<img alt="별점" src="<c:url value="/resources/images/star.png" />" height="20px">
										</c:if>
									</c:forEach>
									<c:if test="${pdList[i.index].pd_score % 2 == 1}">
										<img alt="별점" src="<c:url value="/resources/images/starhalf.png" />" height="20px">
									</c:if>	
								</div>
							</div>
						</td>				
					<c:if test="${i.count % 3 == 0}">
							<tr style="border-color: transparent;">
							</tr>
					</c:if>
					</c:forEach>
				</tr>
			</c:if>
	
			<!-- 페이지 이동 버튼 -->
			<tr align="center" class="table table-light">
				<td colspan="5">
				
				<!-- 처음으로 -->
				<c:if test="${productList.currentPage > 1}">
					<button class="btn btn-outline-primary" title="첫 번째 페이지로 이동합니다." onclick="location.href='?category=${categoryStr}&currentPage=1'">≪</button>							
				</c:if>
				<c:if test="${productList.currentPage <= 1}">
					<button class="btn btn-outline-secondary" disabled title="첫 번째 페이지입니다.">≪</button>						
				</c:if>

				<!-- 10페이지 앞으로 -->
				<c:if test="${productList.startPage > 1}">
					<button class="btn btn-outline-primary" title=" 10페이지 앞으로 이동합니다." onclick="location.href='?category=${categoryStr}&currentPage=${itemList.startPage-1}'">＜</button>							
				</c:if>
				<c:if test="${productList.startPage <= 1}">
					<button class="btn btn-outline-secondary" disabled title="첫 10페이지입니다.">＜</button>				
				</c:if>
												
				<!-- 페이지 선택 -->
				<c:forEach var="i" begin="${productList.startPage}" end="${productList.endPage}" step="1">
					<c:if test="${productList.currentPage == i}">
						<input class="btn btn-outline-secondary" type="button" value="${i}" disabled/>	
					</c:if>
					<c:if test="${productList.currentPage != i}">
						<input class="btn btn-outline-primary" type="button" value="${i}" onclick="location.href='?category=${categoryStr}&currentPage=${i}'" value="${i}"/>	
					</c:if>							
				</c:forEach>

				<!-- 10페이지 뒤로 -->
				<c:if test="${productList.endPage < productList.totalPage}">
					<button class="btn btn-outline-primary" title=" 10페이지 뒤로 이동합니다." onclick="location.href='?category=${categoryStr}&currentPage=${productList.endPage+1}'">＞</button>								
				</c:if>
				<c:if test="${productList.endPage >= productList.totalPage}">
					<button class="btn btn-outline-secondary" disabled title="마지막 10페이지입니다.">＞</button>							
				</c:if>
				
				<!-- 마지막으로 -->
				<c:if test="${productList.currentPage < productList.totalPage}">
					<button class="btn btn-outline-primary" title="마지막 페이지로 이동합니다." onclick="location.href='?category=${categoryStr}&currentPage=${productList.totalPage}'">≫</button>								
				</c:if>
				<c:if test="${productList.currentPage >= productList.totalPage}">
					<button class="btn btn-outline-secondary" disabled title="마지막 페이지입니다.">≫</button>						
				</c:if>
				</td>	
					
				<!-- 상품 입력 버튼 -->
				<td align="right" colspan="1">
					<c:if test="${loginVO.grade == '판매자'}">
						<input class="btn btn-outline-primary" type="button" value="상품 입력" onclick="location.href='/Shop/seller/insert'"/>
					</c:if>
				</td>					
			</tr>
			</tbody>
		</table>
		<br/><br/>
	</div>
	
	
	
	<!-- footer  -->
	<%@ include file="/WEB-INF/views/util/hfer/footer.jsp" %>
	


</body>
</html>