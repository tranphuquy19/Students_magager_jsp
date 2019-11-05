package controllers.student;

import models.BO.FacultyBO;
import models.Bean.Faculty;
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
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Boolean male = Boolean.valueOf(request.getParameter("male"));
        int faculty = Integer.parseInt(request.getParameter("facultyId"));
        System.out.println(id);
        System.out.println(name);
        System.out.println(male);
        System.out.println(faculty);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Faculty> faculties = new ArrayList<>();

        try {
            faculties = FacultyBO.getFaculties();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Validator val = new Validator();
        val.put("id", 123, true, "Được");
        val.put("name", "Trần Phú Quy", false, "Trống");
        val.put("facultyId", 2, true, "Nà ní");
        System.out.println(val.isOK());
        request.setAttribute(Constants.ATT_VALIDATOR, val);
        request.setAttribute(Constants.FACULTIES_LIST, faculties);
        request.getRequestDispatcher("/new-sv.jsp").forward(request, response);
    }
}
