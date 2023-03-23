package project.controller.Shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import project.controller.Shop.HomeController;

//	로그인이 필요한 페이지 이동시 공통적으로 검사해주기 위한 인터셉터 클래스
public class LoginInterceptor extends HandlerInterceptorAdapter
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	String[] exceptionURL = {"http://localhost:9090/Shop/login/", "http://localhost:9090/Shop/",
			"http://localhost:9090/Shop/attentionLogin", "http://localhost:9090/Shop/find_acount/"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception 
	{
//		ajax 요청인지 먼저 검사해 ajax요청은 무조건 통과시켜준다.
		if("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) return true;
		
//		spring 3.1 이하에서는 exclude-mapping이 없어서 이렇게 예외로 할 url을 검사해줘야 한다.
		String requestUrl = request.getRequestURL().toString();
		
//		그 다음 리소스 요청도 무조건 통과시켜준다.
		if(requestUrl.contains("/resources")) return true;
		
		
		
		for(String url : exceptionURL)
		{
//			logger.info(requestUrl + ": 주소를 확인중");
			if(requestUrl.equals(url)) return true;
		}
		
		
//		logger.info("LoginInterceptor 실행");
		if(request.getSession().getAttribute("loginVO") == null)
		{
//			logger.info("인터셉터에서 로그인이 안되어있다고 판단");
			response.sendRedirect("/Shop/attentionLogin");
			
			return false;
		}
		
//		logger.info("인터셉터에서 로그인상태라고 판단");
		
		
		return true;
	}


}
