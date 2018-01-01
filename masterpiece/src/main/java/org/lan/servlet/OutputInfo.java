package org.lan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class OutputInfo extends HttpServlet {
 
	private static final long serialVersionUID = 1246787305285912811L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=gb2312");

        Enumeration headNames=req.getHeaderNames();
        Map<String,String> headNameMap=new HashMap<>();
        while(headNames.hasMoreElements()){
            String name=(String)headNames.nextElement();
            String value=req.getHeader(name);
            headNameMap.put(name,value);
        }
        String remoteAddr=req.getRemoteAddr();
        Integer remotePort=req.getRemotePort();
        String localAddr=req.getLocalAddr();
        Integer localPort=req.getLocalPort();
        req.setAttribute("remoteAddr",remoteAddr);
        req.setAttribute("remotePort",remotePort);
        req.setAttribute("localAddr",localAddr);
        req.setAttribute("localPort",localPort);
        req.setAttribute("headNameMap",headNameMap);
        req.getRequestDispatcher("/jsp/info.jsp").forward(req,resp);
        /*ServletContext context=getServletContext();
        String path=context.getContextPath();
        System.out.println(path);
        resp.sendRedirect(path+"/jsp/InfoPage.jsp");*/


    }

}

