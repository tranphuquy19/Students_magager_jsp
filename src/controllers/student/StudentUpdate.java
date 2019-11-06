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
@WebServlet("/students-update")
public class StudentUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Boolean isMale = Boolean.valueOf(request.getParameter("isMale"));
        int facultyId = Integer.parseInt(request.getParameter("facultyId"));

        Validator validator = StudentBO.updateStudent(id, name, isMale, facultyId);

        if (validator.isOK()) {
            response.sendRedirect(request.getContextPath() + "/students");
        } else {
            Student student = new Student();
            ArrayList<Faculty> faculties = new ArrayList<>();

            try {
                student = StudentBO.getStudentById(id);
                faculties = FacultyBO.getFaculties();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            request.setAttribute(Constants.ATT_VALIDATOR, validator);
            request.setAttribute(Constants.FACULTIES_LIST, faculties);
            request.setAttribute(Constants.ATT_STUDENT, student);
            request.getRequestDispatcher("/update-sv.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Student student = StudentBO.getStudentById(id);
            if (student != null) {
                ArrayList<Faculty> faculties = FacultyBO.getFaculties();
                request.setAttribute(Constants.FACULTIES_LIST, faculties);
                request.setAttribute(Constants.ATT_VALIDATOR, new Validator());
                request.setAttribute(Constants.ATT_STUDENT, student);
                request.getRequestDispatcher("/update-sv.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
