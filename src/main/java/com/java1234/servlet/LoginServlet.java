package com.java1234.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Songx on 2018/3/10 0010.
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login doget");
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login dopost");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            System.out.println("sessionId:" + session.getId());
            System.out.println("Host:" + session.getHost());
            System.out.println("Timeout:" + session.getTimeout());
            System.out.println("LastAccessTime:" + session.getLastAccessTime());
            System.out.println("StartTimestamp:" + session.getStartTimestamp());
            resp.sendRedirect("success.jsp");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }
    }
}
