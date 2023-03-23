package project.controller.Shop;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.member.MemberAddressVO;
import project.member.MemberDAO;
import project.member.MemberService;
import project.util.mail.MailService;

@Controller
public class HomeController {
	
	@Autowired
	public SqlSession sqlSession;

	public MemberService mbService = new MemberService();
	@Autowired
	private MailService mailService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		
		
		return "main";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "loglegi/login_form";
	}
	
	@RequestMapping("/find_acount")
	public String findPss()
	{
		return "loglegi/findAcount";
	}
	
	@RequestMapping("/attentionLogin")
	public String attentionLogin()
	{
		return "loglegi/attention";
	}
	
//	인증 mail을 발생시키는 용도의 ajax요청
	@RequestMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(HttpServletRequest request)
	{
		String email = request.getParameter("email");
		
		logger.info(email);
		
		return mailService.joinEmail(email);
	}
	
//	아이디 찾기 mail을 발생시키는 용도의 ajax요청
	@RequestMapping("/mailFind")
	@ResponseBody
	public String mailFind(HttpServletRequest request)
	{
		String email = request.getParameter("email");
		
		logger.info(email);
		
		mailService.findEmail(email, mbService.findList);
		
		return "";
	}
	
	@RequestMapping(value="/logRegi", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String loginRegister(HttpServletRequest request)
	{
		MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
		//	어떤일을 할지 넘겨받는다.
		String kind = request.getParameter("SvtKind");
		String result;
		
//		아이디 체크를 해달라고 멤버 서비스에 정보를 넘겨준뒤 그 결과를 ajax로 리턴해준다.
		if(kind.equals("idChk"))
		{
//			logger.info("mbService idChk 호출");
			return result = mbService.idChk(mapper, request);			
		}
//		회원가입을 위해 넘어온 체크이다.
		else if(kind.equals("regiChk"))
		{
//			logger.info("mbService regiChk 호출");
			return result = mbService.regiChk(mapper, request);
		}
//		로그인용
		else if(kind.equals("login"))
		{
			return result = mbService.login(mapper, request);
		}
//		아이디 찾기용
		else if(kind.equals("findID"))
		{
			return result = mbService.findID(mapper, request);
		}
//		비밀번호 찾기용
		else if(kind.equals("findPSS"))
		{
			return result = mbService.findPSS(mapper, request);
		}
//		로그아웃 용
		else if(kind.equals("logout"))
		{
			return result = mbService.logout(request);
		}
		
		return "";
			
	}
	
	
	@RequestMapping("/mypage")
	public String mypage(Model model)
	{
		model.addAttribute("addrList", mbService.getAddrList());
		
		return "admin/mypage";
	}
	
	@RequestMapping("/mypage-update")
	public String mypageUpdate(Model model)
	{
		model.addAttribute("addrList", mbService.getAddrList());
		
		return "admin/mypageUpdate";
	}
	
	@RequestMapping(value="/address", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String addressAjax(HttpServletRequest request, MemberAddressVO vo)
	{
		MemberDAO mapper = sqlSession.getMapper(MemberDAO.class);
		String kind = request.getParameter("SvtKind");
//		logger.info(vo.toString());
		
		if(kind.equals("save"))
		{
			if(!mbService.saveAddress(request, mapper, vo))
			{
				return "fail";
			}
			else
			{
				return "true";
			}
		}
		else if(kind.equals("update"))
		{
			mbService.updateAddress(request, mapper, vo);
			return "update";
		}
		else if(kind.equals("del"))
		{
//			logger.info(vo.toString());
			mbService.deleteAddress(request, mapper, vo);
		}
		else if(kind.equals("memberUpdate"))
		{
			mbService.updateMember(request, mapper);
		}
		else if(kind.equals("findAddr"))
		{
//			logger.info("findAddr 컨트롤러 인식");
			return mbService.findAddressToJSON(vo.getAddrName());
		}
		
		
		
		
		return "true";
		
		
	}
	

	
}
