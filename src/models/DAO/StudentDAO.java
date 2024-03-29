package models.DAO;

import database.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class StudentDAO {
    public static ResultSet getStudents() throws SQLException, ClassNotFoundException {
        String sqlString = "SELECT student.id, student.name, student.male, faculty.name as faculty FROM student, faculty WHERE student.faculty_id = faculty.id";

        Statement statement = DBConnect.getConnection().createStatement();
        return statement.executeQuery(sqlString);
    }

    public static ResultSet getStudentsByFacultyId(int facultyId) throws SQLException, ClassNotFoundException {
        String preSqlString = "SELECT student.id, student.name, student.male, faculty.name AS faculty FROM student inner JOIN faculty ON student.faculty_id = faculty.id WHERE faculty.id = ?";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
        preparedStatement.setInt(1, facultyId);
        return preparedStatement.executeQuery();
    }

    public static ResultSet getStudentById(int id) throws SQLException, ClassNotFoundException {
        String preSqlString = "SELECT student.id, student.name, student.male, faculty.name AS faculty FROM student inner JOIN faculty ON student.faculty_id = faculty.id WHERE student.id = ?";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }

    public static Boolean addStudentWithId(int id, String name, boolean isMale, int facultyId) {
        String preSqlString = "INSERT INTO student(id, name, male, faculty_id) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(isMale ? 1 : 0));
            preparedStatement.setString(4, String.valueOf(facultyId));
            return preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean updateStudentWithId(int id, String name, boolean isMale, int facultyId) {
        String preSqlString = "UPDATE student SET name = ?, male = ?, faculty_id = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, String.valueOf(isMale ? 1 : 0));
            preparedStatement.setString(3, String.valueOf(facultyId));
            preparedStatement.setString(4, String.valueOf(id));
            return preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean deteleStudentById(int id) {
        String preSqlString = "DELETE FROM student WHERE student.id = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ResultSet findStudentsByKey(String key) throws SQLException, ClassNotFoundException {
        key = "%" + key + "%";
        String preSqlString = "SELECT s.id, s.name, s.male, f.name as faculty FROM student s inner JOIN faculty f ON s.faculty_id = f.id WHERE s.id LIKE ? OR s.name LIKE ? OR f.name LIKE ?";
        PreparedStatement preparedStatement = DBConnect.getConnection().prepareStatement(preSqlString);
        preparedStatement.setString(1, key);
        preparedStatement.setString(2, key);
        preparedStatement.setString(3, key);
        return preparedStatement.executeQuery();
    }
}
