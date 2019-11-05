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
@WebServlet("/students-create")
public class StudentCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Boolean male = Boolean.valueOf(request.getParameter("isMale"));
        int faculty = Integer.parseInt(request.getParameter("facultyId"));
        try {
            Validator validator = StudentBO.addStudent(id, name, male, faculty);
            if (!validator.isOK()) {
                ArrayList<Faculty> faculties = FacultyBO.getFaculties();

                request.setAttribute(Constants.FACULTIES_LIST, faculties);
                request.setAttribute(Constants.ATT_VALIDATOR, validator);
                request.getRequestDispatcher("/new-sv.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/students");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.getRequestDispatcher("/new-sv.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Faculty> faculties = new ArrayList<>();

        try {
            faculties = FacultyBO.getFaculties();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute(Constants.ATT_VALIDATOR, new Validator());
        request.setAttribute(Constants.FACULTIES_LIST, faculties);
        request.getRequestDispatcher("/new-sv.jsp").forward(request, response);
    }
}
