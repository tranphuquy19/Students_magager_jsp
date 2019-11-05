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
 * @since 01/11/2019
 */
@WebServlet("/students")
public class StudentIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Faculty> faculties = new ArrayList<>();

        String facultyId = request.getParameter("facultyId");
        try {
            if (facultyId != null && !Constants.DEFAULT_SELECTED.equals(facultyId)) {
                students = StudentBO.getStudentsByFacultyId(Integer.parseInt(facultyId));
            } else students = StudentBO.getStudents();
            faculties = FacultyBO.getFaculties();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute(Constants.STUDENTS_LIST, students);
        request.setAttribute(Constants.FACULTIES_LIST, faculties);
        request.getRequestDispatcher("/list-sv.jsp").forward(request, response);
    }
}
