package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/","/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email ="";

        Cookie[] cookies=req.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equals("email")) {
                email=c.getValue();
            }
        }
//        RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
//        rd.forward(req, resp);
        if (email.equals("")) {
            resp.sendRedirect("/lab5_LT_war/login");
        }
        else {
            req.setAttribute("email",email);
            RequestDispatcher rd = req.getRequestDispatcher("/views/home.jsp");
            rd.forward(req, resp);
        }

    }


}
