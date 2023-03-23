// 카테고리를 선택할 때 하위 카테고리를 변경해주기 위해 ajax 요청하는 함수
function category_change(key, size)
{
	
	
	$.ajax(
			{
				type: 'POST',
				url: 'category',
				data: 
				{
					cate_kind: key,
					cate_size: size
				},
				success: res =>
				{
					let result = JSON.parse(res);
					doCategory_change(key, size, result);
//					console.log(JSON.parse(res));
//					console.log('갯수: ' + result.medium.length);
//					console.log('키: ' + result.medium[0].key);
//					console.log('옵션: ' + result.medium[0].option);
					
					
				},
				error: e =>
				{
					console.log('요청 실패: ', e.status);
				}
			});
}

//	ajax 요청이 성공하면 option을 만들어주는 함수
function doCategory_change(key, size, json)
{
//	console.log(key)
//	console.log(json)
	if(size === 'large')
	{
		$('#category-medium').empty();
		$('#category-small').empty();
		for(i = 0; i < json.medium.length; i++)
		{
//		console.log('키: ' + result.medium[i].key);
//		console.log('옵션: ' + result.medium[i].option);
			let key = json.medium[i].key + '';
			let option = json.medium[i].option + '';
//		$('#category-medium').options[i] = new Option(result.medium[i].key.toString(), result.medium[i].option);
//		$('#category-medium').options[i] = new Option(key, option);
			let objOption = document.createElement("option");
			objOption.text=option;
			objOption.value=key;
			$('#category-medium').append(objOption);
		}		
	}
	else
	{
		$('#category-small').empty();
		for(i = 0; i < json.small.length; i++)
		{
			let key = json.small[i].key + '';
			let option = json.small[i].option + '';
			let objOption = document.createElement("option");
			objOption.text=option;
			objOption.value=key;
			$('#category-small').append(objOption);
		}
	}
	
}


//	입력한 이미지 주소로 이미지를 보여주는 함수
function imgView()
{
	let imgurl1 = $('#imgurl1').val().trim();
	let img1 = $('#img1');
	img1.attr("src", imgurl1);
	img1.show();
	
	let imgurl2 = $('#imgurl2').val().trim();
	let img2 = $('#img2');
	img2.attr("src", imgurl2);
	img2.show();
	
	let imgurl3 = $('#imgurl3').val().trim();
	let img3 = $('#img3');
	img3.attr("src", imgurl3);
	img3.show();
	
	let imgurl4 = $('#imgurl4').val().trim();
	let img4 = $('#img4');
	img4.attr("src", imgurl4);
	img4.show();
}

//	상품등록하기 버튼
function insertProduct()
{
	let category = $('#category-medium option:selected').val() + $('#category-small option:selected').val();
//	console.log(category);
	let brand = $('#brand').val().trim();
	let productName = $('#productName').val();
	let sellID = $('#sellID').val().trim();
	let price = $('#price').val().trim();
	let delivery_charge = $('#delivery_charge').val().trim();
	let delivery_company = $('#delivery_company').val().trim();
	let stock = $('#stock').val().trim();
	let imgurl1 = $('#imgurl1').val().trim();
	let imgurl2 = $('#imgurl2').val().trim();
	let imgurl3 = $('#imgurl3').val().trim();
	let imgurl4 = $('#imgurl4').val().trim();
	let detailImgurl = $('#detailImgurl').val().trim();
	
	if(category.indexOf('undefined') !== -1 || category.indexOf('-선택-') !== -1)
	{
		alert('카테고리를 골라주세요.');
		return;
	}
	
//	console.log('brand: ' + brand);
//	console.log('productName: ' + productName);
//	console.log('sellID: ' + sellID);
//	console.log('price: ' + price);
//	console.log('delivery_charge: ' + delivery_charge);
//	console.log('delivery_company: ' + delivery_company);
//	console.log('stock: ' + stock);
	
	if(	brand == null || brand == '' ||
		productName == null || productName == '' ||
		sellID == null || sellID == '' ||
		price == null || price == '' ||
		delivery_charge == null || delivery_charge == '' ||
		delivery_company == null || delivery_company == '' ||
		stock == null || stock == '' ||
		imgurl1 == null || imgurl1 == '' ||
		detailImgurl == null || detailImgurl == '')
	{
		alert('빈칸을 다 입력해주세요.');
		return;
	}
	
	if(isNaN(price) || isNaN(delivery_charge))
	{
		alert('가격은 숫자만 입력해주세요~');
		return;
	}
	if(isNaN(stock))
	{
		alert('재고수량은 숫자만 입력해주세요~');
		return;
	}
	
	
//	jQuery ajax
	$.ajax(
		{
			type: 'POST',
			url: 'insertAjax',
			data: 
			{
				category: category,
				pd_brand: brand,
				pd_name: productName,
				sellID: sellID,
				price: price,
				delivery_charge: delivery_charge,
				delivery_company: delivery_company,
				stock: stock,
				imgurl1: imgurl1,
				imgurl2: imgurl2,
				imgurl3: imgurl3,
				imgurl4: imgurl4,
				detailImgurl: detailImgurl
			},
			success: res =>
			{
				switch(res)
				{
				case "success":
						alert(productName + '상품이 등록됐습니다.');
						location.reload();
					break;
				case "duplicated":
						alert('이미 등록하신 상품입니다.');
					break;
				}
				
			},
			error: e =>
			{
				console.log('요청 실패: ', e.status);
			}
		});
	
	
}


function hoverImage(url)
{
	$("#image_bigSize").attr('src', url);

}


function insertCart(code, id)
{
	let count = $('#product_count').val()
	
	if(count < 1)
	{
		count = 1;
	}
	
	$.ajax(
			{
				type: 'POST',
				url: 'cartInsertAjax',
				data: 
				{
					code: code,
					count: count,
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







