package models.BO;

import models.Bean.Faculty;
import models.DAO.FacultyDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tranphuquy19@gmail.com
 * @since 02/11/2019
 */
public class FacultyBO {
    public static ArrayList<Faculty> getFaculties() throws SQLException, ClassNotFoundException {
        ArrayList<Faculty> faculties = new ArrayList<>();
        ResultSet rs = FacultyDAO.getFacultiesResultSet();
        while(rs.next()){
            Faculty faculty = new Faculty();
            faculty.setId(rs.getInt("id"));
            faculty.setName(rs.getString("name"));
            faculties.add(faculty);
        }
        return faculties;
    }
}
