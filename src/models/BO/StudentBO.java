package models.BO;

import models.Bean.Student;
import models.DAO.StudentDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author tranphuquy19@gmail.com
 * @since 31/10/2019
 */
public class StudentBO {
    public static ArrayList<Student> getStudents() throws SQLException, ClassNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = StudentDAO.getStudents();
        while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMale(rs.getBoolean("male"));
            student.setFaculty(rs.getString("faculty"));
            students.add(student);
        }
        return students;
    }

    public static ArrayList<Student> getStudentsByFacultyId(int facultyId) {
        ArrayList<Student> students = new ArrayList<>();

        return students;
    }

    public static ArrayList<Student> findStudents(String key) {
        ArrayList<Student> students = new ArrayList<>();

        return students;
    }

    public boolean createStudent(Student student) {
        return true;
    }

    public boolean updateStudent(Student student) {
        return true;
    }

    public boolean deleteStudent(Student student) {
        return true;
    }
}
