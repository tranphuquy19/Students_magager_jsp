package controllers.student;

import models.BO.FacultyBO;
import models.BO.StudentBO;
import models.Bean.Faculty;
import models.Bean.Student;
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
 * @since 02/11/2019
 */
@WebServlet("/students-search")
public class StudentSearch extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        String keyword = request.getParameter("key");

        try {
            students = StudentBO.findStudents(keyword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute(Constants.STUDENTS_LIST, students);
        request.getRequestDispatcher("/search-results.jsp").forward(request, response);
    }
}
