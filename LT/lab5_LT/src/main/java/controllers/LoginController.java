package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
        rd.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String email =req.getParameter("email");
        String password =req.getParameter("pwd");

        if (email.equals("admin@app.com") && password.equals("123")) {
            Cookie cookie= new Cookie("email", email);
            cookie.setMaxAge(30);
            resp.addCookie(cookie);
            resp.sendRedirect("/lab5_LT_war/");
        }else {
            resp.sendRedirect("/lab5_LT_war/login");
        }

    }

}
