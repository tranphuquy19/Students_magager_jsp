package controllers;

import models.BO.UserBO;
import models.Bean.User;
import utils.Constains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = UserBO.getUser(username, password);
        if(user != null){
            req.getRequestDispatcher("/list-sv.jsp").forward(req, resp);
        }else{
            req.setAttribute(Constains.ATT_LOGIN_FAILED, true);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
