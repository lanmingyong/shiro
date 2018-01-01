package com.guoxin.common.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 系统基础控制层
 * @author Rocye
 * @createTime 2015-10-14
 */
public abstract class BaseController {

    /**
     * 获取HttpSession
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    /**
     * 获取HttpServletRequest
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    
    /**
     * 获取HttpServletResponse
     * @author Rocye
     * @createTime 2015-10-14
     */
    public HttpServletResponse getResponse() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getResponse();
    }
    
    /**
     * 返回响应对象
     * @author Rocye
     * @createTime 2016-12-06
     */
    public ResponseObj getResponse(int errcode, String msg){
        return new ResponseObj(errcode, msg);
    }
    
    /**
     * 返回响应对象仅编码
     * @author Rocye
     * @createTime 2016-12-06
     */
    public ResponseObj getResponse(int errcode){
        return new ResponseObj(errcode);
    }
}
