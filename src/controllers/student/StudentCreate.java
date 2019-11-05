package controllers.student;

import models.BO.FacultyBO;
import models.Bean.Faculty;
import utils.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tranphuquy19@gmail.com
 * @since 01/11/2019
 */
@WebServlet("/students-create")
public class StudentCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Faculty> faculties = new ArrayList<>();

        try{
            faculties = FacultyBO.getFaculties();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute(Constants.FACULTIES_LIST, faculties);
        request.getRequestDispatcher("/new-sv.jsp").forward(request, response);
    }
}
