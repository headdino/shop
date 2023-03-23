package project.controller.Shop;



import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import project.member.MemberDAO;
import project.product.ProductDAO;
import project.product.ProductService;


@Controller
public class ShopController 
{
	
	@Autowired
	public SqlSession sqlSession;

	public ProductService pdService = new ProductService();
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@RequestMapping("/category/list")
	public String listView(HttpServletRequest request, Model model)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		MemberDAO mbMapper = sqlSession.getMapper(MemberDAO.class);
		model = pdService.listView(request, model, mapper, mbMapper);
		
		
		return "category/listView";
	}
	
	@RequestMapping("/category/list/products")
	public String singleView(HttpServletRequest request, Model model)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		MemberDAO mbMapper = sqlSession.getMapper(MemberDAO.class);
		model = pdService.singleView(request, model, mapper, mbMapper);
		
		return "category/singleView";
	}
	
	
	@RequestMapping("/seller/insert")
	public String insertProduct()
	{
		return "admin/Sell/insertProduct";
	}
	

//	카테고리가 선택되면 ajax요청으로 하위 카테고리 옵션을 그려줌
	@RequestMapping(value="/seller/category", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String categoryChanger(HttpServletRequest request)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
//		logger.info("product Controller");
		return pdService.categoryChange(mapper, request);
			
	}
	
//	상품 등록을 누르면 ajax요청으로 DB에 저장을 해주기 위해 작업
	@RequestMapping(value="/seller/insertAjax", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String insertProduct(HttpServletRequest request)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		
		
		
		return pdService.insertProduct(request, mapper);
	}
	
	@RequestMapping("/mypage/cartView")
	public String shoppingCart(HttpServletRequest request, Model model)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		MemberDAO mbMapper = sqlSession.getMapper(MemberDAO.class);
		model = pdService.cartView(request, model, mapper, mbMapper);
		
		return "admin/shoppingCart";
	}
	
//	장바구니에서 ajax요청을 받아 장바구니를 하나 비워주는 용도
	@RequestMapping(value="/mypage/cartRemoveAjax", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String removeCart(HttpServletRequest request)
	{
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
//		logger.info("removeCart Ajax");
		
		
		pdService.removeCart(request, mapper);
		
		return "";
	}

	@RequestMapping(value="/category/list/cartInsertAjax", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public void insertCart(HttpServletRequest request)
	{
		
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		
		pdService.insertCart(request, mapper);
	}
	
//	장바구니에서 수량변경요청을 처리하는 컨트롤러
	@RequestMapping(value="/mypage/cartUpdateAjax", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public void updateCart(HttpServletRequest request)
	{
		
		ProductDAO mapper = sqlSession.getMapper(ProductDAO.class);
		
		pdService.updateCart(request, mapper);
	}
	
}

