$(function()
{
//	onload 함수로 처음 페이지들어올때 가격 합계를 구해줌

	caculPrice();
	
}); 

//	장바구니 안에 상품종류만큼 반복해서 가격의 총합을 구한다.
function caculPrice()
{
	let productPrice = 0;
	let delivery_charge = 0;
	let totalPrice = 0;
	
	
	$('.cart_info').each(function(index, element)
	{
		productPrice += parseInt($(element).find(".productPrice").val());
		delivery_charge += parseInt($(element).find(".delivery_charge").val());
		totalPrice += productPrice + delivery_charge;
	});
	
	
	
	$('#productPrice').text(productPrice.toLocaleString());
	$('#delivery_charge').text(delivery_charge.toLocaleString());
	$('#totalPrice').text(totalPrice.toLocaleString());
}


//	쇼핑카트에서 물건을 제거하는 ajax요청
function cart_remove(code, id)
{
	$.ajax(
			{
				type: 'POST',
				url: 'cartRemoveAjax',
				data: 
				{
					code: code,
					sellerID: id
				},
				success: res =>
				{
					location.reload();
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

//	쇼핑카트에서 물건개수를 변경하는 ajax 요청
function cart_update(code, id, idx)
{
	let count = $('.cartCount').eq(idx).val();

	if(count < 1)
	{
		count = 1;
	}
	
	$.ajax(
			{
				type: 'POST',
				url: 'cartUpdateAjax',
				data: 
				{
					code: code,
					sellerID: id,
					count: count
				},
				success: res =>
				{
					location.reload();
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}





















