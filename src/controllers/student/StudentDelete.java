package controllers.student;

import models.BO.FacultyBO;
import models.BO.StudentBO;
import models.Bean.Faculty;
import models.Bean.Student;
import utils.Constants;
import utils.Validator;

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
@WebServlet("/students-delete")
public class StudentDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Student student = StudentBO.getStudentById(id);
            if (student != null) {
                ArrayList<Faculty> faculties = FacultyBO.getFaculties();
                request.setAttribute(Constants.FACULTIES_LIST, faculties);
                request.setAttribute(Constants.ATT_STUDENT, student);
                request.getRequestDispatcher("/delete-sv.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
