package project.member;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import project.controller.Shop.HomeController;

public class MemberService 
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public ArrayList<String> findList;
	private ArrayList<MemberAddressVO> addrList;
	public ArrayList<MemberAddressVO> getAddrList() { return addrList; }
	public MemberService() {}

	public String idChk(MemberDAO mapper, HttpServletRequest request) 
	{
//		넘겨받은 아이디로 dao에 정보를 넘겨줘서 db에 정보가 있는지 확인
		MemberVO vo = mapper.mbSearch(request.getParameter("userID"));
		
		String result;
		//	vo가 null이 아니란건 넘겨받은 userID가 DB안에 있었다는 뜻
		//	중복된 아이디가 존재한다는 뜻이다.
		if(vo != null )
		{
			result = "0";
		}
		else
		{
			result = "1";
		}
		
//		결과를 넘겨줌
		return result;
	}

	public String regiChk(MemberDAO mapper, HttpServletRequest request) 
	{
//		logger.info("userID" + request.getParameter("userID"));
		
		String result = idChk(mapper, request);
		
//		해당 아이디가 존재하는 경우 함수 종료
		if(result == "0")
		{
			return result;
		}
		
//		빈 bean을 만든다음
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		MemberVO vo = ctx.getBean("memberVO", MemberVO.class);
//		값들을 꽂은 memberVO를 만들어서
		vo.init(request.getParameter("userID"), request.getParameter("userPSS"), 
				request.getParameter("userID"), request.getParameter("userName"),
				request.getParameter("userEmail"));
//		DB로 넘겨서 추가해주라고 한다.
		mapper.mbInsert(vo);
//		회원가입에 성공했으니 해당 result를 넘겨준다.
		return result;

		
	}

	public String login(MemberDAO mapper, HttpServletRequest request) 
	{
		String result = idChk(mapper, request);
		
//		해당 아이디가 존재하지 않는 경우 함수 종료
		if(result == "1")
		{
			return result;
		}
//		입력받은 id로 DB에서 VO를 만들고
		MemberVO vo = mapper.mbSearch(request.getParameter("userID"));
//		입력받은 비밀번호와 DB에서 가져온 비밀번호가 일치하면
		if(vo.getPassword().trim().equals(request.getParameter("userPSS")))
		{
//			session.setMaxInactiveInterval(60*10);
			loginSession(request, mapper, vo);
			return "0";
		}
		else
		{
//			일치하지 않으면 1을 리턴시킨다.
			return "1";
		}
	}

//	email을 기준으로 DB에 있는 아이디를 받아온다.
	public String findID(MemberDAO mapper, HttpServletRequest request) 
	{
		String email = request.getParameter("userMail");
		findList = mapper.findID(email);
		
		logger.info(findList.toString());
		
		if(findList.isEmpty())
		{
			return "1";
		}
		
		return "0";
	}

	public String findPSS(MemberDAO mapper, HttpServletRequest request) 
	{
		String result = idChk(mapper, request);
		String result_json = "";
		
//		해당 아이디가 존재하지 않는 경우 함수 종료
		if(result == "1")
		{
			result_json = "{\"type\":\"1\", \"email\":\"\" }";
		}
		else
		{
//			입력받은 id로 DB에서 VO를 만들고
			MemberVO vo = mapper.mbSearch(request.getParameter("userID"));
			logger.info("입력받은 id로 vo객체 생성");
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(vo.getPassword());
			findList = temp;
			
			logger.info(findList.toString());
			
			result_json = "{\"type\":\"0\", \"email\":\"" + vo.getEmail() + "\" }";
			
		}
		
		return result_json;
	}

	public String logout(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		String name = getSessionName(request);
		session.invalidate();
		
		return name;
	}
	
	
	public Boolean saveAddress(HttpServletRequest request, MemberDAO mapper, MemberAddressVO vo) 
	{
		if(!addrList.isEmpty())
		{
			for(MemberAddressVO addr : addrList)
			{
				if(addr.getAddrName().equals(vo.getAddrName()))
				{
					return false;
				}
			}
		}
		
		String id = getSessionID(request);
		vo.setId(id);
//		logger.info(vo.getId());
//		logger.info(vo.toString());
		mapper.saveAddress(vo);
		addrList = findAddressID(mapper, id);
		return true;
//		logger.info("저장 완료");
	}
	
	public void updateAddress(HttpServletRequest request, MemberDAO mapper, MemberAddressVO vo) 
	{
		String id = getSessionID(request);
		vo.setId(id);
		String targetName = request.getParameter("targetAddrName");
//		vo정보에 없는 수정전 주소이름값을 넘겨줘야된다.
//		그래서 HashMap으로 수정할 정보를 담아 넘겨준다.
		HashMap<String, String> hmap = new HashMap<String, String>();
		hmap.put("targetName", targetName);
		hmap.put("id", id);
		hmap.put("addrName", vo.getAddrName());
		hmap.put("addr", vo.getAddr());
		hmap.put("detail_addr", vo.getDetail_addr());
		hmap.put("phone", vo.getPhone());
		hmap.put("memo", vo.getMemo());
		mapper.updateAddress(hmap);
		addrList = findAddressID(mapper, id);
	}
	
	public void deleteAddress(HttpServletRequest request, MemberDAO mapper, MemberAddressVO vo) 
	{
		String name = getSessionName(request);
		vo.setId(name);
		mapper.deleteAddress(vo);
		addrList = findAddressID(mapper, vo.getId());
	}
	
	public void updateMember(HttpServletRequest request, MemberDAO mapper) 
	{
		MemberVO vo = mapper.mbSearch(((MemberVO) request.getSession().getAttribute("loginVO")).getId());
		String nickname = request.getParameter("nickname");
		vo.setNickname(nickname);
		mapper.mbUpdate(vo);
//		받아온 값으로 id를 찾아 정보(nickname)을 DB에서 변경한 뒤
//		세션에 저장된 값 갱신을 위해 로그아웃과 로그인을 해준다.
		logout(request);
		loginSession(request, mapper, vo);
	}
	
//	addrName을 넘겨받은걸로 addrList에서 해당 주소정보를 찾아서 JSON형식으로 반환해주는 함수
	public String findAddressToJSON(String addrName) 
	{
		MemberAddressVO vo = null;
		for(MemberAddressVO addr : addrList)
		{
			if(addr.getAddrName().equals(addrName))
			{
				vo = addr;
//				logger.info("addrName으로 주소정보 찾기 성공\n" + vo.toString());
				break;
			}
		}
		String result_json = "";
		
		result_json = "{\"addrName\":\"" + vo.getAddrName() + "\", \"addr\":\"" + vo.getAddr() + "\", "
				+ "\"detail_addr\":\"" + vo.getDetail_addr() + "\", \"phone\":\"" + vo.getPhone() + "\","
				+ "\"memo\":\"" + vo.getMemo() + "\"}";
		
//		logger.info(result_json);
		
		return result_json;
	}
	
	
	
//	넘겨받은 id를 기준으로 해당 id가 가진 주소록을 찾아오는 함수
	private ArrayList<MemberAddressVO> findAddressID(MemberDAO mapper, String id)
	{
		return mapper.addrSearch(id);
	}
	
//	세션에 저장된 아이디이름을 받아오는 용도
	private String getSessionName(HttpServletRequest request)
	{
		return ((MemberVO) request.getSession().getAttribute("loginVO")).getName();
	}
	
//	세션에 저장된 아이디이름을 받아오는 용도
	private String getSessionID(HttpServletRequest request)
	{
		return ((MemberVO) request.getSession().getAttribute("loginVO")).getId();
	}
	
//	로그인 즉 vo를 세션에 저장하는 내용
	private void loginSession(HttpServletRequest request, MemberDAO mapper, MemberVO vo)
	{
		HttpSession session = request.getSession();
		session.setAttribute("loginVO", vo);
//		session.setMaxInactiveInterval(10);
		session.setMaxInactiveInterval(60 * 30);
		addrList = findAddressID(mapper, vo.getId());
		logger.info("로그인 계정: " + vo.toString());
	}


}
