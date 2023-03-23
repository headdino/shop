package project.product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import project.controller.Shop.HomeController;
import project.member.MemberDAO;
import project.member.MemberVO;
import project.product.vo.CartVO;
import project.product.vo.ProductCodeVO;
import project.product.vo.ProductImageVO;
import project.product.vo.ProductList;
import project.product.vo.ProductVO;
import project.product.vo.SellerVO;

public class ProductService 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private ArrayList<String> largeJson = new ArrayList<String>();
	private String large00 = "{\"medium\": ["
			+ "{\"key\":\"0000\", \"option\":\"강아지사료\" },"
			+ "{\"key\":\"0001\", \"option\":\"강아지간식\" },"
			+ "{\"key\":\"0002\", \"option\":\"강아지용품\" },"
			+ "{\"key\":\"0003\", \"option\":\"고양이사료\" },"
			+ "{\"key\":\"0004\", \"option\":\"고양이간식\" },"
			+ "{\"key\":\"0005\", \"option\":\"고양이용품\" },"
			+ "{\"key\":\"0006\", \"option\":\"관상어용품\" }"
			+ "]}";
	private String large01 = "{\"medium\": ["
			+ "{\"key\":\"0100\", \"option\":\"과일\" },"
			+ "{\"key\":\"0101\", \"option\":\"채소\" },"
			+ "{\"key\":\"0102\", \"option\":\"축산/계란\" },"
			+ "{\"key\":\"0103\", \"option\":\"간식\" }"
			+ "]}";
	private String large02 = "{\"medium\": ["
			+ "{\"key\":\"0200\", \"option\":\"화장지/물티슈\" },"
			+ "{\"key\":\"0201\", \"option\":\"욕실용품\" }"
			+ "]}";
	
//	private ArrayList<String> mediumJson = new ArrayList<String>();
	private Map<String, String> mediumJson = new HashMap<String, String>();
	private String medium0000 = "{\"small\": ["
			+ "{\"key\":\"000\", \"option\":\"건식\" },"
			+ "{\"key\":\"001\", \"option\":\"습식\" },"
			+ "{\"key\":\"002\", \"option\":\"분유\" }"
			+ "]}";
	
	private String medium0001 = "{\"small\": ["
			+ "{\"key\":\"010\", \"option\":\"캔\" },"
			+ "{\"key\":\"011\", \"option\":\"덴탈껌\" },"
			+ "{\"key\":\"012\", \"option\":\"건조간식/육포\" },"
			+ "{\"key\":\"013\", \"option\":\"음료\" }"
			+ "]}";
	
	private String medium0002 = "{\"small\": ["
			+ "{\"key\":\"020\", \"option\":\"하우스/울타리\" },"
			+ "{\"key\":\"021\", \"option\":\"급식기/급수기\" },"
			+ "{\"key\":\"022\", \"option\":\"의류/패션\" },"
			+ "{\"key\":\"023\", \"option\":\"배변용품\" },"
			+ "{\"key\":\"024\", \"option\":\"장난감/훈련용품\" }"
			+ "]}";
	
	private String medium0003 = "{\"small\": ["
			+ "{\"key\":\"030\", \"option\":\"건식\" },"
			+ "{\"key\":\"031\", \"option\":\"습식\" },"
			+ "{\"key\":\"032\", \"option\":\"분유\" }"
			+ "]}";
	
	private String medium0004 = "{\"small\": ["
			+ "{\"key\":\"040\", \"option\":\"캔\" },"
			+ "{\"key\":\"041\", \"option\":\"파우치\" },"
			+ "{\"key\":\"042\", \"option\":\"동결/건조간식\" },"
			+ "{\"key\":\"043\", \"option\":\"음료\" }"
			+ "]}";
	
	private String medium0005 = "{\"small\": ["
			+ "{\"key\":\"050\", \"option\":\"캣타워/스크래쳐\" },"
			+ "{\"key\":\"051\", \"option\":\"하우스/방석\" },"
			+ "{\"key\":\"052\", \"option\":\"급식기/급수기\" },"
			+ "{\"key\":\"053\", \"option\":\"모래/화장실\" },"
			+ "{\"key\":\"054\", \"option\":\"장난감\" }"
			+ "]}";
	
	private String medium0006 = "{\"small\": ["
			+ "{\"key\":\"060\", \"option\":\"어항\" }"
			+ "]}";
	
	private String medium0100 = "{\"small\": ["
			+ "{\"key\":\"000\", \"option\":\"사과/배\" },"
			+ "{\"key\":\"001\", \"option\":\"귤/한라봉/감귤류\" },"
			+ "{\"key\":\"002\", \"option\":\"수박/메론/참외\" }"
			+ "]}";
	
	private String medium0101 = "{\"small\": ["
			+ "{\"key\":\"010\", \"option\":\"두부/콩나물\" },"
			+ "{\"key\":\"011\", \"option\":\"오이/고추/열매채소\" },"
			+ "{\"key\":\"012\", \"option\":\"건나물/건채소\" }"
			+ "]}";
	
	private String medium0102 = "{\"small\": ["
			+ "{\"key\":\"020\", \"option\":\"소고기\" },"
			+ "{\"key\":\"021\", \"option\":\"돼지고기\" },"
			+ "{\"key\":\"022\", \"option\":\"닭/오리고기\" },"
			+ "{\"key\":\"023\", \"option\":\"양/말고기\" },"
			+ "{\"key\":\"024\", \"option\":\"계란/알류/가공란\" }"
			+ "]}";
	
	private String medium0103 = "{\"small\": ["
			+ "{\"key\":\"030\", \"option\":\"과자\" },"
			+ "{\"key\":\"031\", \"option\":\"쿠키/파이\" },"
			+ "{\"key\":\"032\", \"option\":\"초콜릿\" },"
			+ "{\"key\":\"033\", \"option\":\"젤리\" },"
			+ "{\"key\":\"034\", \"option\":\"전통과자/떡\" }"
			+ "]}";
	
	private String medium0200 = "{\"small\": ["
			+ "{\"key\":\"000\", \"option\":\"화장지\" },"
			+ "{\"key\":\"001\", \"option\":\"갑티슈/여행용티슈\" },"
			+ "{\"key\":\"002\", \"option\":\"물티슈\" },"
			+ "{\"key\":\"003\", \"option\":\"키친타올\" }"
			+ "]}";
	
	private String medium0201 = "{\"small\": ["
			+ "{\"key\":\"010\", \"option\":\"샤워기\" },"
			+ "{\"key\":\"011\", \"option\":\"수건/타월\" },"
			+ "{\"key\":\"012\", \"option\":\"욕실화\" },"
			+ "{\"key\":\"013\", \"option\":\"욕조\" }"
			+ "]}";

	public ProductService() 
	{
		
//		생성자에서 json을 arrayList에 담아준다.
		largeJson.add(large00);
		largeJson.add(large01);
		largeJson.add(large02);
//		mediumJson.add(medium0000);
//		mediumJson.add(medium0001);
//		mediumJson.add(medium0002);
//		mediumJson.add(medium0003);
//		mediumJson.add(medium0004);
//		mediumJson.add(medium0005);
//		mediumJson.add(medium0006);
//		mediumJson.add(medium0100);
//		mediumJson.add(medium0101);
//		mediumJson.add(medium0102);
//		mediumJson.add(medium0103);
//		mediumJson.add(medium0200);
//		mediumJson.add(medium0201);
		mediumJson.put("0000", medium0000);
		mediumJson.put("0001", medium0001);
		mediumJson.put("0002", medium0002);
		mediumJson.put("0003", medium0003);
		mediumJson.put("0004", medium0004);
		mediumJson.put("0005", medium0005);
		mediumJson.put("0006", medium0006);
		mediumJson.put("0100", medium0100);
		mediumJson.put("0101", medium0101);
		mediumJson.put("0102", medium0102);
		mediumJson.put("0103", medium0103);
		mediumJson.put("0200", medium0200);
		mediumJson.put("0201", medium0201);
	}

	
//	넘겨받은 종류에 따라 카테고리 옵션json을 넘겨준다.
	public String categoryChange(ProductDAO mapper, HttpServletRequest request) 
	{
		String kind = request.getParameter("cate_kind");
		String size = request.getParameter("cate_size");
		
		String result_json = large00;
		if(size.equals("large"))
		{
			for(int i = 0; i < largeJson.size(); i++)
			{
				if(Integer.parseInt(kind) == i)
				{
					result_json = largeJson.get(i);
					break;
				}
			}
			
		}
		else
		{
			for(String temp : mediumJson.keySet())
			{
				if(kind.equals(temp))
				{
//					logger.info(mediumJson.toString());
					result_json = mediumJson.get(temp);
					break;
				}
			}
			
		}
		
		
		return result_json;
	}


//	DB에 상품을 등록하는 함수
	public String insertProduct(HttpServletRequest request, ProductDAO mapper) 
	{
		
//		DB에 해당 이름과 같은 상품이 있는가 검사한다.
//		없다면 신규 등록
//		있다면 판매자 관련해서정보만 등록해준다.
		
//		상품 DB에 해당 이름으로 된 상품이 있는지 확인한다.
		ProductVO pdvoTemp = mapper.searchPDname(request.getParameter("pd_name"));
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		logger.info("이름검색 끝");
//		null이 아니라면 존재한다는 뜻 판매자 관련 정보만 등록해주면 된다.
		if(pdvoTemp != null )
		{
//			logger.info("존재하는 상품입니다.");
//			판매자 관련 정보만 등록하기 전에
//			해당 판매자가 같은 상품을 등록한적 있는지 검사한다.
			Map<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("pdCode", pdvoTemp.getPd_code());
			tempMap.put("id", request.getParameter("sellID"));
			SellerVO sellerTemp = mapper.searchSellerPDCDID(tempMap);
			if(sellerTemp != null)
			{
//				null이 아니면 존재한다는 뜻 등록은 멈춘다.
				return "duplicated";
			}
			
			
			SellerVO seller_vo = ctx.getBean("sellerVO", SellerVO.class);
			ProductImageVO pdimg_vo = ctx.getBean("productImgVO", ProductImageVO.class);
			
			seller_vo.init(pdvoTemp.getPd_code(), request.getParameter("sellID"), Integer.parseInt(request.getParameter("price")),
					Integer.parseInt(request.getParameter("delivery_charge")), request.getParameter("delivery_company"),
					Integer.parseInt(request.getParameter("stock")), 0, 0);
			pdimg_vo.init(pdvoTemp.getPd_code(), request.getParameter("sellID"), request.getParameter("imgurl1"),
					request.getParameter("imgurl2"), request.getParameter("imgurl3"), 
					request.getParameter("imgurl4"), request.getParameter("detailImgurl"));
			
			
			mapper.insertSellerVo(seller_vo);
			mapper.insertPdImgVo(pdimg_vo);
			return "success";
			
		}
//		null이라면 신규 등록하는 상품이다.
		else
		{
//			logger.info("신규 등록 상품입니다.");
//			신규 등록은 하기 전에 카테고리 기반으로 랜덤 상품코드를 만들어준다.
			String pd_code = randomCode(mapper, request.getParameter("category"));
//			상품코드에 숫자를 의미하는 카테고리 이름으로 변환해준다.
			String codeToStr = categoryToString(request.getParameter("category"));
			
			
			ProductVO pdvo = ctx.getBean("productVO", ProductVO.class);
			ProductCodeVO pdcd_vo = ctx.getBean("productCodeVO", ProductCodeVO.class);
			SellerVO seller_vo = ctx.getBean("sellerVO", SellerVO.class);
			ProductImageVO pdimg_vo = ctx.getBean("productImgVO", ProductImageVO.class);
			
			pdvo.init(pd_code, request.getParameter("pd_name"), 'n', request.getParameter("pd_brand"), 
					0, request.getParameter("imgurl1"));
			pdcd_vo.init(pd_code, codeToStr);
			seller_vo.init(pd_code, request.getParameter("sellID"), Integer.parseInt(request.getParameter("price")),
					Integer.parseInt(request.getParameter("delivery_charge")), request.getParameter("delivery_company"),
					Integer.parseInt(request.getParameter("stock")), 0, 0);
			pdimg_vo.init(pd_code, request.getParameter("sellID"), request.getParameter("imgurl1"),
					request.getParameter("imgurl2"), request.getParameter("imgurl3"), 
					request.getParameter("imgurl4"), request.getParameter("detailImgurl"));
			
			
			mapper.insertPdVo(pdvo);
			mapper.insertPdCdVo(pdcd_vo);
			mapper.insertSellerVo(seller_vo);
			mapper.insertPdImgVo(pdimg_vo);
			return "success";
		}
		
	}
	
	
	
	
	
	
	
	
	
//	카테고리 숫자를 기반으로 그 숫자가 뜻하는 글자로 변환해주는 용도
	private String categoryToString(String cate)
	{
		String large = cate.substring(0, 2);
		String medium = cate.substring(0, 4);
		String small = cate.substring(4);
		
		logger.info(large);
		logger.info(medium);
		logger.info(small);
		
		if(large.equals("00"))
		{
			large = "반려동물 용품";
		}
		else if(large.equals("01"))
		{
			large = "식품";
		}
		else if(large.equals("02"))
		{
			large = "생활 용품";
		}
		
		if(medium.equals("0000"))
		{
			medium = "강아지사료";
		}
		else if(medium.equals("0001"))
		{
			medium = "강아지간식";
		}
		else if(medium.equals("0002"))
		{
			medium = "강아지용품";
		}
		else if(medium.equals("0003"))
		{
			medium = "고양이사료";
		}
		else if(medium.equals("0004"))
		{
			medium = "고양이간식";
		}
		else if(medium.equals("0005"))
		{
			medium = "고양이용품";
		}
		else if(medium.equals("0006"))
		{
			medium = "관상어용품";
		}
		else if(medium.equals("0100"))
		{
			medium = "과일";
		}
		else if(medium.equals("0101"))
		{
			medium = "채소";
		}
		else if(medium.equals("0102"))
		{
			medium = "축산/계란";
		}
		else if(medium.equals("0103"))
		{
			medium = "간식";
		}
		else if(medium.equals("0200"))
		{
			medium = "화장지/물티슈";
		}
		else if(medium.equals("0201"))
		{
			medium = "욕실용품";
		}
		

		if(large.equals("반려동물 용품"))
		{
			
			if(small.equals("000"))
			{
				small = "건식";
			}
			else if(small.equals("001"))
			{
				small = "습식";
			}
			else if(small.equals("002"))
			{
				small = "분유";
			}
			else if(small.equals("010"))
			{
				small = "캔";
			}
			else if(small.equals("011"))
			{
				small = "덴탈껌";
			}
			else if(small.equals("012"))
			{
				small = "건조간식/육포";
			}
			else if(small.equals("013"))
			{
				small = "음료";
			}
			else if(small.equals("020"))
			{
				small = "하우스/울타리";
			}
			else if(small.equals("021"))
			{
				small = "급식기/급수기";
			}
			else if(small.equals("022"))
			{
				small = "의류/패션";
			}
			else if(small.equals("023"))
			{
				small = "배변용품";
			}
			else if(small.equals("024"))
			{
				small = "장난감/훈련용품";
			}
			else if(small.equals("030"))
			{
				small = "건식";
			}
			else if(small.equals("031"))
			{
				small = "습식";
			}
			else if(small.equals("032"))
			{
				small = "분유";
			}
			else if(small.equals("040"))
			{
				small = "캔";
			}
			else if(small.equals("041"))
			{
				small = "파우치";
			}
			else if(small.equals("042"))
			{
				small = "동결/건조간식";
			}
			else if(small.equals("043"))
			{
				small = "음료";
			}
			else if(small.equals("050"))
			{
				small = "캣타워/스크래쳐";
			}
			else if(small.equals("051"))
			{
				small = "하우스/방석";
			}
			else if(small.equals("052"))
			{
				small = "급식기/급수기";
			}
			else if(small.equals("053"))
			{
				small = "모래/화장실";
			}
			else if(small.equals("054"))
			{
				small = "장난감";
			}
			else if(small.equals("060"))
			{
				small = "어항";
			}
		}
		else if(large.equals("식품"))
		{
			
			if(small.equals("000"))
			{
				small = "사과/배";
			}
			else if(small.equals("001"))
			{
				small = "귤/한라봉/감귤류";
			}
			else if(small.equals("002"))
			{
				small = "수박/메론/참외";
			}
			else if(small.equals("010"))
			{
				small = "두부/콩나물";
			}
			else if(small.equals("011"))
			{
				small = "오이/고추/열매채소";
			}
			else if(small.equals("012"))
			{
				small = "건나물/건채소";
			}
			else if(small.equals("020"))
			{
				small = "소고기";
			}
			else if(small.equals("021"))
			{
				small = "돼지고기";
			}
			else if(small.equals("022"))
			{
				small = "닭/오리고기";
			}
			else if(small.equals("023"))
			{
				small = "양/말고기";
			}
			else if(small.equals("024"))
			{
				small = "계란/알류/가공란";
			}
			else if(small.equals("030"))
			{
				small = "과자";
			}
			else if(small.equals("031"))
			{
				small = "쿠키/파이";
			}
			else if(small.equals("032"))
			{
				small = "초콜릿";
			}
			else if(small.equals("033"))
			{
				small = "젤리";
			}
			else if(small.equals("034"))
			{
				small = "전통과자/떡";
			}
		}
		else if(large.equals("생활 용품"))
		{
			
			if(small.equals("000"))
			{
				small = "화장지";
			}
			else if(small.equals("001"))
			{
				small = "갑티슈/여행용티슈";
			}
			else if(small.equals("002"))
			{
				small = "물티슈";
			}
			else if(small.equals("003"))
			{
				small = "키친타올";
			}
			else if(small.equals("010"))
			{
				small = "샤워기";
			}
			else if(small.equals("011"))
			{
				small = "수건/타월";
			}
			else if(small.equals("012"))
			{
				small = "욕실화";
			}
			else if(small.equals("013"))
			{
				small = "욕조";
			}
		}
		
		String sumCate = large + ">" + medium + ">" + small;
		logger.info("카테고리: " + sumCate);
		
		return sumCate;
	}
	
//	카테고리 이름을 기반으로 그 이름이 뜻하는 숫자로 변환해주는 용도
	private String categoryToInt(String cate)
	{
		
		if(cate.equals("반려동물 용품"))
		{
			cate = "00";
		}
		else if(cate.equals("식품"))
		{
			cate = "01";
		}
		else if(cate.equals("생활 용품"))
		{
			cate = "02";
		}
		else if(cate.equals("반려동물 용품>강아지사료"))
		{
			cate = "0000";
		}
		else if(cate.equals("반려동물 용품>강아지간식"))
		{
			cate = "0001";
		}
		else if(cate.equals("반려동물 용품>강아지용품"))
		{
			cate = "0002";
		}
		else if(cate.equals("반려동물 용품>고양이사료"))
		{
			cate = "0003";
		}
		else if(cate.equals("반려동물 용품>고양이간식"))
		{
			cate = "0004";
		}
		else if(cate.equals("반려동물 용품>고양이용품"))
		{
			cate = "0005";
		}
		else if(cate.equals("반려동물 용품>관상어용품"))
		{
			cate = "0006";
		}
		else if(cate.equals("식품>과일"))
		{
			cate = "0100";
		}
		else if(cate.equals("식품>채소"))
		{
			cate = "0101";
		}
		else if(cate.equals("식품>축산/계란"))
		{
			cate = "0102";
		}
		else if(cate.equals("식품>간식"))
		{
			cate = "0103";
		}
		else if(cate.equals("생활 용품>화장지/물티슈"))
		{
			cate = "0200";
		}
		else if(cate.equals("생활 용품>욕실용품"))
		{
			cate = "0201";
		}
		else if(cate.equals("반려동물 용품>강아지사료>건식"))
		{
			cate = "0000000";
		}
		else if(cate.equals("반려동물 용품>강아지사료>습식"))
		{
			cate = "0000001";
		}
		else if(cate.equals("반려동물 용품>강아지사료>분유"))
		{
			cate = "0000002";
		}
		else if(cate.equals("반려동물 용품>강아지간식>캔"))
		{
			cate = "0001010";
		}
		else if(cate.equals("반려동물 용품>강아지간식>덴탈껌"))
		{
			cate = "0001011";
		}
		else if(cate.equals("반려동물 용품>강아지간식>건조간식/육포"))
		{
			cate = "0001012";
		}
		else if(cate.equals("반려동물 용품>강아지간식>음료"))
		{
			cate = "0001013";
		}
		else if(cate.equals("반려동물 용품>강아지용품>하우스/울타리"))
		{
			cate = "0002020";
		}
		else if(cate.equals("반려동물 용품>강아지용품>급식기/급수기"))
		{
			cate = "0002021";
		}
		else if(cate.equals("반려동물 용품>강아지용품>의류/패션"))
		{
			cate = "0002022";
		}
		else if(cate.equals("반려동물 용품>강아지용품>배변용품"))
		{
			cate = "0002023";
		}
		else if(cate.equals("반려동물 용품>강아지용품>장난감/훈련용품"))
		{
			cate = "0002024";
		}
		else if(cate.equals("반려동물 용품>고양이사료>건식"))
		{
			cate = "0003030";
		}
		else if(cate.equals("반려동물 용품>고양이사료>습식"))
		{
			cate = "0003031";
		}
		else if(cate.equals("반려동물 용품>고양이사료>분유"))
		{
			cate = "0003032";
		}
		else if(cate.equals("반려동물 용품>고양이간식>캔"))
		{
			cate = "0004040";
		}
		else if(cate.equals("반려동물 용품>고양이간식>파우치"))
		{
			cate = "0004041";
		}
		else if(cate.equals("반려동물 용품>고양이간식>동결/건조간식"))
		{
			cate = "0004042";
		}
		else if(cate.equals("반려동물 용품>고양이간식>음료"))
		{
			cate = "0004043";
		}
		else if(cate.equals("반려동물 용품>고양이용품>캣타워/스크래쳐"))
		{
			cate = "0005050";
		}
		else if(cate.equals("반려동물 용품>고양이용품>하우스/방석"))
		{
			cate = "0005051";
		}
		else if(cate.equals("반려동물 용품>고양이용품>급식기/급수기"))
		{
			cate = "0005052";
		}
		else if(cate.equals("반려동물 용품>고양이용품>모래/화장실"))
		{
			cate = "0005053";
		}
		else if(cate.equals("반려동물 용품>고양이용품>장난감"))
		{
			cate = "0005054";
		}
		else if(cate.equals("반려동물 용품>관상어용품>어항"))
		{
			cate = "0006060";
		}
		else if(cate.equals("식품>과일>사과/배"))
		{
			cate = "0100000";
		}
		else if(cate.equals("식품>과일>귤/한라봉/감귤류"))
		{
			cate = "0100001";
		}
		else if(cate.equals("식품>과일>수박/메론/참외"))
		{
			cate = "0100002";
		}
		else if(cate.equals("식품>채소>두부/콩나물"))
		{
			cate = "0101010";
		}
		else if(cate.equals("식품>채소>오이/고추/열매채소"))
		{
			cate = "0101011";
		}
		else if(cate.equals("식품>채소>건나물/건채소"))
		{
			cate = "0101012";
		}
		else if(cate.equals("식품>축산/계란>소고기"))
		{
			cate = "0102020";
		}
		else if(cate.equals("식품>축산/계란>돼지고기"))
		{
			cate = "0102021";
		}
		else if(cate.equals("식품>축산/계란>닭/오리고기"))
		{
			cate = "0102022";
		}
		else if(cate.equals("식품>축산/계란>양/말고기"))
		{
			cate = "0102023";
		}
		else if(cate.equals("식품>축산/계란>계란/알류/가공란"))
		{
			cate = "0102024";
		}
		else if(cate.equals("식품>간식>과자"))
		{
			cate = "0103030";
		}
		else if(cate.equals("식품>간식>쿠키/파이"))
		{
			cate = "0103031";
		}
		else if(cate.equals("식품>간식>초콜릿"))
		{
			cate = "0103032";
		}
		else if(cate.equals("식품>간식>젤리"))
		{
			cate = "0103033";
		}
		else if(cate.equals("식품>간식>전통과자/떡"))
		{
			cate = "0103034";
		}
		else if(cate.equals("생활 용품>화장지/물티슈>화장지"))
		{
			cate = "0200000";
		}
		else if(cate.equals("생활 용품>화장지/물티슈>갑티슈/여행용티슈"))
		{
			cate = "0200001";
		}
		else if(cate.equals("생활 용품>화장지/물티슈>물티슈"))
		{
			cate = "0200002";
		}
		else if(cate.equals("생활 용품>화장지/물티슈>키친타올"))
		{
			cate = "0200003";
		}
		else if(cate.equals("생활 용품>욕실용품>샤워기"))
		{
			cate = "0201010";
		}
		else if(cate.equals("생활 용품>욕실용품>수건/타월"))
		{
			cate = "0201011";
		}
		else if(cate.equals("생활 용품>욕실용품>욕실화"))
		{
			cate = "0201012";
		}
		else if(cate.equals("생활 용품>욕실용품>욕조"))
		{
			cate = "0201013";
		}
		
		
		return cate;
	}
	
	
	
	private String randomCode(ProductDAO mapper, String cate)
	{
		String random = "";
		Long j = 1L;
		while(true)
		{	
			logger.info("랜덤함수 생성" + j + "회차");
			// 9자리 난수를 생성한다.
			Random r = new Random();
			for(int i = 0; i < 9; i++)
			{
				int randomNum = r.nextInt(9);
				random += Integer.toString(randomNum);
			}
			random = cate + random;
			
			ProductCodeVO codeVO = mapper.checkCode(random);
			
			if(codeVO == null )
			{
				break;
			}
			j++;
			
		}
		logger.info("랜덤코드 " + j + "회차 반환결과: " + random);
		
		return random;
	}


	public Model listView(HttpServletRequest request, Model model, ProductDAO mapper, MemberDAO mbMapper) 
	{
		String category = "전체";
//		카테고리속성을 받아온다.
		String reCategory = (String) request.getParameter("category");
		
		//	받아온 카테고리 속성이 존재한다면 그걸로 카테고리를 바꿔준다.
		if(reCategory != null) category = reCategory;
		
//		선택된 카테고리의 깊이 단계를 검사한다.
		String[] depth = category.split(">");
		int length = depth.length;
		
		String categoryInt = categoryToInt(category);
		logger.info(categoryInt);
		
//		logger.info("카테고리 깊이" + length);
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		} catch (Exception e) {
			
		}
					
		int pageSize = 6;
		
		int totalCount = 0;
		
		switch (length) 
		{
			case 1:
				if(category.equals("전체"))
				{
					totalCount = mapper.selectSellerCount();
				}
				else
				{
					totalCount = mapper.selectSellerCountD1(categoryInt);					
				}
				break;
			case 2:
				totalCount = mapper.selectSellerCountD2(categoryInt);
				break;
			case 3:
				totalCount = mapper.selectSellerCountD3(categoryInt);
				break;
		}
		
//		1페이지 분량의 글과 페이징 작업에 사용할 변수를 초기화시킨다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ProductList productList = ctx.getBean("productList", ProductList.class);
		productList.initMvcboardList(pageSize, totalCount, currentPage);
		
//		1페이지 분량의 판매자상품 목록을 얻어온다.
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("startNo", Integer.toString(productList.getStartNo()));
		hmap.put("endNo", Integer.toString(productList.getEndNo()));
		hmap.put("category", categoryInt);
		
		switch (length) 
		{
			case 1:
				if(category.equals("전체"))
				{
					productList.setSellerList(mapper.selectSellerListAll(hmap));
				}
				else
				{
					productList.setSellerList(mapper.selectSellerListD1(hmap));
				}
				break;
			case 2:
				productList.setSellerList(mapper.selectSellerListD2(hmap));
				break;
			case 3:
				productList.setSellerList(mapper.selectSellerListD3(hmap));
				break;
		}
		logger.info(productList.getSellerList().toString());
		
		productList.getPdList().clear();
		
		if(productList.getSellerList().size() != 0)
		{
			for(SellerVO slstVO : productList.getSellerList())
			{
				productList.getPdList().add(mapper.selectProductListFrmSelVO(slstVO));
			}
//			productList.setList(mapper.selectProductList(productList.getSellerList()));
		}
		
		logger.info(productList.getPdList().toString());
		ArrayList<String> sellerNameList = new ArrayList<String>();
//		판매상품들이 가진 판매자 id를 기반으로 판매자 닉내임들을 찾아 담아준다.
		for(int i = 0; i < productList.getSellerList().size(); i++)
		{
			MemberVO mbVO = mbMapper.mbSearch(productList.getSellerList().get(i).getId());
			sellerNameList.add(mbVO.getNickname());
		}
		
		// 상품의 목록을 model 영역에 저장해서 메인 글을 화면에 표시하는 페이지(listView.jsp)로 넘겨준다.
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("productList", productList);
		model.addAttribute("sellerNameList", sellerNameList);
		model.addAttribute("categoryStr", category);
		
		return model;
	}


	public Model singleView(HttpServletRequest request, Model model, ProductDAO mapper, MemberDAO mbMapper) 
	{
		String productCode = request.getParameter("code");
		String sellerId = request.getParameter("sellerId");
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	
		} catch (Exception e) {
			
		}
		
//		seller name
		MemberVO mbVO = mbMapper.mbSearch(sellerId);
		
		
//		ReviewVO ReviewList
		int pageSize = 6;
		
//		해당 상품에 달린 총 리뷰갯수를 구한다.
		int totalCount = mapper.selectReviewCount(productCode);
		
//		1페이지 분량의 리뷰와 페이징 작업에 사용할 변수를 초기화시킨다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ProductList productList = ctx.getBean("productList", ProductList.class);
		productList.initMvcboardList(pageSize, totalCount, currentPage);
		
//		1페이지 분량의 리뷰 목록을 얻어온다.
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("startNo", Integer.toString(productList.getStartNo()));
		hmap.put("endNo", Integer.toString(productList.getEndNo()));
		hmap.put("pdCode", productCode);
		hmap.put("id", sellerId);
		
		productList.setReviewList(mapper.selectReviewList(hmap));
		
//		reviewList가 존재하면
		ArrayList<String> reviewerNameList = new ArrayList<String>();
		if(productList.getReviewList().size() != 0)
		{
//			해당 리뷰의 아이디를 기준으로 그 아이디의 별명을 찾아서 넘겨준다.
			for(int i = 0; i < productList.getReviewList().size(); i++)
			{
				MemberVO reMbVO = mbMapper.mbSearch(productList.getReviewList().get(i).getId());
				reviewerNameList.add(reMbVO.getNickname());
			}
			
		}
		
//		productImageVO
		ProductImageVO pdimgVO = mapper.selectProductImg(hmap);
		
//		ProductVO
		ProductVO pdVO = mapper.searchProduct(productCode);
		
//		SellerVO
		SellerVO sellerVO = mapper.searchSellerPDCDID(hmap);
		
		logger.info(pdimgVO.toString());
		
		model.addAttribute("reviewerNameList", reviewerNameList);
		model.addAttribute("sellerVO", sellerVO);
		model.addAttribute("pdVO", pdVO);
		model.addAttribute("pdImgVO", pdimgVO);
		model.addAttribute("reviewList", productList.getReviewList());
		model.addAttribute("sellerName", mbVO.getNickname());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("categoryStr", request.getParameter("categoryStr"));
		
		return model;
	}

//	쇼핑카트에 담긴 물건들을 가져온다.
	public Model cartView(HttpServletRequest request, Model model, ProductDAO mapper, MemberDAO mbMapper) 
	{
		MemberVO mbVo = (MemberVO) request.getSession().getAttribute("loginVO");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ProductList productList = ctx.getBean("productList", ProductList.class);
		
		productList.setCartList(mapper.selectCartList(mbVo.getId()));
		
//		장바구니에 담긴 상품이 존재하면
		if(productList.getCartList() != null)
		{
			ArrayList<ProductVO> tempList1 = new ArrayList<ProductVO>();
			ArrayList<SellerVO> tempList2 = new ArrayList<SellerVO>();
			Map<String, String> tempMap = new HashMap<String, String>();
			for(int i = 0; i < productList.getCartList().size(); i++)
			{
				tempList1.add(mapper.searchProduct(productList.getCartList().get(i).getPd_code()));
				tempMap.put("pdCode", productList.getCartList().get(i).getPd_code());
				tempMap.put("id", productList.getCartList().get(i).getSeller_id());
				tempList2.add(mapper.searchSellerPDCDID(tempMap));
			}
			productList.setList(tempList1);
			productList.setSellerList(tempList2);
			
		}
		
//		logger.info(productList.getCartList().toString());
		
		model.addAttribute("cartList", productList.getCartList());
		model.addAttribute("productList", productList.getPdList());
		model.addAttribute("sellerList", productList.getSellerList());
		
		return model;
	}


	public void removeCart(HttpServletRequest request, ProductDAO mapper) 
	{
		String productCode = request.getParameter("code");
		String sellerID = request.getParameter("sellerID");
		MemberVO mbVo = (MemberVO) request.getSession().getAttribute("loginVO");
		HashMap<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("pdCode", productCode);
		tempMap.put("id", mbVo.getId());
		tempMap.put("sellerID", sellerID);
		logger.info("pdCode: " + tempMap.get("pdCode") + "id: " + tempMap.get("id"));
		
		mapper.removeCart(tempMap);
		
		logger.info("삭제 완료");
		
	}


	public void insertCart(HttpServletRequest request, ProductDAO mapper) 
	{
		String productCode = request.getParameter("code");
		String sellerID = request.getParameter("sellerID");
		int count = Integer.parseInt(request.getParameter("count"));
		MemberVO mbVo = (MemberVO) request.getSession().getAttribute("loginVO");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		HashMap<String, String> tempMap = new HashMap<String, String>();
		tempMap.put("pdCode", productCode);
		tempMap.put("id", mbVo.getId());
		tempMap.put("sellerID", sellerID);
		
//		해당 고객 장바구니에 상품이 이미 존재하는지 확인한다.
		CartVO cart_vo = mapper.searchCart(tempMap);
//		이미 존재한다면
		if(cart_vo != null)
		{
//			넘어온 count 값을 더 해준뒤
			cart_vo.setCount(count + cart_vo.getCount());
//			갯수를 수정해준다.
			mapper.updateCartCount(cart_vo);
		}
		else
		{
			cart_vo = ctx.getBean("cartVO", CartVO.class);
//			장바구니에 없다면 장바구니에 추가해준다.
			cart_vo.init(productCode, mbVo.getId(), sellerID, count);
			mapper.insertCart(cart_vo);
		}
		
		
	}


	public void updateCart(HttpServletRequest request, ProductDAO mapper) 
	{
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		String productCode = request.getParameter("code");
		String sellerID = request.getParameter("sellerID");
		int count = Integer.parseInt(request.getParameter("count"));
		MemberVO mbVo = (MemberVO) request.getSession().getAttribute("loginVO");
		
		CartVO cart_vo = ctx.getBean("cartVO", CartVO.class);
		cart_vo.init(productCode, mbVo.getId(), sellerID, count);
		mapper.updateCartCount(cart_vo);
		
	}
	

}
