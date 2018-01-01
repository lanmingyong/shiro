package com.guoxin.common.security;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 为扩展Ajax请求验证重新定义RolesAuthorizationFilter
 * @author Rocye
 * @createTime 2016-12-06
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {
	
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;  
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
		Subject subject = getSubject(request, response);
		
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
        	if(httpRequest.getHeader("gxAjax") != null && httpRequest.getHeader("gxAjax").equals("true")){
        		httpResponse.getWriter().write("{\"errcode\":-2}");		//登录超时
        	}else{
        		saveRequestAndRedirectToLogin(request, response);
        	}
        } else {
        	if(httpRequest.getHeader("gxAjax") != null && httpRequest.getHeader("gxAjax").equals("true")){
        		httpResponse.getWriter().write("{\"errcode\":-3}");		//没有权限访问
        	}else{
        		// If subject is known but not authorized, redirect to the unauthorized URL if there is one
        		// If no unauthorized URL is specified, just return an unauthorized HTTP status code
        		String unauthorizedUrl = getUnauthorizedUrl();
        		//SHIRO-142 - ensure that redirect _or_ error code occurs - both cannot happen due to response commit:
        		if (StringUtils.hasText(unauthorizedUrl)) {
        			WebUtils.issueRedirect(request, response, unauthorizedUrl);
        		} else {
        			WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
        		}
        	}
        }
        return false;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        Set<String> roles = CollectionUtils.asSet(rolesArray);
        //return subject.hasAllRoles(roles);	//改成只要有其中一个角色存在就通过验证
        for(String role : roles){
        	if(subject.hasRole(role)){
        		return true;
        	}
        }
        return false;
	}

}
