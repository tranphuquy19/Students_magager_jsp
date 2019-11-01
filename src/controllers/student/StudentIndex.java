package controllers.student;

import utils.Constains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tranphuquy19@gmail.com
 * @since 01/11/2019
 */
@WebServlet("/students")
public class StudentIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().println(request.getSession().getAttribute(Constains.SS_LOGIN));
        request.getRequestDispatcher("/list-sv.jsp").forward(request, response);
    }
}
