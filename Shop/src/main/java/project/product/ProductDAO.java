package project.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import project.product.vo.CartVO;
import project.product.vo.ProductCodeVO;
import project.product.vo.ProductImageVO;
import project.product.vo.ProductVO;
import project.product.vo.ReviewVO;
import project.product.vo.SellerVO;

public interface ProductDAO 
{

//	해당 vo의 이름이 db안에 존재하는지 확인하는 용도
	ProductVO searchPDname(String name);
//	해당 숫자의 상품코드가 있는지 확인하는 용도
	ProductCodeVO checkCode(String random);
//	pdvo를 DB에 등록
	void insertPdVo(ProductVO pdvo);
//	pdcd_vo를 DB에 등록
	void insertPdCdVo(ProductCodeVO pdcd_vo);
//	seller_vo를 DB에 등록
	void insertSellerVo(SellerVO seller_vo);
//	pdimg_vo를 DB에 등록
	void insertPdImgVo(ProductImageVO pdimg_vo);
//	sellerDB에서 아이디와 상품코드를 가지고 존재하는지 검색하기 위한 용도
	SellerVO searchSellerPDCDID(Map<String, String> tempMap);

	int selectSellerCount();
//	판매자 상품목록을 얻어오는 메소드
	ArrayList<SellerVO> selectSellerListAll(HashMap<String, String> hmap);
	ArrayList<SellerVO> selectSellerListD1(HashMap<String, String> hmap);
	ArrayList<SellerVO> selectSellerListD2(HashMap<String, String> hmap);
	ArrayList<SellerVO> selectSellerListD3(HashMap<String, String> hmap);
//	판매자 상품목록을 기반으로 같은 상품코드인 ProductVO를 얻어오는 메소드
	ArrayList<ProductVO> selectProductList(ArrayList<SellerVO> sellerList);
//	상품코드에 해당하는 상품에 리뷰가 총 몇개 달렸는지 얻어오는 메소드
	int selectReviewCount(String productCode);
//	판매상품 리뷰를 한페이지 분량 얻어오는 메소드
	ArrayList<ReviewVO> selectReviewList(HashMap<String, String> hmap);
//	넘겨받은 상품코드와 판매자 이름으로 해당되는 상품이미지를 얻어온다.
	ProductImageVO selectProductImg(HashMap<String, String> hmap);
//	상품코드로 검색해 일치하는 product를 찾는다.
	ProductVO searchProduct(String productCode);
//	판매자 상품에서 카테고리의 총 개수를 구해오는 메소드 카테고리깊이1
	int selectSellerCountD1(String categoryInt);
//	판매자 상품에서 카테고리의 총 개수를 구해오는 메소드 카테고리깊이2
	int selectSellerCountD2(String categoryInt);
//	판매자 상품에서 카테고리의 총 개수를 구해오는 메소드 카테고리깊이3
	int selectSellerCountD3(String categoryInt);
//	sellerVO에서 넘어온 값으로 productVO를 얻어온다.
	ProductVO selectProductListFrmSelVO(SellerVO seller_vo);
//	넘어온 id가 가지고 있는 장바구니목록을 얻어오다.
	ArrayList<CartVO> selectCartList(String id);
	int selectSellerCountAll();
//	넘어온 id와 상품코드로 카트에 있는 상품을 지워준다.
	void removeCart(HashMap<String, String> hmap);
//	넘어온 id와 상품코드, 판매자 아이디로 일치하는 상품이 장바구니에 있는지 검사
	CartVO searchCart(HashMap<String, String> tempMap);
//	넘어온 cart_vo 값으로 일치하는 상품의 정보를 변경해주는 용도(개수)
	void updateCartCount(CartVO cart_vo);
//	새로 장바구니에 추가하는 메소드
	void insertCart(CartVO cart_vo);

}
