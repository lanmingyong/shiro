package com.guoxin.common.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * 解决Ajax登录超时跳转
 * @author Rocye
 * @createTime 2016-12-06
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(httpRequest.getHeader("gxAjax") != null && httpRequest.getHeader("gxAjax").equals("true")){
        	if (!isLoginRequest(request, response)) {
        		httpResponse.getWriter().write("{\"errcode\":-2}");		//登录超时
        		return false;
        	}else{
        		return super.onAccessDenied(request, response);
        	}
    	}else{
    		return super.onAccessDenied(request, response);
    	}
	}
	
}
