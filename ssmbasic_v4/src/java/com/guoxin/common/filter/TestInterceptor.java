/**
 * 
 */
package com.guoxin.common.filter;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.guoxin.common.base.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * 
 */
public class TestInterceptor extends HandlerInterceptorAdapter {

	/**
	 * @param args
	 */
	private final static String URL_LOGIN = "/timeout";

	private List<String> excludedUrls;

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object arg2) throws Exception {
		
			String requestUrl = request.getRequestURI();
			System.out.println(requestUrl);
			for (String url : excludedUrls) {
				if (requestUrl.endsWith(url)) {
					return true;
				}
			}
		
		HttpSession session = request.getSession();
		if (session.getAttribute(Constants.LOGIN_KEY) == null) {
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath() + URL_LOGIN);
		return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub


	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {


	}

}
