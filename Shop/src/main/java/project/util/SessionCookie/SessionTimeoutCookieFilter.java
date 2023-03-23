package project.util.SessionCookie;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	Servlet Filter를 이용하여 쿠키에 서버시간 및 세션만료 예정시간을 기록하기 위한 클래스
public class SessionTimeoutCookieFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException 
	{
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		long serverTime = System.currentTimeMillis();
		long sessionExpiryTime = serverTime + request.getSession().getMaxInactiveInterval() * 1000;
		
		Cookie cookie = new Cookie("latestTouch", Long.toString(serverTime));
//		쿠키 전송범위 : 웹어플리케이션의 모든 URL 범위에서 전송
		cookie.setPath("/");
		
		response.addCookie(cookie);
		
		cookie = new Cookie("sessionExpiry", "" + sessionExpiryTime);
        cookie.setPath("/");
        response.addCookie(cookie);
        
        cookie = new Cookie("maxInactiveInterval", "" + request.getSession().getMaxInactiveInterval());
        cookie.setPath("/");
        response.addCookie(cookie);
        
		filterChain.doFilter(servletRequest, servletResponse);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException 
	{
	}


	@Override
	public void destroy() 
	{
		
	}
}
