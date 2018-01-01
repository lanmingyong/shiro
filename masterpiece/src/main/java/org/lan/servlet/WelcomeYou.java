package org.lan.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeYou extends HttpServlet {

	private static final long serialVersionUID = -1477951589593121377L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String user=request.getParameter("user");
        String welcomeInfo="Welcome you, "+user;
        response.setContentType("text/html;charset=gb2312");
        try{
            PrintWriter out=response.getWriter();
            out.println("<html><head><title>");
            out.println("Welcome Page");
            out.println("</title></head>");
            out.println("<body>");
            out.println(welcomeInfo);
            out.println("</body></html>");
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void  doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
